package com.ID_Website.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;

public class SearchPage extends BaseClass {
	
	
	static By search_field=By.xpath("//input[@id='search']");
	static By search_button=By.xpath("//div[@class='container']//div[1]/button");
	static By search_productName= By.xpath("//div[@class='container']//div[1]/div[1]/div[1]/a/h4");
	///html/body/section[1]/div[2]/div/div/div/a/h4
	///html/body/section[1]/div[2]/div/div[1]/div/a/h4
	static By search_product_price_size= By.xpath("//div[@class='container']//div[1]/div[1]/div[1]/a/p[2]");
	static By search_interested= By.xpath("//section[@class='product-cat']/div[2]/div/div[1]/div/button/i");
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");
	
	
	
	public static void searching() throws InterruptedException {
		
		driver.findElement(search_field).sendKeys("chai testing");
		driver.findElement(search_button).click();
		System.out.println("searched with 'chai testing'");
		
		
		System.out.println("product name "+driver.findElement(search_productName).getText());
		logger.info("product name "+driver.findElement(search_productName).getText());
    	
	    
    	System.out.println("product price and size "+driver.findElement(search_product_price_size).getText());
    	logger.info("product price and size "+driver.findElement(search_product_price_size).getText());
    	
    //	Thread.sleep(3000);
    	WebElement search_int=driver.findElement(search_interested);
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", search_int);
    	//search_int.click();
    	
//    	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(search_interested));
//    	driver.findElement(search_interested).click();
    	Thread.sleep(3000);
    	search_int.click();
    	System.out.println("Search Product added to wishlist");
    	logger.info("Search Product added to wishlist");
    	
    	
    	WebElement PAW_toast_msg=driver.findElement(toast_msg);
    	String Act_Text=PAW_toast_msg.getText();
    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    	logger.info(driver.findElement(toast_msg).getText());
    	    	
    	Assert.assertTrue(Act_Text.contains("PRODUCT ADDED TO WISHLIST"));
    	
    	
	}

}
