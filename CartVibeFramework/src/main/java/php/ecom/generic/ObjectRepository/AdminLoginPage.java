package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class AdminLoginPage {

	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public AdminLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="inputEmail")
	private WebElement adminEmailField;
	
	@FindBy(id="inputPassword")
	private WebElement adminPassField;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//span[contains(.,'Back to Portal')]")
	private WebElement backToPortalLink;
	
	@FindBy(xpath="//span[.='You have successfully logout']")
	private WebElement logoutMessage;
	
	public WebElement getBackToPortalLink() {
		return backToPortalLink;
	}
	
	public WebElement getAdminEmailField() {
		return adminEmailField;
	}

	public WebElement getAdminPassField() {
		return adminPassField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public void loginAsAdmin(String aName, String aPassword)
	{
		wbLib.implicitWaitTime(driver, 20);
		HomePage hLib=new HomePage(driver);
		hLib.getAdminLink().click();
		adminEmailField.sendKeys(aName);
		adminPassField.sendKeys(aPassword);
		loginButton.click();
	}
	
	public void validateLogoutMessage()
	{
		String lMessage=logoutMessage.getText();
		boolean flag=lMessage.contains("You have successfully logout");
		Assert.assertEquals(flag, true);
	}

	public WebElement getLogoutMessage() {
		return logoutMessage;
	}


}
