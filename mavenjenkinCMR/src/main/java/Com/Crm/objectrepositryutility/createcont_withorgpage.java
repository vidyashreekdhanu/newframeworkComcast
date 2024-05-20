package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createcont_withorgpage {
	public  createcont_withorgpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
@FindBy(name="search_text")
private WebElement serchedit;


@FindBy(name="search")
private WebElement serchnow;



@FindBy(xpath = "//img[@title='Select']")
private WebElement createimg;

public WebElement getCreateimg() {
	return createimg;
}


public WebElement getSerchedit() {
	return serchedit;
}


public WebElement getSerchnow() {
	return serchnow;
}


}
