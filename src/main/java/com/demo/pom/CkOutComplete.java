package com.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.base.BaseClass;

public class CkOutComplete extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//h2[text()='THANK YOU FOR YOUR ORDER']") 
	private WebElement ThankUforOrder;
	
	@FindBy(xpath="//img[@class='pony_express']")
	private WebElement ponyExp;
	
	@FindBy(xpath = "//button[text()='Back Home']") 
	private WebElement backHomeButton;
	
	public CkOutComplete() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ThankUforOrderDispaly() {
		return action.isDisplayed(driver, ThankUforOrder);
		}
	
	public boolean PonyExpressImage() {
		return action.isDisplayed(driver, ponyExp);
		}
	
	public HomePage clickOnHomeButton(HomePage homePage) {
		action.click(driver, backHomeButton);
		homePage=new HomePage();
		return homePage;
		
	}
	
	
	
	
	
	
	
	
	
}
