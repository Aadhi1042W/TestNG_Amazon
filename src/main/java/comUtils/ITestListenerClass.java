package comUtils;

import org.testng.ITestListener;

import org.testng.ITestResult;

import com.Base.BaseClass;
import com.aventstack.extentreports.MediaEntityBuilder;

public class ITestListenerClass extends BaseClass implements ITestListener {

	
	public String testName;
	public String methodName;
	@Override
	public void onTestStart(ITestResult result) {
		
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		
		ExtentReport_Test.extentTest.pass(result.getMethod().getMethodName() + " : "+"Test Pass",
				MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
		
	}
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentReport_Test.extentTest.fail(result.getMethod().getMethodName() + " : "+"Test Fail",
				MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot()).build());
			
	}
		
}
