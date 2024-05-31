package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Property.ConfigClass;

public class AmazonSignOut extends BaseClass {

	public  WebDriver driver;

	@FindBy(id = "nav-link-accountList")
	private WebElement signInbtn;

	@FindBy(xpath = "//a[@id='nav-item-signout']")
	private WebElement signOutBtn;

	// constructor
	public AmazonSignOut(WebDriver driver2) {

		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	private static ConfigClass cfg = new ConfigClass();

	public void signOut() {

		moveToElementByAction(signInbtn);
		clickOnElement(driver, signOutBtn);
		String title = driver.getTitle();
		Assert.assertEquals(title, cfg.getSignOutAssert());
	}

}
