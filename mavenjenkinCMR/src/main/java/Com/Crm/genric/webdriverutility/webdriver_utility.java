package Com.Crm.genric.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webdriver_utility {
	public void waitforpagetoload(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
public void waitforElement_present(WebDriver driver, WebElement ele)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(ele));
}
public void switchto_tabonurl(WebDriver driver,String partialurl)
{
	 Set<String> all_id = driver.getWindowHandles();
		Iterator<String> it = all_id.iterator();
	while (it.hasNext()) 
	{
		String windowid = it.next();
		
		driver.switchTo().window(windowid);
		String url = driver.getCurrentUrl();
		if (url.contains(partialurl)) 
		{
		break;	
		}
	}
}
	public void switchtotab(WebDriver driver, String partialTitle)
	{
		Set<String> all = driver.getWindowHandles();
		Iterator<String> it1 = all.iterator();
		while(it1.hasNext())
		{
			String window = it1.next();
			driver.switchTo().window(window);
			String url = driver.getTitle();
			if(url.contains(partialTitle))
			{
				break;
			}
		}
	}
	public void switchtoFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
		
	}
	public void switchtoFrame(WebDriver driver, String name)
	{
		driver.switchTo().frame(name);
	}
	public void switchtoFrame(WebDriver driver,WebElement ele)
	{
		driver.switchTo().frame(ele);
	}
	public void swtichtoalertandAccept(WebDriver driver)
	{
	driver.switchTo().alert().accept();
	}
public void switchtoAlertandDismiss(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
}
public void select(WebElement ele,String txt)
{
	Select sel = new Select(ele);
	sel.selectByVisibleText(txt);
}
public void select(WebElement ele,int index)
{
	Select sel = new Select(ele);
	sel.deselectByIndex(index);
}
public void mouseoveronElement(WebElement ele, WebDriver driver )
{
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();;
}
public void doubleclick(WebDriver driver, WebElement ele)
{
	Actions act = new Actions(driver);
	act.doubleClick(ele).perform();
}
}
