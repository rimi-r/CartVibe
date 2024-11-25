package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class HomePage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	WebDriver driver=null;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	


	@FindBy(xpath="//a[.='Logout']")
	private WebElement logoutLink;
	
	@FindBy(name="product")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@class='search-button']")
	private WebElement searchButton;
	
	@FindBy(xpath="//a[.='Admin Login']")
	private WebElement adminLink;
	
	@FindBy(xpath="//span[.='Track Order']")
	private WebElement trackOrderButton;
	
	@FindBy(xpath="//a[.='My Account']")
	private WebElement myAccountLink;
	
	@FindBy(xpath="//li[@class='active dropdown yamm-fw']/a[.='Home']")
	private WebElement homeTab;
	
	public WebElement getLogoutLink()
	{
		return logoutLink;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}
	
	public WebElement getTrackOrderButton() {
		return trackOrderButton;
	}
	
	public WebElement getMyAccountLink() {
		return myAccountLink;
	}
	public WebElement getHomeTab() {
		return homeTab;
	}
	
	public void searchForProduct(String prodName) throws InterruptedException
	{
		wbLib.implicitWaitTime(driver, 40);
		searchField.sendKeys(prodName);
		wbLib.mouseHover(driver, searchButton);
		Thread.sleep(2000);
		searchButton.click();
	}
	public void selectTrackOrder()
	{
		wbLib.implicitWaitTime(driver, 15);
		wbLib.mouseHover(driver, trackOrderButton);
		trackOrderButton.click();
	}
	public void logoutAction()
	{
		wbLib.implicitWaitTime(driver, 15);
		logoutLink.click();
	}





	




}
