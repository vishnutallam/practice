package com.ID_Website.utilities;

//Listener class used to generate Extent reports
import java.io.File;
import java.io.IOException;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter 
{
	//public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentSparkReporter spark;
		
	public void onStart(ITestContext testContext)
	{
////		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
////		String repName="Test-Report-"+timeStamp+".html";
//	String repName="Test-Report.html";
//		
//	//	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Reports/"+repName);
//	//	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location of the report
//		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/Screenshots/"+repName);
//		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
//		
//		extent=new ExtentReports();
		
		String repName="Test-Report.html";
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir")+ "/Screenshots/"+repName);
        extent.attachReporter(spark);
        try {
			spark.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("user","vishnu");
		
		spark.config().setDocumentTitle("Socomm ID Website"); // Tile of report
		spark.config().setReportName("Test Automation Report"); // name of the report
		//spark.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
		spark.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName()); // create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		//logger.fail("Screenshot is below:" +MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));
		}	
		//logger.addScreenCaptureFromPath(screenshotPath)
	
	}
    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}
}

