package com.ID_Website.SmokeTests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ID_Website.Pages.SalonHomePage;
import com.ID_Website.Pages.LorealHomePage;
import com.ID_Website.Pages.ProductDetailPage;
import com.ID_Website.Pages.SelectBrand;
import com.ID_Website.utilities.BaseClass;

public class LorealProSerCheckout extends BaseClass {
	@Test
	public static void proserCheckout() throws InterruptedException, IOException {
		
		logger.info("**********************Started Loreal Product Service checkout***********************");
		SalonHomePage.lanSelTest();
		
		//SelectBrand.matrix();
		//SelectBrand.biolage();
		//SelectBrand.kerastase();
		SelectBrand.loreal();
		
		LorealHomePage.exploreOurRange();
		
		ProductDetailPage.productCart();
		
		
	}

}
