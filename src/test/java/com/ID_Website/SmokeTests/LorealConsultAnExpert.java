package com.ID_Website.SmokeTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_Website.Pages.ConsultAnExpert;
import com.ID_Website.Pages.SalonHomePage;
import com.ID_Website.Pages.LorealHomePage;
import com.ID_Website.Pages.SelectBrand;
import com.ID_Website.utilities.BaseClass;






@Test
public class LorealConsultAnExpert extends BaseClass{
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");
	
	public static void consultAnExpert() throws InterruptedException, IOException {
		logger.info("*********************Started consult an expert******************");
		SalonHomePage.lanSelTest();
		
		SelectBrand.loreal();
		
		LorealHomePage.consultAnExpert();
	
		ConsultAnExpert.consultForm();
		
		System.out.println(driver.getTitle());
		
		
		WebElement PAW_toast_msg=driver.findElement(toast_msg);
		String Act_Text=PAW_toast_msg.getText();
		System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
		logger.info(driver.findElement(toast_msg).getText());
		    	
		//Assert.assertTrue(Act_Text.contains("Thank You for contacting us. We'll get back to you soon."));
		if(Act_Text.contains("Thank You for contacting us. We'll get back to you soon.aa")) {
			Assert.assertTrue(true);
			logger.info("***************Consult an expert passed successfully******************");
		}
		else
		{
			logger.info("***************Consult an expert failed******************");
			captureScreen(driver,"consultAnExpert");
			System.out.println("Consult an expert failed");
			Assert.assertTrue(false);
		}
	}

}
