package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class UserLoginPage {
	
	WebDriverUtilityFile wLib=new WebDriverUtilityFile();

	WebDriver driver=null;
	public UserLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[.='Login']")
	private WebElement loginLink;
	
	@FindBy(id="fullname")
	private WebElement fullNameField;
	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id="contactno")
	private WebElement contactField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
	@FindBy(id="confirmpassword")
	private WebElement confirmPassField;
	
	@FindBy(id="submit")
	private WebElement signUpButton;
	
	@FindBy(id="exampleInputEmail1")
	private WebElement emailAccountField;
	
	@FindBy(id="exampleInputPassword1")
	private WebElement passwordAccountField;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//li[.='Authentication']")
	private WebElement authenticationLink;
	
	public WebElement getLoginLink() {
		return loginLink;
	}
	
	

	public WebElement getFullNameField() {
		return fullNameField;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getContactField() {
		return contactField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getConfirmPassField() {
		return confirmPassField;
	}

	public WebElement getSignUpButton() {
		return signUpButton;
	}

	public WebElement getEmailAccountField() {
		return emailAccountField;
	}

	public WebElement getPasswordAccountField() {
		return passwordAccountField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	public WebElement getAuthenticationLink() {
		return authenticationLink;
	}

	
	public void loginAction(String userEmail, String userPassword) throws InterruptedException
	{
		wLib.implicitWaitTime(driver, 15);
		emailAccountField.sendKeys(userEmail);
		passwordAccountField.sendKeys(userPassword);
		wLib.scrollDown(driver,200);
//		 JavascriptExecutor js=(JavascriptExecutor) driver;
//		 js.executeScript("window.scrollBy(0,200)");
		 Thread.sleep(3000);
		wLib.mouseHover(driver, loginButton);
		loginButton.click();
	}
	
	public void createAccount(String fullName, String emailAdd, String contactNum, String userPassword, String confirmPassword ) {
	
		wLib.implicitWaitTime(driver, 15);
		fullNameField.sendKeys(fullName);
		emailField.sendKeys(emailAdd);
		contactField.sendKeys(contactNum);
		passwordField.sendKeys(userPassword);
		confirmPassField.sendKeys(confirmPassword);
		signUpButton.click();
		wLib.acceptAlertPopup(driver);
		
		String assertPage=authenticationLink.getText();
		boolean flag=assertPage.contains("Authentication");
		
		Assert.assertEquals(flag, true);
		
}





}
