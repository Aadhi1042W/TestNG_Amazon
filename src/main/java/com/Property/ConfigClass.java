package com.Property;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigClass {

 	public static Properties p;

	public ConfigClass() {

		File f = new File(
				"C:\\Users\\jayaa\\OneDrive\\Desktop\\testing\\AmazonProject\\AmazonProject\\src\\main\\java\\com\\Property\\configurationReader.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			p = new Properties();
			p.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String GetUrl() {
		String url = p.getProperty("url");

		return url;
	}

	public String GetvalidEmailId() {
		String validEmailId = p.getProperty("validEmailId");

		return validEmailId;
	}

	public String GetvalidPassword() {
		String validPassword = p.getProperty("validPassword");

		return validPassword;
	}

	public String GetinvalidEmailId() {
		String invalidEmailId = p.getProperty("invalidEmailId");

		return invalidEmailId;
	}

	public String GetinValidPassword() {
		String inValidPassword = p.getProperty("inValidPassword");

		return inValidPassword;
	}

	public String GetemptyEmailId() {
		String emptyEmailId = p.getProperty("emptyEmailId");

		return emptyEmailId;
	}

	public String GetEmptyPassword() {
		String emptyPassword = p.getProperty("EmptyPassword");

		return emptyPassword;
	}

	public String GetProduct1() {
		String product1 = p.getProperty("Product1");

		return product1;
	}

	public String Getproduct2() {
		String product2 = p.getProperty("product2");

		return product2;
	}

	public String Getproduct3() {
		String product3 = p.getProperty("product3");

		return product3;
	}

	public String GetinvalidProductName() {
		String ivalidProductName = p.getProperty("invalidProductName");

		return ivalidProductName;
	}

	public String GetvalidLoginAssert() {
		String validLoginAssert = p.getProperty("validLoginAssert");

		return validLoginAssert;
	}

	public String GetinvalidEmailAssert() {
		String invalidEmailAssert = p.getProperty("invalidEmailAssert");

		return invalidEmailAssert;
	}

	public String GetinvalidPasswordAssert() {
		String invalidPasswordAssert = p.getProperty("invalidPasswordAssert");

		return invalidPasswordAssert;
	}

	public String GetemptyEmailIdAssert() {
		String emptyEmailIdAssert = p.getProperty("emptyEmailIdAssert");

		return emptyEmailIdAssert;
	}

	public String GetemptyPasswordAssert() {
		String emptyPasswordAssert = p.getProperty("emptyPasswordAssert");

		return emptyPasswordAssert;
	}

	public String GetamazonSearchProductAssert() {
		String amazonSearchProductAssert = p.getProperty("amazonSearchProductAssert");

		return amazonSearchProductAssert;
	}

	public String GetinvalidProductSearchAssert() {
		String invalidProductSearchAssert = p.getProperty("invalidProductSearchAssert");

		return invalidProductSearchAssert;
	}

	public String GetCardNumber() {
		String cardNumber = p.getProperty("cardNumber");

		return cardNumber;
	}

	public String GetmakePaymentAssert() {
		String makePaymentAssert = p.getProperty("makePaymentAssert");

		return makePaymentAssert;
	}
	
	public String getSignOutAssert() {
		String signOutAssert = p.getProperty("signOutAssert");

		return signOutAssert;
	}

}
