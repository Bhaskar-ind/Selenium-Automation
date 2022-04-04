package com.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.base.BaseClass;

public class LoginPage extends BaseClass {

	Action action = new Action();
	
	@FindBy(id="user-name")
	private WebElement userName;
	
	@FindBy(id="password")
	private WebElement password;

	@FindBy(id="login-button")
	private WebElement LoginBtn;      //SignInBtn
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.JSClick(driver, LoginBtn);
		Thread.sleep(2000);
		homePage=new HomePage();
		return homePage;
	}
}
