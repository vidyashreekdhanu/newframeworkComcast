package BASECLASS;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Com.Crm.genric.databaseutility.databaseutility;
import Com.Crm.genric.fileutility.excelutility;
import Com.Crm.genric.fileutility.fileutility;
import Com.Crm.genric.webdriverutility.javautility;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.loginpage;

public class grid_baseclass1 {
	public excelutility elib = new excelutility();
	 public javautility jav = new javautility();
	public databaseutility dlib = new databaseutility();
	public fileutility fli = new fileutility();
	 public WebDriver driver=null;
	 public static WebDriver sdriver=null;
	public ExtentReports report;
	 public ExtentSparkReporter spark;
	 public static  WebDriver griddriver=null;
	 
	 
	@BeforeSuite(groups = {"regressiontest","smoketest"})
	public void confiBS()
	{
		System.out.println("connect to DB, reportconf");
	
		dlib.getDBconnection();

		//spark report confict
		ExtentSparkReporter spark = new ExtentSparkReporter("./advanceReoprt/report.html");
   spark.config().setDocumentTitle("CRM TEST RESULT");
   spark.config().setReportName("CRM report");
   spark.config().setTheme(Theme.DARK);
//add env information and create test
    report = new ExtentReports();
  report.attachReporter(spark);
   report.setSystemInfo("os", "windows-10");
  report.setSystemInfo("browser", "chrome");
		

	}
	@Parameters("BROWSER")
	
	@BeforeClass(groups = {"regressiontest","smoketest"})
	public void configBC(String BROWSER) throws IOException
	
	{
		System.out.println("launch Browser");
		//String br=browser;
		URL url = new URL("http://10.10.20.99:4444");
		DesiredCapabilities dc = new DesiredCapabilities();
		
		//String br = fli.getdatafromproperties("browser");
		 if(BROWSER.equalsIgnoreCase("edge")) 
		  {  
			 dc.setBrowserName("edge");
			 dc.setPlatform(Platform.WINDOWS);
		  } 
		 else if(BROWSER.equalsIgnoreCase("firefox"))
		  
		  { 
			  dc.setBrowserName("firefox");
				 dc.setPlatform(Platform.WINDOWS);
		  }
		 
		 driver= new RemoteWebDriver(url,dc);
		 griddriver = driver;
		 
	}
	@BeforeMethod(groups = {"regressiontest","smoketest"})
	public void configBM() throws IOException
	{

		String url1 = fli.getdatafromproperties("url");
		String un = fli.getdatafromproperties("username");
		String pass = fli.getdatafromproperties("password");
		
		loginpage lp = new loginpage(driver);
		lp.logintoapp(url1,un, pass);
	}
	
	@AfterMethod(groups = {"regressiontest","smoketest"})
	public void configAM()
	{
		System.out.println("logout");
		homepage ho = new homepage(driver);
		ho.logout();
	}
	@AfterClass(groups = {"regressiontest","smoketest"})
	public void configAC()
	{
		System.out.println("close Browser ");
		driver.quit();
		
	}
	@AfterSuite(groups = {"regressiontest","smoketest"})
	public void confiAS() throws SQLException
	{

		System.out.println("close to DB, reportbackup");
		dlib.closedbconnection();
		report.flush();
	}
	
	


}
