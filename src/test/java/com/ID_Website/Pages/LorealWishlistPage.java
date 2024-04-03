package com.ID_Website.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;

public class LorealWishlistPage extends BaseClass {
	
static By product_Inc_Quan= By.xpath("//div[@class='col-lg-12']/div[1]//descendant::tr[1]//descendant::button[2]");

static By service_Inc_Quan= By.xpath("//div[@class='col-lg-12']/div[2]//descendant::tr[1]//descendant::button[2]");

static By product_Dec_Quan= By.xpath("//div[@class='col-lg-12']/div[1]//descendant::tr[1]//descendant::button[1]");
static By service_Dec_Quan= By.xpath("//div[@class='col-lg-12']/div[2]//descendant::tr[1]//descendant::button[1]");
static By checkout_next= By.xpath("//a[contains(text(),'NEXT')]");

static By toast_msg= By.xpath("//div[@class='toast-message']");

static By serDelete_button= By.xpath("//div[@class='col-lg-12']/div[2]//descendant::tr[1]//descendant::a[@class='delete-btn']");

static By proDelete_button= By.xpath("//div[@class='col-lg-12']/div[1]//descendant::tr[1]//descendant::a[@class='delete-btn']");

	public static void proIncQuan() {
		
    	
    	driver.findElement(product_Inc_Quan).click();
    	System.out.println("Product quantity increased");
    	logger.info("Product quantity increased");

    	WebElement PAW_toast_msg=driver.findElement(toast_msg);
    	String Act_Text=PAW_toast_msg.getText();
    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    	logger.info(driver.findElement(toast_msg).getText());
    	Assert.assertTrue(Act_Text.contains("WISHLIST UPDATED."));
	}
	
public static void proDecQuan() {
		
    	
    	driver.findElement(product_Dec_Quan).click();
    	System.out.println("Product quantity decreased");
    	logger.info("Product quantity decreased");
    	
        WebElement PAW_toast_msg=driver.findElement(toast_msg);
    	String Act_Text=PAW_toast_msg.getText();
    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    	logger.info(driver.findElement(toast_msg).getText());
    	Assert.assertTrue(Act_Text.contains("WISHLIST UPDATED."));
	}
	
public static void serIncQuan() {
		
    	
    	driver.findElement(service_Dec_Quan).click();
    	System.out.println("Service quantity increased");
    	logger.info("Service quantity increased");
    	
    	WebElement PAW_toast_msg=driver.findElement(toast_msg);
    	String Act_Text=PAW_toast_msg.getText();
    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
    	logger.info(driver.findElement(toast_msg).getText());
    	Assert.assertTrue(Act_Text.contains("WISHLIST UPDATED."));
    	
	}
public static void serDecQuan() {
	
	
	driver.findElement(product_Inc_Quan).click();
	System.out.println("Service quantity decreased");
	logger.info("Service quantity decreased");
	
	WebElement PAW_toast_msg=driver.findElement(toast_msg);
	String Act_Text=PAW_toast_msg.getText();
	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
	logger.info(driver.findElement(toast_msg).getText());
	Assert.assertTrue(Act_Text.contains("WISHLIST UPDATED."));
}

public static void serDelete() {
	
	
	driver.findElement(serDelete_button).click();
	System.out.println("service deleted successfully");
	logger.info("service deleted successfully");
	
	WebElement PAW_toast_msg=driver.findElement(toast_msg);
	String Act_Text=PAW_toast_msg.getText();
	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
	logger.info(driver.findElement(toast_msg).getText());
	Assert.assertTrue(Act_Text.contains("WISHLIST UPDATED."));
}

public static void proDelete() {
	
	
	driver.findElement(proDelete_button).click();
	System.out.println("product deleted successfully");
	logger.info("product deleted successfully");
	
	WebElement PAW_toast_msg=driver.findElement(toast_msg);
	String Act_Text=PAW_toast_msg.getText();
	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
	logger.info(driver.findElement(toast_msg).getText());
	Assert.assertTrue(Act_Text.contains("WISHLIST UPDATED."));
}



public static void next() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	System.out.println("Before clicking on Next button");
	WebElement next=driver.findElement(checkout_next);
	System.out.println("checkout_next Element Identified");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	js.executeScript("arguments[0].scrollIntoView({block:'center'});", next);
	System.out.println("Scrolled into the checkout_next Element");
	
	Thread.sleep(3000);
	next.click();
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
//	if(next.isDisplayed()==true) {
//
//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//	wait.until(ExpectedConditions.elementToBeClickable(next));
//
//	next.click();
//	}

	
	logger.info("Clicked on next button");
	
}
}
