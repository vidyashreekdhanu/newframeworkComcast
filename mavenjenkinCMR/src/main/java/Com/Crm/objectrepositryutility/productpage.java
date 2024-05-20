package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class productpage {
	
	
	public  productpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement crateimgbtn;
	

@FindBy(name="search3")
private WebElement ele3;


@FindBy(name="search3")
private WebElement ele4;


@FindBy(name="search23")
private WebElement ele5;

}
