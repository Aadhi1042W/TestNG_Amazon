package com.Runner;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.POM.AmazonLogin;
import com.POM.AmazonPayment;
import com.POM.AmazonSearch;
import com.POM.AmazonSignOut;

import comUtils.ExtentReport_Test;
import comUtils.ITestListenerClass;

@Listeners(ITestListenerClass.class)
public class Amazon extends BaseClass {

	public static WebDriver driver;

	@BeforeTest
	public static void setUp() {

		driver = BaseClass.browserLauch("chrome");

	}

	@Test(priority = 5)
	public void validLoginTest() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Valid email id and password");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		Assert.assertTrue(amazonLogin.validLogIn(ExtentReport_Test.extentTest));
	}

	@Test(priority = 1)
	public void inValidEmailId() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Invalid email id");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.inValidEmailId();
	}

	@Test(priority = 2)
	public void validEmailIdAndInvalidPassword() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Your password is incorrect");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.validEmailIdAndInvalidPassword();
	}

	@Test(priority = 3)
	public void emailIdWithEmptyText() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Enter your email or mobile phone number");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.emailIdWithEmptyText();
	}

	@Test(priority = 4)
	public void validEmailIdWithEmptyPassword() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Enter your password");
		AmazonLogin amazonLogin = new AmazonLogin(driver);
		amazonLogin.validEmailIdWithEmptyPassword();
	}

	@Test(priority = 6)
	private void searchProduct() throws InterruptedException {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search product and displayed product matched");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProduct1();
	}

	@Test(priority = 7)
	private void searchProduct2() throws InterruptedException {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search product and displayed product matched");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProduct2();
	}

	@Test(priority = 8)
	private void searchProduct3() throws InterruptedException {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("Search product and displayed product matched");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProduct3();
	}

	@Test(priority = 9)
	private void searchProductWithInvalidName() throws InterruptedException {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("No result displayed for invalid name");
		AmazonSearch amazonSearch = new AmazonSearch(driver);
		amazonSearch.searchProductWithInvalidName();
	}

	@Test(priority = 10)
	private void makePayment() {

		ExtentReport_Test.extentTest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("message has shown for payment fail");
		AmazonPayment amazonPayment = new AmazonPayment(driver);
		amazonPayment.makePayment();
	}
	
	@Test(priority = 11)
	private void amazonSignOut() {
		ExtentReport_Test.extentTest = extentReports
				.createTest("Login Test" + " : " + Thread.currentThread().getStackTrace()[1].getMethodName().toString())
				.info("message has shown for payment fail");
		AmazonSignOut signOut=new AmazonSignOut(driver);
		signOut.signOut();
	}

	@AfterTest
	public void BrowserClose() {

		terminateBrowser();
	}

	@BeforeSuite
	private void extentReportStartUp() {
		extentReportStart("C:\\Users\\jayaa\\Desktop\\Greens\\IPT\\AmazonProject\\Reports");
	}

	@AfterSuite
	private void extentReportEnd() {
		extentReportTearDown("C:\\Users\\jayaa\\Desktop\\Greens\\IPT\\AmazonProject\\Reports\\index.html");
	}
}
