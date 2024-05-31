package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Property.ConfigClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class AmazonLogin extends BaseClass {

	public static WebDriver driver;

	@FindBy(id = "nav-link-accountList")
	private WebElement signInbtn;

	@FindBy(xpath = "//input[@id='ap_email']")
	private WebElement emailId;

	@FindBy(xpath = "//input[@id='continue']")
	private WebElement continueBtn;

	@FindBy(xpath = "//input[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signInBtn2;

	@FindBy(xpath = "//span[@class='a-list-item']")
	private WebElement inputError;

	@FindBy(xpath = "//div[contains( text(),' Enter your email or mobile')]")
	private WebElement emptyEmail;

	@FindBy(xpath = "//div[contains( text(),' Enter your password')]")
	private WebElement emptyPassword;

	// constructor
	public AmazonLogin(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	private static ConfigClass cfg = new ConfigClass();

	public boolean validLogIn(ExtentTest extentTest) {

		try {
			implicitWait(30);
			launchUrl(driver, cfg.GetUrl());
			clickOnElement(driver, signInbtn);
			passInput(driver, emailId, cfg.GetvalidEmailId());
			clickOnElement(driver, continueBtn);
			passInput(driver, password, cfg.GetvalidPassword());
			clickOnElement(driver, signInBtn2);
			staticWait(5000);
			String title = driver.getTitle();
			Assert.assertEquals(title, cfg.GetvalidLoginAssert());
			extentTest.log(Status.PASS, "Login Successful");
		} catch (AssertionError e) {
			extentTest.log(Status.FAIL, "Login Failed");

			return false;
		}
		return true;
	}

	public void inValidEmailId() {

		launchUrl(driver, cfg.GetUrl());
		clickOnElement(driver, signInbtn);
		passInput(driver, emailId, cfg.GetinvalidEmailId());
		clickOnElement(driver, continueBtn);
		Assert.assertEquals(inputError.getText(), cfg.GetinvalidEmailAssert());
	}

	public void validEmailIdAndInvalidPassword() {

		launchUrl(driver, cfg.GetUrl());
		clickOnElement(driver, signInbtn);
		passInput(driver, emailId, cfg.GetvalidEmailId());
		clickOnElement(driver, continueBtn);
		passInput(driver, password, cfg.GetinValidPassword());
		clickOnElement(driver, signInBtn2);
		staticWait(15000);
		Assert.assertEquals(inputError.getText(), cfg.GetinvalidPasswordAssert());
	}

	public void emailIdWithEmptyText() {

		launchUrl(driver, cfg.GetUrl());
		clickOnElement(driver, signInbtn);
		passInput(driver, emailId, cfg.GetemptyEmailId());
		clickOnElement(driver, continueBtn);
		Assert.assertEquals(emptyEmail.getText(), cfg.GetemptyEmailIdAssert());
	}

	public void validEmailIdWithEmptyPassword() {

		launchUrl(driver, cfg.GetUrl());
		clickOnElement(driver, signInbtn);
		passInput(driver, emailId, cfg.GetvalidEmailId());
		clickOnElement(driver, continueBtn);
		passInput(driver, password, cfg.GetEmptyPassword());
		clickOnElement(driver, signInBtn2);
		Assert.assertEquals(emptyPassword.getText(), cfg.GetemptyPasswordAssert());
	}

}
