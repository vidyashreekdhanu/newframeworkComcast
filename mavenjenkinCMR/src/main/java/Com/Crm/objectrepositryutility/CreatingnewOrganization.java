package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingnewOrganization {

	public  CreatingnewOrganization(WebDriver driver) {
		
	PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgnameedit;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	

			@FindBy(id="phone")
			private WebElement phonedit;
	
	public WebElement getPhonedit() {
				return phonedit;
			}
	@FindBy(name="industry")
	private WebElement industryDB;
	

	@FindBy(name="accounttype")
	private WebElement typeDB;
	
	public WebElement getOrgnameedit() {
		return orgnameedit;
	}


	public WebElement getSavebtn() {
		return savebtn;
	}


	public void createorg(String orgname) {
		orgnameedit.sendKeys(orgname);
		savebtn.click();
	}
	public void industry(String orgname, String industry)
	{
		orgnameedit.sendKeys(orgname);
		Select sel = new Select(industryDB);
		sel.selectByVisibleText(industry);
		savebtn.click();
		
	}

	public void type (String type)
	{
		
		Select sel = new Select(typeDB);
		sel.selectByVisibleText(type);
		
		
	}

}
