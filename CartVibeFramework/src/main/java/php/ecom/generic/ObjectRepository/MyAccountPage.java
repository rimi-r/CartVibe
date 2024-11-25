package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class MyAccountPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public MyAccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Shipping / Billing Address']")
	private WebElement addressLink;
	
	public WebElement getAddressLink() {
		return addressLink;
	}
	
	
	

}
