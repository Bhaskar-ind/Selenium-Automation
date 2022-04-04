package com.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.base.BaseClass;

public class HomePage extends BaseClass{
	
	
	Action action = new Action();
	
	@FindBy(xpath = "//input[@type='submit']") 
	private WebElement LoginBtn;
	
	@FindBy(className = "app_logo")
	private WebElement slLogo;
	
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") 
	private WebElement ProductTitle;
	
	@FindBy(xpath = "//a[@id='item_4_img_link']")
	private WebElement ProductImg;
	
	@FindBy(xpath = "//div[text()='$' and text()='29.99']")
	private WebElement ProductPrice;
	
	@FindBy(xpath = "//button[@id=\"add-to-cart-sauce-labs-backpack\"]")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//button[@id=\"remove-sauce-labs-backpack\"]")
	private WebElement isRemoveDisplay;
	
	@FindBy(className = "shopping_cart_link")
	private WebElement clickOnCart;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnLogin() throws Throwable {
		action.fluentWait(driver, LoginBtn, 10);
		action.click(driver, LoginBtn);
		return new LoginPage();
	}
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(driver, slLogo);
	}
	
	public String getSwagLabsTitle() {
		String slTitle = action.getTitle(driver);
		return slTitle;
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(driver);
		return homePageURL;
	}
	
	//HomePage
	public boolean getProductTitle() {
		return action.isDisplayed(driver, ProductTitle);
	}
	
	public boolean getProductImg() {
		return action.isDisplayed(driver, ProductImg);
	}
	
	public boolean getProductPrice() {
		return action.isDisplayed(driver, ProductPrice);
	}
	
	public void clickOnAddToCart() {
		action.click(driver, AddToCart);
	}
	
	public boolean isRemoveDisplayed() {
		return action.isDisplayed(driver, isRemoveDisplay);
	}
	
	
	 public YourCart yourCart(YourCart yourcart) 
	 { 
		 action.click(driver,clickOnCart); 
		 return yourcart;
	 }
	  
	  
	  // }
	 }
