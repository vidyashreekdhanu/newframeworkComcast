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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.genricBaseutility.Baseclass;

import Com.Crm.genric.fileutility.excelutility;
import Com.Crm.genric.fileutility.fileutility;
import Com.Crm.genric.webdriverutility.javautility;
import Com.Crm.objectrepositryutility.CreatingnewOrganization;
import Com.Crm.objectrepositryutility.contactpage;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.organizationspage;

public class createorg_withphonenumtest extends Baseclass {
@Test
	public void orgwithphonetest() throws EncryptedDocumentException, IOException, InterruptedException {
		 String  phonenum  = elib.getdatafromexcel("sheet4", 7, 3);
			 String  orgname = elib.getdatafromexcel("sheet4", 7, 2)+jav.getrandomnum();
			
	     
		   //navigate to organization
			   
			  homepage op = new homepage(driver);
			  Thread.sleep(3000);
			  op.getOrglink().click();
			  //click on create organization button
			 organizationspage orp = new organizationspage(driver);
			 orp.getcreateorgimg().click();
			 // enter all details
			 CreatingnewOrganization orgn = new CreatingnewOrganization(driver);
			 
			 orgn.getPhonedit().sendKeys(phonenum);
			 orgn.createorg(orgname);
			
		   //verify phoneno
   String actphnu = driver.findElement(By.id("dtlview_Phone")).getText();
    if(actphnu.contains(phonenum))
{
	System.out.println(phonenum+"is created==pass");
	
}else {
	System.out.println(orgname+"is not created==fail");
}
   

	}

}
