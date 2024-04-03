package com.ID_Website.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;

public class ProductDetailPage extends BaseClass{
	
	static By product= By.xpath("//div[@class='product-itm product-0']//a[1]");
	static By productName= By.xpath("//div[@class='w-100']//h1");
	static By product_price_size= By.xpath("//div[@class='w-100']//h5");
	static By product_interested= By.xpath("//div[@class='w-100']//button");
	static By product_wishlist= By.xpath("//img[@id='cart_heart_img']");
	static By increase_quantity= By.xpath("//div[@class='quantity']/button[2]");
	static By checkout_next= By.xpath("//a[contains(text(),'NEXT')]");
	static By toast_msg= By.xpath("//div[@id='toast-container']/div/div");
	
	//html/body/div[5]/div/div
	
	public static void productCart() {
		
    	driver.findElement(product).click();
    	
    	
    	System.out.println("product name "+driver.findElement(productName).getText());
    	logger.info("product name "+driver.findElement(productName).getText());
    	
    
    	System.out.println("product price and size "+driver.findElement(product_price_size).getText());
    	logger.info("product price and size "+driver.findElement(product_price_size).getText());


		driver.findElement(product_interested).click();
    	System.out.println("product_interested Clicked successfully");
    	WebElement PAW_toast_msg=driver.findElement(toast_msg);
    	
    	String Act_Text=PAW_toast_msg.getText();
    	
    	
    	
    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    	logger.info(driver.findElement(toast_msg).getText());
    
    	Assert.assertTrue(Act_Text.contains("PRODUCT ADDED TO WISHLIST"));


    	
	}

}
