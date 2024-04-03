package com.ID_Website.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;

public class ServiceDetailPage extends BaseClass{
	
	static By service=By.xpath("//div[@class='row']/div[3]/a/img");
	
	static By serviceName=By.xpath("//*[@id='product_detail']/div/div/div[2]/div[1]/div/h1");
	static By service_price=By.xpath("//h5[contains(text(),'Starting from')]");
	static By service_Interest=By.xpath("//button[@class='btn btn-style mt-0']");
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");
	//static By service_wishlist=By.xpath("//html/body/header/nav/div/a[3]/img");
	
	static By service_Next=By.xpath("//a[contains(text(),'NEXT')]");
	
	public static void serviceCart() throws InterruptedException {
		
		
    	driver.findElement(service).click();
    	
    	System.out.println("service name "+driver.findElement(serviceName).getText());
    	logger.info("service name "+driver.findElement(serviceName).getText());
    	
    	
    	System.out.println("Service price "+driver.findElement(service_price).getText());
    	logger.info("Service price "+driver.findElement(service_price).getText());
    	
    	
    	driver.findElement(service_Interest).click();
    	System.out.println("service added to wishlist");
    	logger.info("service added to wishlist");
    	
    	WebElement PAW_toast_msg=driver.findElement(toast_msg);
    	String Act_Text=PAW_toast_msg.getText();
    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    	logger.info(driver.findElement(toast_msg).getText());
    	    	
    	Assert.assertTrue(Act_Text.contains("SERVICE ADDED TO WISHLIST"));
    	

		
	}
	
	

}
