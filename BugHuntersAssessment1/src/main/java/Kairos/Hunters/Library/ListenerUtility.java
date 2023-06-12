package Kairos.Hunters.Library;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Kairos.Hunters.BaseClass.BaseClass;

public class ListenerUtility implements ITestListener, IAnnotationTransformer{
	ExtentReports report;
	ExtentTest test;
	ConstantUtils path=new ConstantUtils();
	DataUtility data=new DataUtility();
	protected LoggerClass log=new LoggerClass();
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName); // test is created which will initialize the individual test execution
		
		Reporter.log(methodName+" => test script execution started",true);
	
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.PASS, methodName+" ---> passed");
		Reporter.log(" Successful"+methodName);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL, methodName+ "---> Failed");
		test.log(Status.FAIL, result.getThrowable());
		JavaUtils.captureScreenShot(BaseClass.driver);
		Reporter.log("Failed -"+methodName);
		log.error(methodName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName +" ---> Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("skipped -"+methodName);
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log("Test started",true);
		
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(path.getRepots()+"/Report-"+JavaUtils.getDateNTime("dd_MM_YYYY_hh_mm")+".html");
		htmlReport.config().setDocumentTitle("OutLook Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("OutLook Report");
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("Base-platform", "Windows");
		report.setSystemInfo("Base-URL", data.fetchProperty("BaseURL"));
		report.setSystemInfo("Reporter Name", "BugHunters");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		Reporter.log("Test Finished.");
		
	}
	@Override
	 public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		   annotation.setRetryAnalyzer(RetryAnalyzer.class);
		  }
	
	
	
}
