package com.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.actiondriver.Action;
import com.demo.base.BaseClass;

public class CkOutOverview extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//div[@class='cart_quantity']") 
	private WebElement cartQnty;
	
	@FindBy(xpath="//div[@class='inventory_item_name']")
	private WebElement InvItemName;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']") 
	private WebElement InvItemPrice;
	
	@FindBy(xpath = "//div[@class='summary_info_label']")
	private WebElement PaymentInformation;
	
	@FindBy(xpath = "//div[@class='summary_value_label']")
	private WebElement SauceCard;
	
	@FindBy(xpath = "//div[@class='summary_info_label' and text()='Shipping Information:']")
	private WebElement ShippingInformation;
	
	@FindBy(xpath = "//div[@class='summary_value_label' and text()='FREE PONY EXPRESS DELIVERY!']")
	private WebElement DeliveryName;
	
	@FindBy(xpath="//div[@class='summary_total_label']")
	private WebElement TotalAmount;
	
	@FindBy(xpath="//button[@id='cancel']")
	private WebElement cancelButton;
	
	@FindBy(xpath="//button[@id='finish']")
	private WebElement finishButton;
	
	public CkOutOverview() {
		PageFactory.initElements(driver, this);
	}
	

	public boolean cartQuantity() {
		return action.isDisplayed(driver, cartQnty);
		}
	
	public boolean InvITemName() {
		return action.isDisplayed(driver, InvItemName);
		}
	
	public boolean PaymentInformation() {
		return action.isDisplayed(driver, PaymentInformation);
		}
	
	public boolean SauceCardPayment() {
		return action.isDisplayed(driver, SauceCard);
		}
	
	public boolean ShippingInfo() {
		return action.isDisplayed(driver, ShippingInformation);
		}
	
	public boolean DeliveryNameInfo() {
		return action.isDisplayed(driver, DeliveryName);
		}
	
	public boolean TotalAmountInfo() {
		return action.isDisplayed(driver, TotalAmount);
		}
	
	public Checkout clickOnCancel(Checkout ckout) {
		action.click(driver, cancelButton);
		ckout=new Checkout();
		return ckout;
		
	}
	
	public CkOutComplete clickOnFinish(CkOutComplete ckoutcomplete) {
		action.click(driver, finishButton);
		ckoutcomplete = new CkOutComplete();
		return ckoutcomplete;
		
	}
	
}
