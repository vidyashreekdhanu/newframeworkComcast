package com.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genricBaseutility.Baseclass;

import Com.Crm.genric.fileutility.excelutility;
import Com.Crm.genric.fileutility.fileutility;
import Com.Crm.genric.webdriverutility.javautility;
import Com.Crm.objectrepositryutility.contactpage;
import Com.Crm.objectrepositryutility.homepage;

public class createcontact_withsupportdatetest extends Baseclass {
	@Test
	public  void createcontact_withdatetest() throws EncryptedDocumentException, IOException, InterruptedException {
		 String lastname = elib.getdatafromexcel("contact", 1, 2)+jav.getrandomnum();
		    
		   //navigate to contact
		   homepage op = new homepage(driver);
			op.getContactlink().click();

			 contactpage con = new contactpage(driver);
			 con.getContactimg().click();
			 con.getLastnamedit().sendKeys(lastname);
		   Thread.sleep(4000);
		   //select date from calender
		  String startdate = jav.getsystem_dateYYYYDDMM();
		  String enddate = jav.getrequireddate(30);

		   //clear the defaultdate
		  
		  con.getSupdate().clear();
		  con.getSupdate().sendKeys(startdate);
		  con.getEnddate().clear();
		  con.getEnddate().sendKeys(enddate);
		    Thread.sleep(2000);
		    con.getSavebtn().click();
		   Thread.sleep(3000);
  System.out.println(startdate);
  System.out.println(enddate);
  
 //verify start date and end date
           String actaulstrart = con.getStartdatever().getText();
           if (actaulstrart.trim().equals(startdate)) 
           {
	 System.out.println(startdate+"information is verified==pass");
     }
           else {
        	   System.out.println(startdate+"information is not verified==fail");
           }
           String actendate = con.getEnddatever().getText();
           if (actendate.trim().equals(enddate)) 
           {
	 System.out.println(enddate+"is verified==pass");
     }
           else {
        	   System.out.println(enddate+"is not verified==fail");
           }
	
	}
	
}
