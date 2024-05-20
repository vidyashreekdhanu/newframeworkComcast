package com.crm.contacttest;

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
import Com.Crm.objectrepositryutility.loginpage;
import Com.Crm.objectrepositryutility.organizationspage;
/**
 * Testclass for contactModule
 * @author vidya
 *
 */
public class create_contacttest extends Baseclass {
	@Test

	public void createcontacttest() throws EncryptedDocumentException, IOException, InterruptedException  {
		 String lastname = elib.getdatafromexcel("contact", 1, 2)+jav.getrandomnum();
		 String phone = elib.getdatafromexcel("contact", 1, 3);
		    homepage op = new homepage(driver);
		  Thread.sleep(3000);
		  //navigate to contact
		op.getContactlink().click();

		 contactpage con = new contactpage(driver);
		 con.getContactimg().click();
		 con.getLastnamedit().sendKeys(lastname);
		 con.getMobidit().sendKeys(phone);
		 con.getSavebtn().click();
		 //verify header info
		   Thread.sleep(3000);
		   String aclast = con.getlastheader().getText();
   
         /*  if (aclast.contains(lastname)) 
           {
	 System.out.println(lastname+"is verified==pass");
     }
           else {
        	   System.out.println(lastname+"is not verified==fail");
           }
 */
 
		   


	}

}
