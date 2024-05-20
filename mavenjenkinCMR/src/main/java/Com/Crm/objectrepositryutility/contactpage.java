package Com.Crm.objectrepositryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactpage {
	public  contactpage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
}
@FindBy(name="lastname")
private WebElement lastnamedit;

@FindBy(name="mobile")
private WebElement mobidit;


@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement savebtn;

@FindBy(id="mouseArea_Last Name")
private WebElement lastheader;


@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement headerinfo;


public WebElement getHeaderinfo() {
	return headerinfo;
}
@FindBy(id="jscal_field_support_start_date")
private WebElement supdate;


@FindBy(id="jscal_field_support_end_date")
private WebElement enddate;


@FindBy(id="mouseArea_Support Start Date")
private WebElement startdatever;


@FindBy(id="mouseArea_Support End Date")
private WebElement enddatever;

public WebElement getStartdatever() {
	return startdatever;
}


public WebElement getEnddatever() {
	return enddatever;
}


public WebElement getSupdate() {
	return supdate;
}


public WebElement getEnddate() {
	return enddate;
}
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement contactimg;


public WebElement getContactimg() {
	return contactimg;
}


public WebElement getlastheader() {
	return lastheader;
}


public WebElement getLastnamedit() {
	return lastnamedit;
}


public WebElement getMobidit() {
	return mobidit;
}


public WebElement getSavebtn() {
	return savebtn;
}





}
