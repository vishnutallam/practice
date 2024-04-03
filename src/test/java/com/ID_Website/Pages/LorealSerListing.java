package com.ID_Website.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;

public class LorealSerListing extends BaseClass{
	
	static By service_Interest=By.xpath("//div[@class='row']/div[2]/a[2]/button");
	static By service_price_duration=By.xpath("//div[@class='row']/div[2]/a[1]/p[2]");
	static By serviceName=By.xpath("//div[@class='row']/div[2]/a[1]/h4");
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");
	
public static void pro_ser_cart() {
		
    	
    	
    	
    	
    	System.out.println("service name "+driver.findElement(serviceName).getText());
    	logger.info("service name "+driver.findElement(serviceName).getText());
    	
    	System.out.println("service price and duration "+driver.findElement(service_price_duration).getText());
    	logger.info("service price and duration "+driver.findElement(service_price_duration).getText());
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    	driver.findElement(service_Interest).click();
    	
    	
    			WebElement PAW_toast_msg=driver.findElement(toast_msg);
    			String Act_Text=PAW_toast_msg.getText();
    			System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    			logger.info(driver.findElement(toast_msg).getText());
    			    	
    			Assert.assertTrue(Act_Text.contains("SERVICE ADDED TO WISHLIST"));
    			
    	System.out.println("Service added to wishlist");
}

}
