package com.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.crm.genricBaseutility.Baseclass;

import BASECLASS.baseclass_2;
import Com.Crm.genric.fileutility.excelutility;
import Com.Crm.genric.fileutility.fileutility;
import Com.Crm.genric.webdriverutility.javautility;
import Com.Crm.objectrepositryutility.CreatingnewOrganization;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.loginpage;
import Com.Crm.objectrepositryutility.organizationspage;
import Com.Crm.objectrepositryutility.organizationverificationpage;

public class createorg_withindustry_typetest extends baseclass_2 {
	@Test
	public void createorgindustrytest() throws InterruptedException, EncryptedDocumentException, IOException {
		 String  industy  = elib.getdatafromexcel("sheet4", 4, 3);
			 String  orgname = elib.getdatafromexcel("sheet4", 4, 2)+jav.getrandomnum();
			 String  type = elib.getdatafromexcel("sheet4", 4, 4);
			
	  	
			  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			 Thread.sleep(4000);
		 homepage ho = new homepage(driver)	;
		 ho.getOrglink().click();
		 //click on create new organization
		 organizationspage org = new organizationspage(driver);
		 org.getcreateorgimg().click();
		
		 //enter details
		 CreatingnewOrganization cro = new CreatingnewOrganization(driver);
		 cro.type(type);
		 cro.industry(orgname, industy);
	  //verify thedropdown industry and type
		organizationverificationpage orgv = new organizationverificationpage(driver);
		   String actind = orgv.getIndustdd().getText();
		    if(actind.equals(industy))
		    {
		    	System.out.println(industy+"information is verified");
		    }
		    else {
		    	System.out.println(orgname+"information is not verified");
		    	
			}

			
		    //CLOSE THE BRWOSE
		
	}

}
