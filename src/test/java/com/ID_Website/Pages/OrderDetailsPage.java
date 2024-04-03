package com.ID_Website.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.ID_Website.utilities.BaseClass;
import com.ID_Website.utilities.ReadConfig;

public class OrderDetailsPage extends BaseClass {
	static ReadConfig readconfig=new ReadConfig();
	
	public static String mobile_num = readconfig.getMobileNumber();
    public static String otp = readconfig.getOtp();
	public static String name = readconfig.getName();
    public static String email = readconfig.getEmail();
	public static String city = readconfig.getCity();
	public static String pincode = readconfig.getPincode();

									
	
	static By mobile_field= By.xpath("//input[@id='customer_mobile']");
	static By send_verif_code= By.xpath("//button[contains(text(),'Send verification code')]");
	static By otp_field= By.xpath("//input[@id='otp'][@type='text']");
	static By confirm= By.xpath("//button[@id='verifyBtn']");
	static By customer_name_field= By.xpath("//input[@id='customer_fname']");
	static By customer_email_field= By.xpath("//input[@id='customer_email']");
	static By customer_city_field= By.xpath("//input[@id='customer_city_name']");
	static By customer_pincode_field= By.xpath("//input[@id='customer_pincode']");
	static By lang_selection= By.xpath("//select[@id='lang_spec']");
	static By watsapp_checkbox= By.xpath("//input[@id='m_o_c1']");
	
	static By call_checkbox= By.xpath("//input[@id='m_o_c2']");
	static By time_checkbox= By.xpath("//label[normalize-space()='10 am - 1 pm']");
	
	
	static By I_agree_to_checkbox= By.xpath("//div[@class='row']/div[12]/label/input");
	static By next= By.xpath("//button[@id='btnCheckout'][@type='submit']");
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");
	
	
	static By rating= By.xpath("//div[@class='rating']//a[contains(text(),'4')]");
	static By comment= By.xpath("//textarea[@name='comment']");
	static By submit_button= By.xpath("//div[@id='feedbackform']/form/div/button");
	
	static By thankyou_text=By.xpath("//section[@id='my-cart']//following::h5[text()='Thank you!']");
	
	
	
	public static void orderDetails() throws InterruptedException {
		
		//driver.findElement(mobile_field).sendKeys("6280000000");
		driver.findElement(mobile_field).sendKeys(mobile_num);
		System.out.println("Provided mobile num");
		driver.findElement(send_verif_code).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {

			 WebElement PAW_toast_msg=driver.findElement(toast_msg);   	
		    	String Act_Text=PAW_toast_msg.getText();
		    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
		    	logger.info(driver.findElement(toast_msg).getText());
				}
		
		catch(Exception e) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			//driver.findElement(otp_field).sendKeys("9999");
			driver.findElement(otp_field).sendKeys(otp);
			System.out.println("Provided otp");
			logger.info("Provided otp");
			driver.findElement(confirm).click();
		
			driver.findElement(customer_name_field).clear();
			//driver.findElement(customer_name_field).sendKeys("testab");
			driver.findElement(customer_name_field).sendKeys(name);
			System.out.println("name provided");
			logger.info("name provided");
			
			driver.findElement(customer_email_field).clear();
			//driver.findElement(customer_email_field).sendKeys("testab@gmail.com");
			driver.findElement(customer_email_field).sendKeys(email);
			System.out.println("email provided");
			logger.info("email provided");
			
			
			driver.findElement(customer_city_field).clear();
			//driver.findElement(customer_city_field).sendKeys("Chennai");
			driver.findElement(customer_city_field).sendKeys(city);
			System.out.println("city provided");
			logger.info("city provided");
			
			
			driver.findElement(customer_pincode_field).clear();
			//driver.findElement(customer_pincode_field).sendKeys("12345");
			driver.findElement(customer_pincode_field).sendKeys(pincode);
			System.out.println("pincode provided");
			logger.info("pincode provided");
			
			Select st=new Select(driver.findElement(lang_selection));
			st.selectByVisibleText("EN");
			System.out.println("language dropdown changed to EN");
			logger.info("language dropdown changed to EN");
			
			WebElement watsapp_check=driver.findElement(watsapp_checkbox);
			System.out.println(" watsapp_check Element Identified");
			
			
			
			if(watsapp_check.isSelected()==false) {
				watsapp_check.click();
			System.out.println("watsapp selected");
			logger.info("watsapp selected");
			}
			

			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			System.out.println(" I_agree_to Before clicking");
			WebElement I_agree_to=driver.findElement(I_agree_to_checkbox);
			System.out.println(" I_agree Element Identified");
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", I_agree_to);
			System.out.println("Scrolled into the I_agree_to_checkbox");
			
			
			
			if(I_agree_to.isSelected()==false) {
				//
				System.out.println("I_agree_to is not selected, then check");
				Thread.sleep(3000);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
				I_agree_to.click();
			System.out.println("I_agree_to selected");
			logger.info("I_agree_to selected");
			}
			
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			Thread.sleep(3000);
			
			System.out.println("Before checkout completed");
			WebElement next_button=driver.findElement(next);
			js.executeScript("arguments[0].scrollIntoView({block:'center'});",next_button);
			next_button.click();
			System.out.println("checkout completed");
			logger.info("checkout completed");
			
			System.out.println("Before ratings and reviews");

			WebElement ratingElement=driver.findElement(rating);
			System.out.println("Element rating Identified");
			
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", ratingElement);
			System.out.println("Scrolled into the rating Element");
			
			Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

			ratingElement.click();
			System.out.println("provided rating");
			logger.info("provided rating");
			
			

			driver.findElement(comment).sendKeys("autest");
			System.out.println("provided comments");
			logger.info("provided comments");

			WebElement submit=driver.findElement(submit_button);
			
			js.executeScript("arguments[0].scrollIntoView({block:'center'});", submit);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			Thread.sleep(3000);
		    submit.click();
			System.out.println("submitted ratings and reviews");
			logger.info("submitted ratings and reviews");
			
			js.executeScript("window.scrollTo(0, 0)");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			}
		
		
	
	
	
