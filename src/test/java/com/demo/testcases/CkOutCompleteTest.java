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
import com.demo.pom.CkOutComplete;
import com.demo.pom.CkOutOverview;
import com.demo.pom.HomePage;
import com.demo.pom.LoginPage;
import com.demo.pom.YourCart;

@Listeners(CustomListner.class)
public class CkOutCompleteTest extends BaseClass {
	//private Logger log = LoggerFactory.getLogger(CkOutCompleteTest.class);
	private static final Logger log = LogManager.getLogger(CkOutCompleteTest.class);
	private HomePage homePage;
	private YourCart yourcart;
	private Checkout checkout;
	private CkOutOverview ckout;
	private CkOutComplete ckoutcomplete;
	
	@BeforeMethod
	public void SetUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void VerifyThankUforOrderDispaly() throws Throwable {
		log.info("Verify ThankUforOrderDispaly Started......");
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
		ckout = checkout.userCredInfo("Bhaskar", "Jaiswal", "401007", ckout);
		Assert.assertNotNull(ckout);
		ckoutcomplete=new CkOutComplete();
		ckoutcomplete=ckout.clickOnFinish(ckoutcomplete);
		Assert.assertNotNull(ckoutcomplete);
		boolean ty=ckoutcomplete.ThankUforOrderDispaly();
		Assert.assertTrue(ty);
		log.info("Verify ThankUforOrderDispaly Ended......");
	}

	@Test
	public void VerifyPonyExpressImage() throws Throwable {
		log.info("Verify PonyExpressImage Started......");
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
		ckout = checkout.userCredInfo("Bhaskar", "Jaiswal", "401007", ckout);
		Assert.assertNotNull(ckout);
		ckoutcomplete=new CkOutComplete();
		ckoutcomplete=ckout.clickOnFinish(ckoutcomplete);
		Assert.assertNotNull(ckoutcomplete);
		boolean peimage=ckoutcomplete.PonyExpressImage();
		Assert.assertTrue(peimage);
		log.info("Verify PonyExpressImage Ended......");
	}

	@Test
	public void VerifyclickOnHomeButton() throws Throwable {
		log.info("Verify clickOnHomeButton Started......");
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
		ckout = checkout.userCredInfo("Bhaskar", "Jaiswal", "401007", ckout);
		Assert.assertNotNull(ckout);
		ckoutcomplete=new CkOutComplete();
		ckoutcomplete=ckout.clickOnFinish(ckoutcomplete);
		Assert.assertNotNull(ckoutcomplete);
		boolean peimage=ckoutcomplete.PonyExpressImage();
		Assert.assertTrue(peimage);
		homePage =new HomePage();
		homePage = ckoutcomplete.clickOnHomeButton(homePage);
		Assert.assertNotNull(homePage);
		log.info("Verify clickOnHomeButton Ended......");
	}


}

