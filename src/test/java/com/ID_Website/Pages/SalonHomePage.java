package com.ID_Website.Pages;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.ID_Website.utilities.BaseClass;


public class SalonHomePage extends BaseClass{
	
	static By switch_EN= By.xpath("//div[@class='switch-field']//label[@for='radio-two']");
	static By exploreBrand_text= By.xpath("//h3[contains(text(),'Explore our professional brands')]");
	static By logo= By.xpath("//a[@class='navbar-brand']");
	
	public static void salonLogoClick() throws InterruptedException, IOException{
		WebElement salLogo=driver.findElement(logo);
		salLogo.click();
		
	}
	
	
	public static void lanSelTest() throws InterruptedException, IOException
	{
//		WebElement EN=driver.findElement(switch_EN);
//		if(EN.isEnabled()==true) {
// 		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(120));
//    	wait.until(ExpectedConditions.elementToBeClickable(EN));
//    	EN.click();
//    	}
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		Thread.sleep(5000);
		driver.findElement(switch_EN).click();// change to EN
	
		System.out.println("language changed to EN");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		System.out.println("Before getting text of explore Brand");
		WebElement exploreBrand = driver.findElement(exploreBrand_text);
		System.out.println("exploreBrand Element Identified");
		js.executeScript("arguments[0].scrollIntoView();", exploreBrand);//scroll to the text
		System.out.println("Scrolled into the exploreBrand Element");

		System.out.println(exploreBrand.getText());
		
		String ActResult = exploreBrand.getText();
		String ExpResult = "Explore our professional brands";

		if (ExpResult.equals(ActResult)) {
			Assert.assertTrue(true);
			System.out.println("Language changed");
			logger.info("Language changed");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		} else {

			System.out.println("Language not changed");
			logger.info("Language not changed");
			captureScreen(driver,"lanSelTest");
			Assert.assertTrue(false);
		}
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		Thread.sleep(5000);
	}


	
	


}
