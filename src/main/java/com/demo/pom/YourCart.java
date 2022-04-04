package com.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.base.BaseClass;

public class YourCart extends BaseClass {

	private HomePage homePage;
	private Checkout checkout;
	
	Action action = new Action();

	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
	private WebElement ProductINCart;
	
	@FindBy(id = "continue-shopping")
	private WebElement clickOnContinueShopping;

	@FindBy(xpath = "//*[@id=\"remove-sauce-labs-backpack\"]")
	private WebElement clickOnRemove;

	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement clickOnCheckout;
	
	@FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
	private WebElement emptyCart;
	
	////*[@id="shopping_cart_container"]/a

	public YourCart() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isProductInCart() {
		return action.isDisplayed(driver, ProductINCart);
	}
	
	public  HomePage clickOnContinueShopping(HomePage homePage) {
		action.click(driver, clickOnContinueShopping);
		return homePage;
		
	}

	public boolean clickOnRemove() {
		return action.isDisplayed(driver, emptyCart);
		
	}
	
	public Checkout clickOnCheckout(Checkout checkout) {
		action.click(driver, clickOnCheckout);
		return checkout;
	}
	
}
