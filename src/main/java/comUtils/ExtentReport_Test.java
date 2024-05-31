package comUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Base.BaseClass;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReport_Test extends BaseClass {

	public static ExtentTest extentTest;

	@BeforeSuite
	public void extentReportStartUp() {

		extentReportStart(null);
	}

	@AfterSuite
	public void extentReportStartEnd() {

		extentReportTearDown(null);
	}

}
