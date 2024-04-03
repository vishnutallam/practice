package com.ID_Website.SmokeTests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ID_Website.Pages.SalonHomePage;
import com.ID_Website.Pages.LorealHomePage;
import com.ID_Website.Pages.LorealWishlistPage;
import com.ID_Website.Pages.OrderDetailsPage;

import com.ID_Website.Pages.SearchPage;
import com.ID_Website.Pages.SelectBrand;
import com.ID_Website.Pages.ServiceDetailPage;
import com.ID_Website.utilities.BaseClass;

public class Loreal_Search_Checkout extends BaseClass {
	
	static By toast_msg= By.xpath("//div[@class='toast-message']");
	static By thankyou_text=By.xpath("//section[@id='my-cart']//following::h5[text()='Thank you!']");
	
	@Test
	public static void searchCheckout() throws InterruptedException, IOException {
		logger.info("*******************Started Loreal search checkout*********************");
		SalonHomePage.lanSelTest();
		
		SelectBrand.loreal();
		
		LorealHomePage.search();
		
		SearchPage.searching();
		
		
		LorealHomePage.home_wishlist();
		
		LorealWishlistPage.next();
		
		OrderDetailsPage.orderDetails();
		

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        try {
        	
        	WebElement PAW_toast_msg=driver.findElement(toast_msg);   	
	    	String Act_Text=PAW_toast_msg.getText();
	    	System.out.println("Toast message"+" "+driver.findElement(toast_msg).getText());
	    	logger.info(driver.findElement(toast_msg).getText());
        	logger.info("***************While Loreal Search checkout display ---You have cross the limit.----******************");
        }
        
        catch(Exception e) {
		WebElement thankText=driver.findElement(thankyou_text);
		String text=thankText.getText();
		System.out.println(text);
		
		if(text.equals("THANK YOU!")) {
			Assert.assertTrue(true);
			logger.info("***************Loreal Search checkout completed successfully******************");
		}
		else
		{
			logger.info("***************Loreal Search checkout failed*****************");
			captureScreen(driver,"searchCheckout");
			System.out.println("Loreal Search checkout failed");
			Assert.assertTrue(false);
		}
        }

		
	}

}
