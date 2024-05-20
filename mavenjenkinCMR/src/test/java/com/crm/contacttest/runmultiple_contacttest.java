package com.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.genricBaseutility.Baseclass;

import BASECLASS.grid_baseclass1;
import Com.Crm.genric.webdriverutility.webdriver_utility;
import Com.Crm.objectrepositryutility.CreatingnewOrganization;
import Com.Crm.objectrepositryutility.contactpage;
import Com.Crm.objectrepositryutility.createcont_withorgpage;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.organizationspage;
import Com.Crm.objectrepositryutility.organizationverificationpage;
/**
 * create contact test
 * @author vidya
 *
 */
public class runmultiple_contacttest extends Baseclass {
	@Test(groups = "smoketest")
	public void createcontact_test() throws EncryptedDocumentException, IOException, InterruptedException {
		/*Fetch Data from Excel*/
		String lastname = elib.getdatafromexcel("contact", 1, 2);
		String phone = elib.getdatafromexcel("contact", 1, 3);
		/*Navigate to HomePage*/
		homepage op = new homepage(driver);
		Thread.sleep(3000);
		
		op.getContactlink().click();
/*Enter All details to create contact */
		contactpage con = new contactpage(driver);
		con.getContactimg().click();
		con.getLastnamedit().sendKeys(lastname);
		con.getMobidit().sendKeys(phone);
		con.getSavebtn().click();
		/* verify header info*/
		Thread.sleep(3000);
		String acthead = con.getHeaderinfo().getText();
		
		
		boolean status = acthead.contains(lastname);
		Assert.assertTrue(status);
		
	}

	@Test(groups = "regressiontest")
	public void createcontactwithorg_test() throws EncryptedDocumentException, IOException, InterruptedException {
		/*Fetch Data From Excel*/
		String lastname = elib.getdatafromexcel("contact", 1, 2) + jav.getrandomnum();
		String orgname = elib.getdatafromexcel("contact", 3, 2) + jav.getrandomnum();
		/*Navigate to Homepage*/
		homepage op = new homepage(driver);
		op.getOrglink().click();

		/*navigate to organization page*/
		organizationspage orp = new organizationspage(driver);
		orp.getcreateorgimg().click();
		// enter all details
		CreatingnewOrganization orgn = new CreatingnewOrganization(driver);
		orgn.createorg(orgname);
		// verify org
		organizationverificationpage orgv = new organizationverificationpage(driver);
		String headinfo = orgv.getOrgnameEd().getText();
//		if (headinfo.contains(orgname)) {
//			System.out.println(orgname + "is created==pass");
//
//		} else {
//			System.out.println(orgname + "is not created==fail");
//		}
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(headinfo, orgname);
		
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
		boolean status = actulastname.contains(lastname);
		 //SoftAssert ass = new SoftAssert();
		 Assert.assertTrue(status);
		 //soft.assertAll();
		  
//			 if(actulastname.trim().equals(lastname))
//			 {
//				 System.out.println(lastname+"is veriied pass");
//			 }
//			 else {
//				 System.out.println(lastname+"is not veriied fail");
//			}
	}
	@Test(groups = "regressiontest")
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
          String actualstrart = con.getStartdatever().getText();
         boolean st = actualstrart.contains(actualstrart);
         //SoftAssert soft = new SoftAssert();
          Assert.assertTrue(st);
         // soft.assertAll();
          
//          if (actaulstrart.trim().equals(startdate)) 
//          {
//	 System.out.println(startdate+"information is verified==pass");
//    }
//          else {
//       	   System.out.println(startdate+"information is not verified==fail");
//          }
          String actendate = con.getEnddatever().getText();
        boolean end = actendate.contains(enddate);
          Assert.assertEquals(end, true);
//          if (actendate.trim().equals(enddate)) 
//          {
//	 System.out.println(enddate+"is verified==pass");
//    }
//          else {
//       	   System.out.println(enddate+"is not verified==fail");
//          }
}
}