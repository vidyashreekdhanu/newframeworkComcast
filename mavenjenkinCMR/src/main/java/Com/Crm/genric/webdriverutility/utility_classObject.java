package Com.Crm.genric.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class utility_classObject {
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<ExtentTest>();
	public static ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();
	  
	public static ExtentTest gettest()
	{
		return test.get();
	}

	public static void settest(ExtentTest acttest)
	{
		test.set(acttest);
	}
	public static WebDriver getdriver()
	{
		return driver.get();
	}

	public static void setdriver(WebDriver actdriver)
	{
		driver.set(actdriver);
	}
	
}
