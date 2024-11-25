package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class ShipBillAddressPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public ShipBillAddressPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="billingaddress")
	private WebElement billAdress;
	
	@FindBy(id="bilingstate")
	private WebElement billState;
	
	@FindBy(id="billingcity")
	private WebElement billCity;
	
	@FindBy(name="billingpincode")
	private WebElement billPin;
	
	@FindBy(name="update")
	private WebElement updateButton;
	
	public WebElement getBillAdress() {
		return billAdress;
	}

	public WebElement getBillState() {
		return billState;
	}

	public WebElement getBillCity() {
		return billCity;
	}

	public WebElement getBillPin() {
		return billPin;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	public void updateBillingAddress(String address, String state, String city, String pin) throws InterruptedException
	{
		wbLib.implicitWaitTime(driver, 15);
		HomePage hLib=new HomePage(driver);
		hLib.getMyAccountLink().click();
		MyAccountPage mLib=new MyAccountPage(driver);
		mLib.getAddressLink().click();
		billAdress.clear();
		billAdress.sendKeys(address);
		billState.clear();
		billState.sendKeys(state);
		billCity.clear();
		billCity.sendKeys(city);
		billPin.clear();
		billPin.sendKeys(pin);
		wbLib.scrollDown(driver, 600);
		updateButton.click();
		wbLib.acceptAlertPopup(driver);
		Thread.sleep(2000);
		hLib.getHomeTab().click();
	}


}
