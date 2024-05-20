package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationspage {
	
	public organizationspage(WebDriver driver)
	{
		
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createneworgimg;
	
	@FindBy(name="search_text")
	private WebElement searchorg;
	

	@FindBy(name="search_field")
	private WebElement searchDD;
	

	@FindBy(name="submit")
	private WebElement searchnow;
	
	
	
	
	public WebElement getSearchnow() {
		return searchnow;
	}


	public WebElement getSearchorg() {
		return searchorg;
	}


	public WebElement getSearchDD() {
		return searchDD;
	}


	public WebElement getcreateorgimg() {
		return createneworgimg;
	}
	
	
	}

