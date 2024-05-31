package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Property.ConfigClass;

public class AmazonPayment extends BaseClass {

	public static WebDriver driver;

	@FindBy(xpath = "//div[@id='nav-cart-count-container']")
	private WebElement cartPage;

	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	private WebElement proceedToPay;

	@FindBy(xpath = "//input[@data-testid='Address_selectShipToThisAddress']")
	private WebElement useThisAddress;

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement paymentMethod;

	@FindBy(xpath = "(//a[contains(text(),'Enter card details')])[1]")
	private WebElement enterCardDetails;

	@FindBy(xpath = "//input[@name='addCreditCardNumber']")
	private WebElement cardNumber;

	@FindBy(xpath = "//input[@name='ppw-widgetEvent:AddCreditCardEvent']")
	private WebElement clickEnter;

	@FindBy(xpath = "//h4[@class='a-alert-heading']")
	private WebElement errorMassage;
	
	@FindBy(xpath = "//button[@aria-label='Close']")
	private WebElement closeCardDetail;
	
	@FindBy(id = "nav-link-accountList")
	private WebElement signInbtn;

	// constructor
	public AmazonPayment(WebDriver driver1) {

		this.driver = driver1;
		PageFactory.initElements(driver, this);

	}

	private static ConfigClass cfg = new ConfigClass();

	public void makePayment() {

		implicitWait(30);
		clickOnElement(driver, cartPage);
		clickOnElement(driver, proceedToPay);
		clickOnElement(driver, useThisAddress);
		staticWait(5000);
		clickOnElement(driver, paymentMethod);
		clickOnElement(driver, enterCardDetails);
		staticWait(5000);
		frameByIndex(0);
		passInput(driver, cardNumber, cfg.GetCardNumber());
		clickOnElement(driver, clickEnter);
		Assert.assertEquals(errorMassage.getText(), cfg.GetmakePaymentAssert());
		clickOnElement(driver, closeCardDetail);
		closeTab();
		windowHandler(0);
	}
}
