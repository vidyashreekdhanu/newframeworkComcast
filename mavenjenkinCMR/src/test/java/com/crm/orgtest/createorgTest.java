package com.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

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

public class createorgTest extends Baseclass{
	@Test
	public void createorgtest () throws IOException, InterruptedException
	{
		
	  		//data from excel
	  		 excelutility elib = new excelutility();
			 String  orgname = elib.getdatafromexcel("sheet4", 1, 2)+jav.getrandomnum();
		   
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
		 String headinfo = orgv.getOrgnameEd().getText();
		if (headinfo.contains(orgname)) {
			System.out.println(orgname+"is created==pass");
			
		}else {
			System.out.println(orgname+"is not created==fail");
		}
			

	}

	}


