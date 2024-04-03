package com.ID_Website.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;

public class LorealProListing extends BaseClass {
	
	static By productName= By.xpath("//div[@class='product-itm product-0']/a/h4");
	static By product_price_size= By.xpath("//div[@class='product-itm product-0']/a/p[2]");
	static By product_interested= By.xpath("//section[@class='product-cat']/div/div[3]/div[1]/div/button/i");
	static By family_dropdown= By.xpath("//select[@id='collection_id']");
	static By subFamily_dropdown= By.xpath("//select[@id='subcollection_id']");
	static By concern_dropdown= By.xpath("//select[@id='concern_id']");
	static By product_dropdown= By.xpath("//select[@id='category_id']");
	static By noProductsFound_text= By.xpath("//div[contains(text(),'No Products Found...!')]");
	static By Product_Element= By.xpath("//div[@class='product-itm product-0']/a");
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");

	public static void addProduct() throws InterruptedException {
		
		
    	JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement pro_interested = driver.findElement(product_interested);
		System.out.println("product_interested Element Identified");
		
		js.executeScript("arguments[0].scrollIntoView({block:'center'});", pro_interested);
		System.out.println("Scrolled into the pro_interested Element");
		Thread.sleep(3000);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(product_interested));
//        driver.findElement(product_interested).click();
		pro_interested.click();
		
//		if(service.isDisplayed()==true) {
//    		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
//    		wait.until(ExpectedConditions.elementToBeClickable(service));
//    	service.click();
//    	}
		
		
WebElement PAW_toast_msg=driver.findElement(toast_msg);
String Act_Text=PAW_toast_msg.getText();
System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
logger.info(driver.findElement(toast_msg).getText());
    	
Assert.assertTrue(Act_Text.contains("PRODUCT ADDED TO WISHLIST"));
System.out.println("product name "+driver.findElement(productName).getText());
logger.info("product name "+driver.findElement(productName).getText());


System.out.println("product price and size "+driver.findElement(product_price_size).getText());
logger.info("product price and size "+driver.findElement(product_price_size).getText());


    	System.out.println("product_interested Clicked successfully");
    	logger.info("product_interested Clicked successfully");


	}
	public static void familyFilter() throws InterruptedException {
		Select st=new Select(driver.findElement(family_dropdown));
		st.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Family searched successfully");
		logger.info("Family searched successfully");
		
		WebElement selectedOptionFamily = st.getFirstSelectedOption();
		
	      String selectedFamily = selectedOptionFamily.getText();
	      System.out.println("Selected element: " + selectedFamily);
	      logger.info("Selected element: " + selectedFamily);
		
		try {

			
		      WebElement ActText=driver.findElement(noProductsFound_text);
		      System.out.println("Display" +" "+ActText.getText());
			
			
		}
		catch(Exception e) {
		
			
			System.out.println("Before click on Interest button");
		
		   addProduct();
			
			System.out.println("Product added to cart successfully");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));	
		
		}
	
	public static void subFamilyFilter() throws InterruptedException {
		Select st=new Select(driver.findElement(subFamily_dropdown));
		st.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Sub Family searched successfully");
		logger.info("Sub Family searched successfully");
		
		
		WebElement selectedOptionFamily = st.getFirstSelectedOption();
		
	      String selectedsubFamily = selectedOptionFamily.getText();
	      System.out.println("Selected sub family element: " + selectedsubFamily);
	      logger.info("Selected sub family element: " + selectedsubFamily);
	      
		try {
		
			
	      WebElement ActText=driver.findElement(noProductsFound_text);
	      System.out.println("Display" +" "+ActText.getText());
		
	}
		catch(Exception e)
		{
			
		System.out.println("Before click on Interest button");
	
		addProduct();
		
		System.out.println("Product added to cart successfully");
		
	}
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
	
		
	public static void concernFilter() throws InterruptedException {
		Select st=new Select(driver.findElement(concern_dropdown));
		st.selectByIndex(2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("Concern searched successfully");
		logger.info("Concern searched successfully");
		WebElement selectedOptionFamily = st.getFirstSelectedOption();
		
	      String selectedFamily = selectedOptionFamily.getText();
	      System.out.println("Selected concern element: " + selectedFamily);
	      logger.info("Selected concern element: " + selectedFamily);
	      
		try {
			
			
	      WebElement ActText=driver.findElement(noProductsFound_text);
	      System.out.println("Display" +" "+ActText.getText());
		
	}
		catch(Exception e)
		{
			
		System.out.println("Before click on Interest button");
	
		addProduct();
		
		System.out.println("Product added to cart successfully");
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		}
	
		
	public static void productFilter() throws InterruptedException {
		Select st=new Select(driver.findElement(product_dropdown));
		st.selectByIndex(3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("product type searched successfully");
		logger.info("product type searched successfully");
		WebElement selectedOptionFamily = st.getFirstSelectedOption();
		
	      String selectedFamily = selectedOptionFamily.getText();
	      System.out.println("Selected product type element: " + selectedFamily);
	      logger.info("Selected product type element: " + selectedFamily);
	      
		try {

			
		      WebElement ActText=driver.findElement(noProductsFound_text);
		      System.out.println("Display" +" "+ActText.getText());
			
			
		}
		catch(Exception e) {
		
			
		    
			System.out.println("Before click on Interest button");
		
		    addProduct();
			
			System.out.println("Product added to cart successfully");
		
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		}
	
		
}
