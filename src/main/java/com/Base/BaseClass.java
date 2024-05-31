package com.Base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseClass {

	protected static WebDriver driver;
	protected static ExtentReports extentReports;
	protected static File file;

	protected static WebDriver browserLauch(String browsername) {
		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("incognito");
//			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browsername.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected void launchUrl(WebDriver driver, String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void passInput(WebDriver driver, WebElement element, String input) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.sendKeys(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void clickOnElement(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element))
					.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void staticWait(long sec) {
		try {
			Thread.sleep(sec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void windowHandler(int index) {

		Set<String> windows = driver.getWindowHandles();
		List<String> li = new ArrayList<String>(windows);
		driver.switchTo().window(li.get(index));
	}

	public void JSFindElement(WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	public void JSScrollBy(int dist) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + dist + ");", "");

	}

	public void clearText(WebElement element) {

		element.clear();
	}
	
	
	public void frameByIndex(int index) {

		driver.switchTo().frame(index);
	}

	// implicit wait
	public static void implicitWait(int sec) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));

	}
	
	
	// explicit wait
	public static void explicitWait(Duration sec,WebElement value) {

			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(value));
		}

	// Screenshot Method
	protected void screenShot(WebDriver driver, String name) {

		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File("C:\\Users\\jayaa\\OneDrive\\Desktop\\testing\\AmazonProject\\AmazonProject\\ScreenShots\\" + name + ".png");
		try {
			FileHandler.copy(scrfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Another ScreenShot method
	protected String takeScreenShot() {

		String timeStamp = new SimpleDateFormat("yyyymmdd_hhmmss").format(new Date());
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destfile = new File(
				"C:\\Users\\jayaa\\OneDrive\\Desktop\\testing\\AmazonProject\\AmazonProject\\ScreenShots\\" + timeStamp + ".png");
		try {
			FileHandler.copy(scrfile, destfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destfile.getAbsolutePath();
	}

	// Java Script Executor Methods
	protected void scroll(WebDriver driver, int x, int y) {
		try {

			((JavascriptExecutor) driver).executeScript("window.scrollBy(" + x + "," + y + ");");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void jsClick(WebDriver driver, WebElement element) {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected static String fullScreenshot(String location) {

		Screenshot takess = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000))
				.takeScreenshot(driver);
		try {
			ImageIO.write(takess.getImage(), "PNG", new File(location));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return location;

	}

	protected static void extentReportStart(String location) {

		extentReports = new ExtentReports();
		file = new File(location);

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("OS", System.getProperty("OS.name"));
		extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));

	}

	protected void extentReportTearDown(String location) {

		extentReports.flush();
		file = new File(location);
		try {
			Desktop.getDesktop().browse((file).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void moveToElementByAction(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();

	}


	
	
	protected void closeTab() {
		driver.close();
	}

	protected void terminateBrowser() {
		driver.quit();
	}
}
