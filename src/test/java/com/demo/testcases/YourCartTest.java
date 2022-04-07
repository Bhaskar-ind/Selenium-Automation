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
import com.demo.pom.Checkout;
import com.demo.pom.HomePage;
import com.demo.pom.LoginPage;
import com.demo.pom.YourCart;

@Listeners(CustomListner.class)
public class YourCartTest extends BaseClass{
	//private Logger log = LoggerFactory.getLogger(YourCartTest.class);
	private static final Logger log = LogManager.getLogger(YourCartTest.class);
	private HomePage homePage;
	private YourCart yourcart;
	private Checkout checkout;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void VerifyProductInCart() throws Throwable {
		log.info("Verify Product In Cart Started.....");
		//homePage = new HomePage();
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		homePage.clickOnAddToCart();
		yourcart = new YourCart();
		yourcart=homePage.yourCart(yourcart);
		//System.out.println(yourcart);
		boolean b=yourcart.isProductInCart();
		Assert.assertTrue(b);
		log.info("Verify Product In Cart Ended.....");
	}
	
	
	@Test
	public void VerifyclickOnContinueShopping() throws Throwable {
		log.info("Verify clickOnContinueShopping Started........");
		homePage = new HomePage();
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		homePage.clickOnAddToCart();
		yourcart = new YourCart();
		yourcart=homePage.yourCart(yourcart);
		boolean c=yourcart.isProductInCart();
		//System.out.println(c);
		Assert.assertTrue(c);
		//yourcart = new YourCart();
		homePage = new HomePage();
		homePage=yourcart.clickOnContinueShopping(homePage);
		//System.out.println(homePage);
		Assert.assertNotNull(homePage);
		log.info("Verify clickOnContinueShopping Ended........");
	}
	
	@Test
	public void VerifyclickOnRemove() throws Throwable {
		log.info("Verify clickOnRemove Started........");
		homePage = new HomePage();
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		homePage.clickOnAddToCart();
		yourcart = new YourCart();
		yourcart=homePage.yourCart(yourcart);
		boolean d=yourcart.isProductInCart();
		Assert.assertTrue(d);
		boolean yc=yourcart.clickOnRemove();
		//System.out.println(yc);
		Assert.assertTrue(yc);
		log.info("Verify clickOnRemove Ended........");
	}
	
	@Test
	public void VerifyclickOnCheckout() throws Throwable {
		log.info("Verify clickOnCheckout Started........");
		homePage = new HomePage();
		homePage=new LoginPage().login("standard_user", "secret_sauce", homePage);
		homePage.clickOnAddToCart();
		yourcart = new YourCart();
		yourcart=homePage.yourCart(yourcart);
		boolean e=yourcart.isProductInCart();
		Assert.assertTrue(e);
		checkout=new Checkout();
		checkout = yourcart.clickOnCheckout(checkout);
		Assert.assertNotNull(checkout);
		log.info("Verify clickOnCheckout Ended........");
	}
	
	
	
	
}
