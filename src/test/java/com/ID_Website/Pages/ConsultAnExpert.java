package com.ID_Website.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;




import com.ID_Website.utilities.BaseClass;

public class ConsultAnExpert extends BaseClass{
	
	static By name_field= By.xpath("//input[@id='lead_name']");
	static By mobilenum_field= By.xpath("//input[@id='lead_mobile']");
	static By pincode_field= By.xpath("//input[@id='lead_pincode']");
	static By city_field= By.xpath("//input[@id='lead_city_name']");
	static By email_field= By.xpath("//input[@id='lead_email']");
	static By I_agree_to_checkbox= By.xpath("//input[@id='part'][@type='checkbox']");
	static By submit_button= By.xpath("//button[@id='submit_btn']");
	
	
	public static void consultForm() throws InterruptedException {
		//logger = LogManager.getLogger(ConsultAnExpert.class);
			
		driver.findElement(name_field).sendKeys("tester automation");
			
		driver.findElement(mobilenum_field).sendKeys("6280000000");
		driver.findElement(pincode_field).sendKeys("54677");
		driver.findElement(city_field).sendKeys("Mumbai Automation");
		driver.findElement(email_field).sendKeys("automation@gmail.com");
		
			
WebElement I_agree_to=driver.findElement(I_agree_to_checkbox);

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].scrollIntoView({block:'center'});", I_agree_to);	
Thread.sleep(3000);	

System.out.println("terms and conditions element identified");
		
		if(I_agree_to.isEnabled()==true) {
			System.out.println("terms and conditions before click");
			I_agree_to.click();
            System.out.println("I_agree_to selected");
            logger.info("I_agree_to selected");
		}
		
		System.out.println("Before form submission");
		

		driver.findElement(submit_button).click();
		System.out.println("Consult an expert submitted");
		
		
		
	}

}
