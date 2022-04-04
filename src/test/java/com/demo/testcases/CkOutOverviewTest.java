package com.demo.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
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
public class CkOutOverviewTest extends BaseClass {
	//private Logger log = LoggerFactory.getLogger(CkOutOverviewTest.class);
	private static final Logger log = LogManager.getLogger(CkOutOverviewTest.class);
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
	public void VerifycartQuantity() throws Throwable {
		log.info("Verify cartQuantity Started......");
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
		boolean ctoverview=ckout.cartQuantity();
		Assert.assertTrue(ctoverview);
		log.info("Verify cartQuantity Started......");
	}

	
	@Test
	public void VerifyInvITemName() throws Throwable {
		log.info("Verify InvITemName Started......");
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
		boolean invItemname=ckout.InvITemName();
		Assert.assertTrue(invItemname);
		log.info("Verify InvITemName Ended......");
	}

	@Test
	public void VerifyPaymentInformation() throws Throwable {
		log.info("Verify PaymentInformation Started......");
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
		boolean payInfo=ckout.PaymentInformation();
		Assert.assertTrue(payInfo);
		log.info("Verify PaymentInformation Ended......");
		throw new SkipException("Skip this steps");
	}

	@Test
	public void VerifySauceCardPayment() throws Throwable {
		log.info("Verify SauceCardPayment Started......");
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
		boolean sauce=ckout.SauceCardPayment();
		Assert.assertTrue(sauce);
		log.info("Verify SauceCardPayment Ended......");
	}

	@Test
	public void VerifyShippingInfo() throws Throwable {
		
		log.info("Verify ShippingInfo Started......");
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
		boolean shipInfo=ckout.ShippingInfo();
		Assert.assertTrue(shipInfo);
		log.info("Verify ShippingInfo Ended......");
		throw new SkipException("Skip this steps");
		
	}

	@Test
	public void VerifyDeliveryNameInfo() throws Throwable {
		log.info("Verify DeliveryNameInfo Started......");
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
		boolean delNameInfo=ckout.DeliveryNameInfo();
		Assert.assertTrue(delNameInfo);
		log.info("Verify DeliveryNameInfo Ended......");
	}

	@Test
	public void VerifyTotalAmountInfo() throws Throwable {
		log.info("Verify TotalAmountInfo Started......");
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
		boolean amtInfo=ckout.TotalAmountInfo();
		Assert.assertTrue(amtInfo);
		log.info("Verify TotalAmountInfo Ended......");
	}

	@Test
	public void VerifyclickOnCancel() throws Throwable {
		log.info("Verify clickOnCancel Started......");
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
		checkout=new Checkout();
		checkout=ckout.clickOnCancel(checkout);
		Assert.assertNotNull(checkout);
		log.info("Verify clickOnCancel Ended......");
		throw new SkipException("Skip this steps");
	}

	@Test
	public void VerifyclickOnFinish() throws Throwable {
		log.info("Verify clickOnFinish Started......");
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
		log.info("Verify clickOnFinish Ended......");
	}

	
}
