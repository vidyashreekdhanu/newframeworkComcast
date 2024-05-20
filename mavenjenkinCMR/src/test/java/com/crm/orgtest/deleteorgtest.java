package com.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Com.Crm.genric.fileutility.excelutility;
import Com.Crm.genric.fileutility.fileutility;
import Com.Crm.genric.webdriverutility.javautility;
import Com.Crm.genric.webdriverutility.webdriver_utility;
import Com.Crm.objectrepositryutility.CreatingnewOrganization;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.loginpage;
import Com.Crm.objectrepositryutility.organizationspage;
import Com.Crm.objectrepositryutility.organizationverificationpage;

public class deleteorgtest {

@Test
	public  void delete() throws IOException, InterruptedException {
		fileutility flib = new fileutility();
	      String br = flib.getdatafromproperties("browser");
	      String url = flib.getdatafromproperties("url");
	     String un = flib.getdatafromproperties("username");
	    String pass = flib.getdatafromproperties("password");
		     
		  //generate random num
	   javautility jav = new javautility();
	  
	  		
	  		//data from excel
	  		 excelutility elib = new excelutility();
			 String  orgname = elib.getdatafromexcel("sheet4",10,2)+jav.getrandomnum();
			
			webdriver_utility wlib = new webdriver_utility();
		  // WebDriverManager.firefoxdriver().setup();
		   WebDriver driver;
			
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
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//login to application 
		   
		   loginpage log = new loginpage(driver);
		   log.logintoapp(url,un, pass);
		   
		  homepage op = new homepage(driver);
		  Thread.sleep(3000);
		  op.getOrglink().click();
		  //click on create organization button
		 organizationspage orp = new organizationspage(driver);
		 orp.getcreateorgimg().click();
		 // enter all details
		 CreatingnewOrganization orgn = new CreatingnewOrganization(driver);
		 orgn.createorg(orgname);
		
		 
		//verify headermsg
		organizationverificationpage orgv = new organizationverificationpage(driver);
		 String headinfo = orgv.getHeadermsg().getText();
		if (headinfo.contains(orgname)) {
			System.out.println(orgname+"is created==pass");
			
		}else {
			System.out.println(orgname+"is not created==fail");
		}
			
		


		//go back to organization page
		 homepage hp = new homepage(driver);
		  Thread.sleep(3000);
		  hp.getOrglink().click();
		
		//search for organization
		  orp.getSearchorg().sendKeys(orgname);
		  wlib.select(orp.getSearchDD(),"Organization Name");
		  orp.getSearchnow().click();
		  
		//in dynamic webelement select and delete org
		  driver.findElement(By.xpath("//a[text()='"+orgname+"']/../../td[8]/a[text()='del']")).click();
		  
		//logout

	}
}