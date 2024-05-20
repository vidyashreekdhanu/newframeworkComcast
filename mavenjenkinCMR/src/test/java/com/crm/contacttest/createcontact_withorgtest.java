package com.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hpsf.Array;
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
import Com.Crm.genric.webdriverutility.webdriver_utility;
import Com.Crm.objectrepositryutility.CreatingnewOrganization;
import Com.Crm.objectrepositryutility.contactpage;
import Com.Crm.objectrepositryutility.createcont_withorgpage;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.organizationspage;
import Com.Crm.objectrepositryutility.organizationverificationpage;

public class createcontact_withorgtest extends Baseclass{
@Test
	public void createcontactorg() throws InterruptedException, EncryptedDocumentException, IOException  {
		String lastname = elib.getdatafromexcel("contact", 1, 2)+jav.getrandomnum();
			 String orgname = elib.getdatafromexcel("contact", 3, 2)+jav.getrandomnum();
	homepage op = new homepage(driver);
	op.getOrglink().click();
		   
		   Thread.sleep(4000);
		   organizationspage orp = new organizationspage(driver);
			 orp.getcreateorgimg().click();
			 // enter all details
			 CreatingnewOrganization orgn = new CreatingnewOrganization(driver);
			 orgn.createorg(orgname);
			 //verify org
			 organizationverificationpage orgv = new organizationverificationpage(driver);
			 String headinfo = orgv.getOrgnameEd().getText();
			if (headinfo.contains(orgname)) {
				System.out.println(orgname+"is created==pass");
				
			}else {
				System.out.println(orgname+"is not created==fail");
			}
			


		    //navigate to contact
		    Thread.sleep(4000);
		    		 op.getContactlink().click();

		//create to contact module
		 contactpage con = new contactpage(driver);
		 con.getContactimg().click();
		createcont_withorgpage cr = new createcont_withorgpage(driver);
		cr.getCreateimg().click();
			
		 //con.getLastnamedit().sendKeys(lastname);
		webdriver_utility wlib = new webdriver_utility();
			 wlib.switchto_tabonurl(driver,"module=accounts" );
			 cr.getSerchedit().sendKeys(orgname);
			 cr.getSerchnow().click();
			   driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
			   //parent window
			  wlib.switchto_tabonurl(driver,"module=Contacts" );
			   con.getLastnamedit().sendKeys(lastname);
			    Thread.sleep(2000);
			  con.getSavebtn().click();
			   //verify lastname
			 
			 String actulastname = orgv.getLastedt().getText();
			  
			   System.out.println(actulastname);
				 if(actulastname.trim().equals(lastname))
				 {
					 System.out.println(lastname+"is veriied pass");
				 }
				 else {
					 System.out.println(lastname+"is not veriied fail");
				}
				 
			   

	}

}
