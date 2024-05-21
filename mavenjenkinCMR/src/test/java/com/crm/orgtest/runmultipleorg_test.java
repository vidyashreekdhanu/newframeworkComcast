package com.crm.orgtest;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.crm.genricBaseutility.Baseclass;

import BASECLASS.baseclass_2;
import BASECLASS.grid_baseclass1;
import Com.Comcast.Crm.lister.Implimentclass;
import Com.Crm.genric.fileutility.excelutility;
import Com.Crm.genric.webdriverutility.utility_classObject;
import Com.Crm.objectrepositryutility.CreatingnewOrganization;
import Com.Crm.objectrepositryutility.contactpage;
import Com.Crm.objectrepositryutility.homepage;
import Com.Crm.objectrepositryutility.organizationspage;
import Com.Crm.objectrepositryutility.organizationverificationpage;

public class runmultipleorg_test extends Baseclass {
	@Test(groups = "smoketest")
	public void createorgtest() throws EncryptedDocumentException, IOException, InterruptedException {
		// data from excel
		//utility_classObject.gettest().log(Status.INFO, "read data from excel");
		excelutility elib = new excelutility();
		String orgname = elib.getdatafromexcel("sheet4", 1, 2) + jav.getrandomnum();
		
		homepage op = new homepage(driver);
		
		Thread.sleep(3000);
		
		op.getOrglink().click();
	//	utility_classObject.gettest().log(Status.INFO, "navigate to og page");
		// click on create organization button
		organizationspage orp = new organizationspage(driver);
		orp.getcreateorgimg().click();
		// enter all details
	//	utility_classObject.gettest().log(Status.INFO, "navigate to create org page");
		CreatingnewOrganization orgn = new CreatingnewOrganization(driver);

		orgn.createorg(orgname);
		
		//utility_classObject.gettest().log(Status.INFO,orgname+ "navigate to og page");

		// verify headermsg
		organizationverificationpage orgv = new organizationverificationpage(driver);
		String headinfo = orgv.getHeadermsg().getText();
		//Assert.assertEquals(true, headinfo.contains(orgname));	
		//boolean actualhed = headinfo.contains(orgname);
		
		//Assert.assertTrue(actualhed);
	
		
//		if (headinfo.contains(orgname)) {
//			System.out.println(orgname + "is created==pass");
//
//		} else {
//			System.out.println(orgname + "is not created==fail");
//		}

	}

	@Test(groups = "regressiontest")
	public void createorgwithindus_test() throws InterruptedException, EncryptedDocumentException, IOException {
		String industy = elib.getdatafromexcel("sheet4", 4, 3);
		String orgname = elib.getdatafromexcel("sheet4", 4, 2) + jav.getrandomnum();
		String type = elib.getdatafromexcel("sheet4", 4, 4);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(4000);
		homepage ho = new homepage(driver);
		ho.getOrglink().click();
		// click on create new organization
		organizationspage org = new organizationspage(driver);
		org.getcreateorgimg().click();

		// enter details
		CreatingnewOrganization cro = new CreatingnewOrganization(driver);
		 cro.type(type);
		cro.industry(orgname, industy);

		// verify thedropdown industry and type
		organizationverificationpage orgv = new organizationverificationpage(driver);
		String actind = orgv.getIndustdd().getText();
		//boolean status = actind.trim().equals(industy);
		SoftAssert sof = new SoftAssert();
		sof.assertEquals(actind, industy);
//		if (actind.equals(industy)) {
//			System.out.println(industy + "information is verified");
//		} else {
//			System.out.println(orgname + "information is not verified");
//
//		}

	}

	@Test(groups = "regressiontest")
	public void createorgwithphone_test() throws InterruptedException, EncryptedDocumentException, IOException {
		String phonenum = elib.getdatafromexcel("sheet4", 7, 3);
		String orgname = elib.getdatafromexcel("sheet4", 7, 2) + jav.getrandomnum();

		// navigate to organization

		homepage op = new homepage(driver);
		Thread.sleep(3000);
		op.getOrglink().click();
		// click on create organization button
		organizationspage orp = new organizationspage(driver);
		orp.getcreateorgimg().click();
		// enter all details
		CreatingnewOrganization orgn = new CreatingnewOrganization(driver);

		orgn.getPhonedit().sendKeys(phonenum);
		orgn.createorg(orgname);

		// verify phoneno
		String actphnu = driver.findElement(By.id("dtlview_Phone")).getText();
		boolean ph = actphnu.trim().equals(phonenum);
		Assert.assertTrue(ph);
//		if (actphnu.contains(phonenum)) {
//			System.out.println(phonenum + "is created==pass");
//
//		} else {
//			System.out.println(orgname + "is not created==fail");
//		}
	}

	
}
