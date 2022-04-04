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
import com.demo.pom.HomePage;
import com.demo.pom.LoginPage;


@Listeners(CustomListner.class)
public class LoginPageTest extends BaseClass{
	//private Logger log = LoggerFactory.getLogger(LoginPageTest.class);
	private static final Logger log = LogManager.getLogger(LoginPageTest.class);
	private LoginPage loginPage;
	private HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "getTestData",dataProviderClass = DataProviders.class, priority=1)
	public void loginTest(String username,String password) throws Throwable {
		log.info("LoginTest Started.......");
		homePage= new HomePage();
		log.info("User is going to click on SignIn");
		loginPage=homePage.clickOnLogin();
		log.info("Enter Username and Password");
		homePage=loginPage.login(username,password,homePage);
		String actualURL=homePage.getCurrURL();
	    String expectedURL="https://www.saucedemo.com/inventory.html";
	    log.info("Verifying if user is able to login");
	    Assert.assertEquals(actualURL, expectedURL);
	    log.info("Login is Success");
	    log.info("LoginTest Ended......");
	}	
}
