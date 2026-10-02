package org.rahulshettyacademy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.And;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.rahulshettyacademy.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners  implements ITestListener {

    ExtentReports extentReports;
    ExtentTest test;
    //AndroidDriver driver;
    @Override
    public void onTestStart(ITestResult  iTestResult) {
        System.out.println("Test Started: " + iTestResult.getName());
        String path= System.getProperty("user.dir")+"\\reports\\index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Subir Sardar");
        test=extentReports.createTest(iTestResult.getMethod().getMethodName());
        test.log(Status.INFO, "Test Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("Test Success: " + iTestResult.getName());
        test.log(Status.PASS, "Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("Test Failure: " + iTestResult.getName());
        test.log(Status.FAIL, "Test Failed");
        test.fail(iTestResult.getThrowable());
        //use if driver is non-static
        //driver = (AndroidDriver) iTestResult.getTestClass().getRealClass().getField("driver").get(iTestResult.getInstance());
        //screenshot code
        //this method is coming from utills>AndroidActions
        test.addScreenCaptureFromPath(AndroidActions.getScreenshotPath(iTestResult.getMethod().getMethodName(), AndroidBaseTest.driver), iTestResult.getMethod().getMethodName());


    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Skipped: " + iTestResult.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("All Tests Finished: " + iTestContext.getName());
        extentReports.flush();
    }
}
