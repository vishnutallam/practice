package com.ID_Website.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	
	public String baseURL = readconfig.getApplicationURL();
	public static WebDriver driver;
	public static Logger logger;
	public static ExtentReports extentReports;
	public static ExtentTest extentTest;
	//public static String screenshotsSubFolderName;
	@Parameters("browserName")
	@BeforeClass
	public void setup(String browserName) throws InterruptedException {
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
//		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);
		
//		WebDriverManager.chromedriver().setup();
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		driver = new ChromeDriver(options);

		System.out.println("Browser name is: "+browserName);
		System.out.println("Thread id: "+Thread.currentThread().getId());
if(browserName.equalsIgnoreCase("chrome")) {
	WebDriverManager.chromedriver().setup();
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new ChromeDriver(options);
}
else if(browserName.equalsIgnoreCase("firefox")) {
	WebDriverManager.firefoxdriver().setup();
	FirefoxOptions options = new FirefoxOptions();
	options.addArguments("--remote-allow-origins=*");
	driver = new FirefoxDriver(options);
	//driver=new FirefoxDriver();
}
else if(browserName.equalsIgnoreCase("edge")) {
	WebDriverManager.edgedriver().setup();
	EdgeOptions op = new EdgeOptions();
	op.addArguments("--remote-allow-origins=*");
    driver= new EdgeDriver(op);
}		

		logger=Logger.getLogger("ID_Website");
		PropertyConfigurator.configure("Log4j.properties");
	
		driver.navigate().to(baseURL);
        Thread.sleep(3000);
		driver.manage().window().maximize();
		System.out.println("Application Opened");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		//Thread.sleep(3000);

	}
	
	@AfterTest
	public static void SendingMail() throws AddressException, IOException, MessagingException{
		
		Runtime r=Runtime.getRuntime();  	  
		r.addShutdownHook(new Thread(){  
		public void run(){  
			Mailing sm = new Mailing();
			try {
				sm.mail();
				System.out.println("Report has been sent"); 
			} catch (IOException | MessagingException e) {
				e.printStackTrace();
			}
			
		    }  
		}  
		);  
		try{Thread.sleep(5000);}catch (Exception e) 
		{
			System.out.println(e);
		}  
		//driver.quit();
		
		}
	

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		
		
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}
