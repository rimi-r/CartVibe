package php.ecom.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtilityFile {
	
	public void implicitWaitTime(WebDriver driver, int n)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(n));
	}
	 public void selectDDOption(WebElement ele, String reqData)
	 {
		 Select se=new Select(ele);
	     se.selectByValue(reqData);
    }
	 
	 public void acceptAlertPopup(WebDriver driver)
	 {
		 driver.switchTo().alert().accept();
	 

	 }
	 public void dismissAlertPopup(WebDriver driver)
	 {
		 driver.switchTo().alert().dismiss();
	 }
	 public void mouseHover(WebDriver driver, WebElement ele)
	 {
		 Actions act=new Actions(driver);
		 act.moveToElement(ele).perform();
		 
	 }
	 public void scrollDown(WebDriver driver, int n) throws InterruptedException
	 {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,"+n+")");
		 Thread.sleep(3000);
	 }
	 public void switchTabsBasedOnTitle(WebDriver driver, String partialTitle)
	 {
		 Set<String> lw=driver.getWindowHandles();
		 Iterator<String> iTabs=lw.iterator();
		 while(iTabs.hasNext())
		 {
			 String title=iTabs.next();
			 driver.switchTo().window(title);
			 String tabTitle=driver.getCurrentUrl();
			 if(tabTitle.contains(partialTitle))
			 {
				 break;
			 }
		 }
	 }
	 public void selectOptionFromDD(WebElement ele, String prefer)
	 {
		 Select se=new Select(ele);
		 List<WebElement> options=se.getOptions();
		 for(WebElement opt:options)
		 {
			 String optValue=opt.getText();
			 if(optValue.contains(prefer))
			 {
				 opt.click();
			 }
		 }
	 }

	

}
