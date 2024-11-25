package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class TrackOrderPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public TrackOrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="exampleOrderId1")
	private WebElement orderIdField;
	
	@FindBy(id="exampleBillingEmail1")
	private WebElement registerEmail;
	
	@FindBy(xpath="//button[.='Track']")
	private WebElement trackButton;
	
	public WebElement getOrderIdField() {
		return orderIdField;
	}

	public WebElement getRegisterEmail() {
		return registerEmail;
	}

	public WebElement getTrackButton() {
		return trackButton;
	}
	
	public void verifyOrderId(String orderId, String emailId) throws InterruptedException
	{
		wbLib.implicitWaitTime(driver, 15);
        HomePage hLib=new HomePage(driver);
        hLib.selectTrackOrder();
		orderIdField.sendKeys(orderId);
		registerEmail.sendKeys(emailId);
		wbLib.scrollDown(driver, 600);
		trackButton.click();
	}

}
