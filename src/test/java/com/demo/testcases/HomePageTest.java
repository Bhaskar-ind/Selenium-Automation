package com.demo.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.base.BaseClass;
import com.demo.listeners.CustomListner;
import com.demo.pom.HomePage;
import com.demo.pom.LoginPage;

@Listeners(CustomListner.class)
public class HomePageTest extends BaseClass {
	//private Logger log = LoggerFactory.getLogger(HomePageTest.class);
	private static final Logger log = LogManager.getLogger(HomePageTest.class);
	private HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyLogo() throws Throwable {
		log.info("verifyLogo Test Started.....");
		homePage= new HomePage();
		new LoginPage().login("standard_user", "secret_sauce", homePage);
		boolean result=homePage.validateLogo();
		Assert.assertTrue(result);
		log.info("verifyLogo Test Ended.....");
	}
	
	@Test
	public void verifyTitle() {
		log.info("verifyTitle Test Started...");
		String actTitle=homePage.getSwagLabsTitle();
		Assert.assertEquals(actTitle, "Swag Labs");
		log.info("verifyTitle Test Ended....");
	}
	
	@Test
	public void verifyCurrentURL() throws Throwable{
		log.info("verify currentURL is Started.....");
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		String currURL = homePage.getCurrURL();
		String expURL = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(currURL, expURL);
		log.info("verify currentURL is Ended.....");
	}
	
	@Test
	public void verifyProductTitle() throws Throwable {
		log.info("Verify ProductTitle Started......");
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		boolean ProdTitle = homePage.getProductTitle();
		Assert.assertTrue(ProdTitle);
		log.info("Verify ProductTitle Ended......");
	}
	
	@Test
	public void verifyProductImg() throws Throwable {
		log.info("Verify ProductImg Started......");
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		boolean ProdImg = homePage.getProductImg();
		Assert.assertTrue(ProdImg);
		log.info("Verify ProductImg Ended......");
	}

	@Test
	public void verifyProductPrice() throws Throwable {
		log.info("Verify ProductPrice Started......");
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		boolean ProdPrice = homePage.getProductPrice();
		Assert.assertTrue(ProdPrice);
		log.info("Verify ProductPrice Ended......");
	}
	
	@Test
	public void verifyClickOnAddToCart() throws Throwable {
		log.info("Verify ClickOnAddToCart Started......");
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		homePage.clickOnAddToCart();
		boolean isRemoveDisplay = homePage.isRemoveDisplayed();
		Assert.assertTrue(isRemoveDisplay);
		log.info("Verify ClickOnAddToCart Ended......");
	}

}
