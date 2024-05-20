package BASECLASS;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import Com.Crm.genric.webdriverutility.utility_classObject;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.loginpage;


public class baseclass_2 {
	public excelutility elib = new excelutility();
	 public javautility jav = new javautility();
	public databaseutility dlib = new databaseutility();
	public fileutility fli = new fileutility();
	 public WebDriver driver=null;
	 public static WebDriver sdriver=null;
	
	@BeforeSuite(groups = {"regressiontest","smoketest"})
	 
	public void confiBS()
	{
		System.out.println("connect to DB, reportconf");
	
		dlib.getDBconnection();
	}
	@Parameters("BROWSER")
	
	@BeforeClass(groups = {"regressiontest","smoketest"})
	public void configBC(String browser) throws IOException
//public void configBC() throws IOException
	
	{
		System.out.println("launch Browser");
		//String br=browser;
		
		String br = fli.getdatafromproperties("browser");
		 if(br.equals("chrome")) 
		  { driver=new ChromeDriver(); 
		  } else if
		  (br.equals("firefox"))
		  { driver= new FirefoxDriver(); }
		  else if
		  (br.equals("edge"))
		  { driver= new EdgeDriver();
		  } else { driver= new
		  ChromeDriver(); 
		  }
		 sdriver=driver;
		 utility_classObject.setdriver(driver);
		 
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
	
	}
	
	


}
