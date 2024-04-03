package com.ID_Website.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ID_Website.utilities.BaseClass;

public class LorealHomePage extends BaseClass {
	
	static By exp_our_range= By.xpath("//h4[contains(text(),'EXPLORE OUR RANGE')]/parent::a");
	static By exp_our_service= By.xpath("//h4[contains(text(),'EXPLORE OUR SERVICES')]/parent::a");
	static By con_expert= By.xpath("//h4[contains(text(),'CONSULT AN EXPERT')]/parent::a");
	static By search=By.xpath("//*[@class='container']/following::a[@class='nav-link nav-icon']");
	static By detailPage_wishlist=By.xpath("//a[@id='cart_counter_tag']");
	static By home_wishlist=By.xpath("//*[@class='container']/following::img[@id='cart_heart_img']");
	static By home=By.xpath("//*[@class='container']/following::img[@id='cart_heart_img']");

	public static void exploreOurRange() throws InterruptedException {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Before clicking exp_our_range");
		
    	WebElement range=driver.findElement(exp_our_range);
    	System.out.println("exp_our_range Element Identified");
    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", range);
    	System.out.println("Scrolled into the exp_our_range Element");
    	System.out.println("Text on block"+range.getText());
    	//Thread.sleep(5000);
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	//range.click();
    	if(range.isDisplayed()==true) {
//    		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//    		wait.until(ExpectedConditions.elementToBeClickable(range));
    		Thread.sleep(5000);
    	range.click();
    	}
    	//driver.findElement(exp_our_range).click();
    	System.out.println("Clicked on exp_our_range");
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    	//Thread.sleep(5000);
		
	}
	
public static void exploreOurServices() throws InterruptedException {
	
	
	
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Before clicking exp_our_services");
		
		
		
    	WebElement service=driver.findElement(exp_our_service);
    	System.out.println("exp_our_services Element Identified");
    	
    
    	
    	js.executeScript("arguments[0].scrollIntoView({block:'center'});", service);
    	System.out.println("Scrolled into the exp_our_service Element");
    	System.out.println("Text on block"+service.getText());
    	logger.info("Text on block"+service.getText());
    
    	
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	if(service.isDisplayed()==true) {
//    		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//    		wait.until(ExpectedConditions.elementToBeClickable(service));
    		Thread.sleep(5000);
    	service.click();
    	}
    	System.out.println("Clicked on exp_our_service");
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
    	//Thread.sleep(5000);
	}

public static void consultAnExpert() throws InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Before clicking con_expert");
	WebElement expert=driver.findElement(con_expert);
	System.out.println("con_expert Element Identified");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", expert);
	System.out.println("Scrolled into the con_expert Element");
	System.out.println("Text on block"+expert.getText());
	//Thread.sleep(3000);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//expert.click();
	if(expert.isDisplayed()==true) {
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//		wait.until(ExpectedConditions.elementToBeClickable(expert));
		Thread.sleep(5000);
	expert.click();
	}
	System.out.println("Clicked on con_expert");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	
}

public static void search() throws InterruptedException {
	

	System.out.println("Before clicking search");
	
	//Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	driver.findElement(search).click();
	System.out.println("Clicked on search");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	Thread.sleep(5000);
}

//public static void detailPage_wishlist() throws InterruptedException {
//	
//	
//	System.out.println("Before clicking wishlist");
//	
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//
//
//	driver.findElement(detailPage_wishlist).click();
//	
//	System.out.println("Clicked on wishlist");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
//}
public static void home_wishlist() throws InterruptedException {
	
	
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	Thread.sleep(5000);

	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(home_wishlist));

	driver.findElement(home_wishlist).click();
	System.out.println("Clicked on home wishlist");
	logger.info("Clicked on home wishlist");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	Thread.sleep(5000);
}

public static void home() throws InterruptedException {
	
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(home));

	driver.findElement(home).click();
	System.out.println("Clicked Home in Header ");
	logger.info("Clicked Home in Header ");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	Thread.sleep(5000);
}
}
