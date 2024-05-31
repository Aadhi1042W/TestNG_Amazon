package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.Base.BaseClass;
import com.Property.ConfigClass;

public class AmazonSearch extends BaseClass {

	public static WebDriver driver;

	@FindBy(xpath = "//input[@id='twotabsearchtextbox']")
	private WebElement searchBox;

	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	private WebElement searchBtn;

	@FindBy(xpath = "(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")
	private WebElement product1;

	@FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
	private WebElement cartBtn;

	@FindBy(xpath = "//input[@aria-labelledby='attach-sidesheet-view-cart-button-announce']")
	private WebElement addCart;

	@FindBy(xpath = "(//div[@class='a-row'])[1]")
	private WebElement noResultproduct;

	@FindBy(className = "s-no-outline")
	private WebElement invalidName;

	@FindBy(xpath = "(//div[@class='a-row'])[1]")
	private WebElement noResultMsg;

	// constructor
	public AmazonSearch(WebDriver driver1) {

		this.driver = driver1;
		PageFactory.initElements(driver, this);
	}

	private static ConfigClass cfg = new ConfigClass();

	public void searchProduct1() {

		implicitWait(30);
		clickOnElement(driver, searchBox);
		passInput(driver, searchBox, cfg.GetProduct1());
		clickOnElement(driver, searchBtn);
		clickOnElement(driver, product1);
		staticWait(5000);
		windowHandler(1);
		JSScrollBy(900);
		JSFindElement(cartBtn);
		staticWait(5000);
		clickOnElement(driver, addCart);

		String title = driver.getTitle();
		Assert.assertEquals(title, cfg.GetamazonSearchProductAssert());
		closeTab();
		windowHandler(0);
	}

	public void searchProduct2() {

		implicitWait(30);
		clearText(searchBox);
		clickOnElement(driver, searchBox);
		passInput(driver, searchBox, cfg.Getproduct2());
		clickOnElement(driver, searchBtn);
		clickOnElement(driver, product1);
		staticWait(5000);
		windowHandler(1);
		JSScrollBy(900);
		JSFindElement(cartBtn);
		staticWait(5000);
		clickOnElement(driver, addCart);

		String title = driver.getTitle();
		Assert.assertEquals(title, cfg.GetamazonSearchProductAssert());
		closeTab();
		windowHandler(0);
	}

	public void searchProduct3() {

		implicitWait(30);
		clearText(searchBox);
		clickOnElement(driver, searchBox);
		passInput(driver, searchBox, cfg.Getproduct3());
		clickOnElement(driver, searchBtn);
		clickOnElement(driver, product1);
		staticWait(5000);
		windowHandler(1);
		JSScrollBy(900);
		JSFindElement(cartBtn);
		staticWait(5000);
		clickOnElement(driver, addCart);

		String title = driver.getTitle();
		Assert.assertEquals(title, cfg.GetamazonSearchProductAssert());

	}

	public void searchProductWithInvalidName() {

		implicitWait(30);
		clickOnElement(driver, searchBox);
		passInput(driver, searchBox, cfg.GetinvalidProductName());
		clickOnElement(driver, searchBtn);
		Assert.assertEquals(noResultMsg.getText(), cfg.GetinvalidProductSearchAssert());

	}

}