	public static void orderDetailsCall() throws InterruptedException {
		
		driver.findElement(mobile_field).sendKeys("6280000000");
		System.out.println("Provided mobile num");
		driver.findElement(send_verif_code).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		try {
			WebElement PAW_toast_msg=driver.findElement(toast_msg);   	
	    	String Act_Text=PAW_toast_msg.getText();
	    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
	    	logger.info(driver.findElement(toast_msg).getText());
			}
		
		catch(Exception e) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	
		driver.findElement(otp_field).sendKeys("9999");
		System.out.println("Provided otp");
		logger.info("Provided otp");
		driver.findElement(confirm).click();
	
		driver.findElement(customer_name_field).clear();
		driver.findElement(customer_name_field).sendKeys("testabcall");
		System.out.println("name provided");
		logger.info("name provided");
		
		driver.findElement(customer_email_field).clear();
		driver.findElement(customer_email_field).sendKeys("testabcall@gmail.com");
		System.out.println("email provided");
		logger.info("email provided");
		
		
		driver.findElement(customer_city_field).clear();
		driver.findElement(customer_city_field).sendKeys("Chennaicall");
		System.out.println("city provided");
		logger.info("city provided");
		
		
		driver.findElement(customer_pincode_field).clear();
		driver.findElement(customer_pincode_field).sendKeys("12346");
		System.out.println("pincode provided");
		logger.info("pincode provided");
		
		Select st=new Select(driver.findElement(lang_selection));
		st.selectByVisibleText("ID");
		System.out.println("language dropdown changed to ID");
		logger.info("language dropdown changed to ID");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println(" Before call checkbox clicking");
		WebElement call_check=driver.findElement(call_checkbox);
		System.out.println(" call_check Element Identified");
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", call_check);
		System.out.println("Scrolled into the call checkbox");
		
		
		
		if(call_check.isSelected()==false) {
			//
			System.out.println("call check is not selected, then check");
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			call_check.click();
		System.out.println("call checkbox checked");
		logger.info("call checkbox checked");
		}
		

		Thread.sleep(3000);
		
		driver.findElement(time_checkbox).click();
		System.out.println("time checked");
		logger.info("time checked");
		
		
		System.out.println(" I_agree_to Before clicking");
		WebElement I_agree_to=driver.findElement(I_agree_to_checkbox);
		System.out.println(" I_agree Element Identified");
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", I_agree_to);
		System.out.println("Scrolled into the I_agree_to_checkbox");
		
		
		
		if(I_agree_to.isSelected()==false) {
			//
			System.out.println("I_agree_to is not selected, then check");
			Thread.sleep(3000);
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			I_agree_to.click();
		System.out.println("I_agree_to selected");
		logger.info("I_agree_to selected");
		}
		
		
		System.out.println("Before checkout completed");
		WebElement next_button=driver.findElement(next);
		js.executeScript("arguments[0].scrollIntoView({block:'center'});",next_button);
		next_button.click();
		System.out.println("checkout completed");
		logger.info("checkout completed");
		
		System.out.println("Before ratings and reviews");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		WebElement ratingElement=driver.findElement(rating);
		System.out.println("Element rating Identified");
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", ratingElement);
		System.out.println("Scrolled into the rating Element");
		
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

		ratingElement.click();
		System.out.println("provided rating");
		logger.info("provided rating");
		
		

		driver.findElement(comment).sendKeys("autest");
		System.out.println("provided comments");
		logger.info("provided comments");

		WebElement submit=driver.findElement(submit_button);
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", submit);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		Thread.sleep(3000);
	    submit.click();
		System.out.println("submitted ratings and reviews");
		logger.info("submitted ratings and reviews");
		
		js.executeScript("window.scrollTo(0, 0)");
	
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	    
		}

	
	}


