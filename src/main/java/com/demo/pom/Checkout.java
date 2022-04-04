package com.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.base.BaseClass;

public class Checkout extends BaseClass{

	Action action = new Action();
	
	@FindBy(id = "first-name") 
	private WebElement firstname;
	
	@FindBy(id = "last-name")
	private WebElement lastname;
	
	@FindBy(id = "postal-code") 
	private WebElement postalcode;
	
	@FindBy(xpath = "//button[@id='cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	
	public Checkout() {
		PageFactory.initElements(driver, this);
	}
	
	
	public CkOutOverview userCredInfo(String fname, String lname,String pcode, CkOutOverview ckout) {
		action.scrollByVisibilityOfElement(driver, firstname);
		action.type(firstname, fname);
		action.type(lastname, lname);
		action.type(postalcode, pcode);
		action.JSClick(driver, continueButton);
		
		ckout = new CkOutOverview();
		return ckout;
	}
	
	public YourCart cancelButton(YourCart yourcart) {
		action.click(driver, cancelButton);
		yourcart = new YourCart();
		return yourcart;
	}
}
