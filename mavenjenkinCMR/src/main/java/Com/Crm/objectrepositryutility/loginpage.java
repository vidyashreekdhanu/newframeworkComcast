package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.Crm.genric.webdriverutility.webdriver_utility;
/**
 * 
 * @author vidya
 * contain login page elements and buisness laibrary like login()
 *
 */

public class loginpage  extends webdriver_utility{
WebDriver driver;
	public loginpage(WebDriver driver) {
		this.driver= driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="user_name")
	private WebElement userNameEdit;

	@FindBy(name="user_password")
	private WebElement passwordEdit;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	/**
	 * login to application based on username password ,url arguments
	 * @param url1
	 * @param username
	 * @param password
	 */
	public void logintoapp(String url1,String username, String password)
	{
		waitforpagetoload(driver);
		driver.get(url1);
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginbtn.click();
	}
	
	


}
