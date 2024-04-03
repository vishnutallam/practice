package com.ID_Website.Pages;

import org.openqa.selenium.By;
import com.ID_Website.utilities.BaseClass;

public class SelectBrand extends BaseClass {
	
	static By loreal=By.xpath("//a[@href='https://test.lorealsalonshop.co.id/brands/Mg== ']//img");
	static By kerastase=By.xpath("//a[@href='https://test.lorealsalonshop.co.id/brands/MQ== ']//img");
	static By matrix=By.xpath("//a[@href='https://test.lorealsalonshop.co.id/brands/Mw== ']//img");
	static By biolage=By.xpath("//a[@href='https://test.lorealsalonshop.co.id/brands/NQ== ']//img");
	
	
	
public static void loreal() throws InterruptedException {
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(loreal));
	Thread.sleep(3000);
		driver.findElement(loreal).click();// loreal
		Thread.sleep(3000);
		System.out.println("loreal Brand selected");
		logger.info("loreal Brand selected");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
}

public static void kerastase() throws InterruptedException {

	driver.findElement(kerastase).click();// kerastase
	System.out.println("Kerastase Brand selected");
	logger.info("Kerastase Brand selected");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	
}


public static void matrix() throws InterruptedException {

	driver.findElement(matrix).click();// matrix
	System.out.println("Matrix Brand selected");
	logger.info("Matrix Brand selected");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	
}

public static void biolage() throws InterruptedException {

	driver.findElement(biolage).click();// biolage
	System.out.println("Biolage Brand selected");
	logger.info("Biolage Brand selected");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	
}
}