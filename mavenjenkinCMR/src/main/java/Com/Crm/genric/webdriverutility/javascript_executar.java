package Com.Crm.genric.webdriverutility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class javascript_executar {
	
	public void scrollup(WebDriver driver)
	{
		JavascriptExecutor jss = (JavascriptExecutor)driver;
		jss.executeScript("window.scrollBy(0,500)");
		
	}

}
