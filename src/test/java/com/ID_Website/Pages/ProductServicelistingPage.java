package com.ID_Website.Pages;

import java.time.Duration;

import org.openqa.selenium.By;

import com.ID_Website.utilities.BaseClass;

public class ProductServicelistingPage extends BaseClass{
	
	
	static By productName= By.xpath("//div[@class='product-itm product-1']/a/h4");
	static By product_price_size= By.xpath("//div[@class='product-itm product-1']/a/p[2]");
	static By product_interested= By.xpath("//div[@class='product-itm product-1']/button");
	
	static By service_header= By.xpath("//a[@class='nav-link'][normalize-space()='Services']");
	static By service_Interest=By.xpath("//div[@class='row']/div[2]/a[2]/button");
	static By service_price_duration=By.xpath("//div[@class='row']/div[2]/a[1]/p[2]");
	static By serviceName=By.xpath("//div[@class='row']/div[2]/a[1]/h4");
	
	
	
	
	static By wishlist= By.xpath("//img[@id='cart_heart_img']");
	
	static By checkout_next= By.xpath("//a[contains(text(),'NEXT')]");
	
	public static void pro_ser_cart() {
		
    	
    	
    	
    	System.out.println("product name "+driver.findElement(productName).getText());
    	
    
    	System.out.println("product price and size "+driver.findElement(product_price_size).getText());
    
    	driver.findElement(product_interested).click();
    	System.out.println("Product added to wishlist");
    	
    	
    	
    	driver.findElement(service_header).click();
    	System.out.println("Clicked service on header ");
    	
    
    	
    	System.out.println("service name "+driver.findElement(serviceName).getText());
    	System.out.println("service price and duration "+driver.findElement(service_price_duration).getText());
    	
    	driver.findElement(service_Interest).click();
    	System.out.println("Service added to wishlist");
    	
    	
    	
    	driver.findElement(wishlist).click();
    	System.out.println("Clicked on Wishlist");
    	
    
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    	driver.findElement(checkout_next).click();//next button
    	
    	
    	
	}


}
