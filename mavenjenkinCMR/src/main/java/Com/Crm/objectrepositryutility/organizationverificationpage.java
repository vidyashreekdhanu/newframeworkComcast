package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationverificationpage {
	
	public  organizationverificationpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		}
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headermsg;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgnameEd;
	

	@FindBy(id="mouseArea_Last Name")
			private WebElement lastedt;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement Industdd;
	

	public WebElement getLastedt() {
		return lastedt;
	}
	@FindBy(id="dtlview_Type")
	private WebElement typedd;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phoneEdt;

	public WebElement getHeadermsg() {
		return headermsg;
	}

	public WebElement getOrgnameEd() {
		return orgnameEd;
	}

	public WebElement getIndustdd() {
		return Industdd;
	}

	public WebElement getTypedd() {
		return typedd;
	}

	public WebElement getPhoneEdt() {
		return phoneEdt;
	}
	
	
	
	
	
}
