package utility.Listeners;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testBase.TestBase;
import ExtentReportListener.ExtentReporterNG;

public class TestListener extends TestBase implements ITestListener {

	ExtentTest test;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	

	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
		test=extent.createTest(getTestMethodName(iTestResult));
		extentTest.set(test);
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
		extentTest.get().log(Status.PASS, "Test passed");
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");
		extentTest.get().fail("Test Failed"+iTestResult.getThrowable());
	
		
		//Instance of test failed
		Object testObj = iTestResult.getInstance(); 
		//Class in which test failed
		Class clazz = iTestResult.getTestClass().getRealClass();
		try {
			//get the driver field of failed test class 
			Field driverField  = clazz.getDeclaredField("driver");
			//Field driverField  = clazz.getField("driver").;
			
			// if driver field is private
			driverField.setAccessible(true);

			// here you get the driver of failed test method
			driver = (WebDriver) driverField.get(testObj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		try{
			// Get Test case i.e. method name
			String testMethodName =iTestResult.getMethod().getMethodName();
			// this method will add the screenshot for failed test in extent report
			extentTest.get().addScreenCaptureFromPath(TestBase.getScreenShotPath(testMethodName,driver), testMethodName);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}


	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
		//ExtentReports log operation for skipped tests.
		//extentTest.get().log(Status.SKIP, "Test skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub

	}

}
