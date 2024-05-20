package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepage {
		WebDriver driver;
	public homepage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	

@FindBy(linkText = "Products")
private WebElement product;

	
	@FindBy(linkText = "Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignlink;
	
	@FindBy(linkText = "more")
	private WebElement morelink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signoutlink;
	
	

	public WebElement getAdministatorimg() {
		return administatorimg;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	public WebElement getOrglink() {
		return orglink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public WebElement navigatetocampaign()
	{
		Actions act = new Actions(driver);
		act.moveToElement(morelink).perform();
		return campaignlink;
	}

	public void logout()
	{
		Actions act = new Actions(driver);
		act.moveToElement(administatorimg).perform();
		signoutlink.click();

		
	}

}
