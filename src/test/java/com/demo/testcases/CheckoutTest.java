package com.demo.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.base.BaseClass;
import com.demo.dataprovider.DataProviders;
import com.demo.listeners.CustomListner;
import com.demo.pom.Checkout;
import com.demo.pom.CkOutOverview;
import com.demo.pom.HomePage;
import com.demo.pom.LoginPage;
import com.demo.pom.YourCart;

@Listeners(CustomListner.class)
public class CheckoutTest extends BaseClass {
	private YourCart yourcart;
	private HomePage homePage;
	private Checkout checkout;
	private CkOutOverview ckout;
	//private Logger log = LoggerFactory.getLogger(CheckoutTest.class);
	private static final Logger log = LogManager.getLogger(CheckoutTest.class);
	
	@BeforeMethod
	public void SetUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifyCancelButton() throws Throwable {
		log.info("verify CancelButton Started....");
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
		yourcart=checkout.cancelButton(yourcart);
		Assert.assertNotNull(yourcart);
		log.info("verify CancelButton Ended....");
	}
	
	@Test(dataProvider = "getTestCredData",dataProviderClass = DataProviders.class)
	public void verifyCheckoutUserCredInfo(String fname, String lname ,String pcode) throws Throwable {
		log.info("Verify CheckoutUserCredInfo Started.....");
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
		ckout = new CkOutOverview();
		ckout = checkout.userCredInfo(fname, lname, pcode, ckout);
		Assert.assertNotNull(ckout);
		log.info("Verify CheckoutUserCredInfo Ended.....");
	}
	
}
