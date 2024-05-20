	package Com.Comcast.Crm.lister;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BASECLASS.baseclass_2;
import Com.Crm.genric.webdriverutility.utility_classObject;

public class Implimentclass implements ITestListener,ISuiteListener{
	public static ExtentReports report;
	 public ExtentSparkReporter spark;
	 public  ExtentTest test;
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
	System.out.println("report configuration");
	//spark report confict

	Date da = new Date();
	String dt = da.toString().replaceAll(":", "-");
			ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReoprt/report_"+dt+".html");
	   spark.config().setDocumentTitle("CRM TEST RESULT");
	   spark.config().setReportName("CRM report");
	   spark.config().setTheme(Theme.DARK);
	//add env information and create test
	    report = new ExtentReports();
	  report.attachReporter(spark);
	   report.setSystemInfo("os", "windows-10");
	  report.setSystemInfo("browser", "chrome");
			


	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		report.flush();
			}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====="+result.getMethod().getMethodName()+"==START==");
		
	 test = report.createTest(result.getMethod().getMethodName());
	 utility_classObject.settest(test);
	 test.log(Status.INFO, result.getMethod().getMethodName()+"=====STARTED");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("====="+result.getMethod().getMethodName()+"==END==");
		 test.log(Status.PASS, result.getMethod().getMethodName()+"=====COMPLETED");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String TCname = result.getMethod().getMethodName();
		TakesScreenshot tss = (TakesScreenshot)utility_classObject.getdriver();
		String filepath = tss.getScreenshotAs(OutputType.BASE64);
		
		
		Date da = new Date();
		//String dt = da.toString().replace(" ", "_").replace(":", "_");
		String dt = da.toString().replaceAll(":", "-");
		test.addScreenCaptureFromBase64String(filepath,TCname+""+dt);
		 test.log(Status.FAIL, result.getMethod().getMethodName()+"=====FAIED");
	
	}
	

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
			}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
			}

}
