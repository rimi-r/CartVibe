package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class AdminOrderStatusPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public AdminOrderStatusPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='status']")
	private WebElement statusDropDown;
	
	@FindBy(xpath="//textarea[@name='remark']")
	private WebElement remarkField;
	
	@FindBy(xpath="//input[@value='update']")
	private WebElement updateButton;
	
	@FindBy(xpath="//td[.='order Id:']/parent::tr/td[@class='fontkink']")
	private WebElement orderId;
	
	public WebElement getOrderId() {
		return orderId;
	}
	
	public WebElement getStatusDropDown() {
		return statusDropDown;
	}

	public WebElement getRemarkField() {
		return remarkField;
	}

	public WebElement getUpdateButton() {
		return updateButton;
	}
	
	public String changeTheOrderStatus() throws InterruptedException
	{
		wbLib.implicitWaitTime(driver, 20);
		wbLib.switchTabsBasedOnTitle(driver, "updateorder.php");
		wbLib.selectOptionFromDD(statusDropDown, "Delivered");
		remarkField.sendKeys("done");
		updateButton.click();
		Thread.sleep(3000);
		wbLib.acceptAlertPopup(driver);
		Thread.sleep(3000);
		String order=obtainOrderId();
		System.out.println(order);
		wbLib.switchTabsBasedOnTitle(driver,"pending-orders.php");
		return order;
		//driver.close();
		}
	
	public String changeTheTodayOrderStatus() throws InterruptedException
	{
		wbLib.implicitWaitTime(driver, 20);
		wbLib.switchTabsBasedOnTitle(driver, "updateorder.php");
		try {
		wbLib.selectOptionFromDD(statusDropDown, "Delivered");
		remarkField.sendKeys("done");
		updateButton.click();
		Thread.sleep(3000);
		wbLib.acceptAlertPopup(driver);
		Thread.sleep(3000);
		}
		catch(Exception e) {}
		String order=obtainOrderId();
		System.out.println(order);
		wbLib.switchTabsBasedOnTitle(driver,"todays-orders.php");
		return order;
		//driver.close();
		}

    public String obtainOrderId()
    {
    	String delivered=orderId.getText();
    	return delivered;
    	
    }
	

}
