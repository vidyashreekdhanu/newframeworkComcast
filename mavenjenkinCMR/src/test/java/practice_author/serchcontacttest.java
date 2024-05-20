package practice_author;

 /**
  * test class for contactmodule
  * @author vidya
  *
  */

import org.testng.annotations.Test;

import com.crm.genricBaseutility.Baseclass;

import Com.Crm.objectrepositryutility.loginpage;

public class serchcontacttest extends Baseclass {
	/**
	 * login()==>navigate to contact==>create contact()
	 */
	@Test
	public void serchcontacttest()
	{/*login to app*/
		loginpage lp=new loginpage(driver);
		lp.logintoapp(null, null, null);
	}

}
