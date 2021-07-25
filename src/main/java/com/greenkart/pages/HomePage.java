package com.greenkart.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.greenkart.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	@FindBy(xpath="//div[@class='brand greenLogo']")
	WebElement homePagelogo;
	
	public boolean verifyHomePageLogo() {
		return homePagelogo.isDisplayed();
	}
	
	@FindBy(xpath="//a[text()='Top Deals']")
	WebElement topDeals;
	
	@FindBy(xpath="//a[text()='Flight Booking']")
	WebElement flightBooking;
	
	@FindBy(xpath="//div[@class='product-action']//button")
	public
	WebElement addToCartButton;
	
	@FindBy(xpath="//img[@alt='Cart']")
	WebElement cart;
	
	@FindBy(xpath="//div[@class='action-block']//button")
	WebElement proceedToCheckoutbutton;
	
	@FindBy(xpath="//input[@class='promoCode']")
	WebElement promocodeTextField;
	
	@FindBy(xpath="//button[@class='promoBtn']")
	WebElement promoApplyButton;
	
	@FindBy(xpath="//span[@class='promoInfo']")
	public WebElement promoInfo;
	
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeOrderButton;
	
	@FindBy(xpath="//select")
	public WebElement selectTag;
	
	@FindBy(xpath="//input[@class='chkAgree']")
	WebElement checkTermsAndConditions;
	
	@FindBy(xpath="//button[text()='Proceed']")
	WebElement proceedButton;
	
	public void clickOnTopDeals() {
		topDeals.click();
	}
	
	public void clickOnflightBooking() {
		flightBooking.click();
	}
	
	public void clickOnAddToCart() {
		addToCartButton.click();
	}
	
	public void clickOnCartIcon() {
		cart.click();
	}
	
	public void clickOnproceedToCheckoutbutton() {
		proceedToCheckoutbutton.click();
	}
	
	public void enterpromocodeTextField() {
		promocodeTextField.sendKeys("rahulshettyacademy");
	}
	
	public void clickOnPromoApplyButton() {
		promoApplyButton.click();
	}
	
	public boolean promoInfoIsDisplayed() {
		return promoInfo.isDisplayed();
	}
	
	public void clickOnPlaceOrderButton() {
		placeOrderButton.click();
	}
	
	public void checkTermsAndConditions() {
		checkTermsAndConditions.click();
	}
	
	public void clickOnProceedButton() {
		proceedButton.click();
	}
	

}
