package php.ecom.generic.ObjectRepository;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class AdminDashboardPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public AdminDashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//a[@class='collapsed']")
	private WebElement orderManagementLink;
	
	@FindBy(xpath="//a[contains(.,'Pending Orders')]")
	private WebElement pendingOrdersTab;
	
	@FindBy(xpath="//label[contains(.,'Search: ')]")
	private WebElement searchField;
	
	@FindBy(xpath="//i[@class='icon-edit']")
	private WebElement editButton;
	
	@FindBy(xpath="//i[@class='menu-icon icon-signout']/parent::a[contains(.,'Logout')]")
	private WebElement logoutLink;
	
	@FindBy(xpath="//a[@href='todays-orders.php']")
	private WebElement todaysTab;
	
	public WebElement getLogoutLink() {
		return logoutLink;
	}

	
	public WebElement getOrderManagementLink() {
		return orderManagementLink;
	}

	public WebElement getPendingOrdersTab() {
		return pendingOrdersTab;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getEditButton() {
		return editButton;
	}
	
	public WebElement getTodaysTab() {
		return todaysTab;
	}

	
	public void updateOrder(String cost) throws AWTException
	{
		wbLib.implicitWaitTime(driver, 20);
		orderManagementLink.click();
		pendingOrdersTab.click();
		searchField.sendKeys(cost);
		editButton.click();
		
	}
	
	public void updateTodayOrder(String cost) throws AWTException
	{
		wbLib.implicitWaitTime(driver, 20);
		orderManagementLink.click();
		todaysTab.click();
		searchField.sendKeys(cost);
		editButton.click();
		
	}




}
