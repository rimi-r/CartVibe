package php.ecom.generic.ObjectRepository;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class CartPage {
	
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="billingaddress")
	private WebElement billAdressField;
	
	@FindBy(id="bilingstate")
	private WebElement billStateField;
	
	@FindBy(id="billingcity")
	private WebElement billCityField;
	
	@FindBy(id="billingpincode")
	private WebElement billPinCode;
	
	@FindBy(name="update")
	private WebElement billUpdateButton;
	
	@FindBy(name="shippingaddress")
	private WebElement shippAddressField;
	
	@FindBy(name="shippingstate")
	private WebElement shipStateField;
	
	@FindBy(id="shippingcity")
	private WebElement shipCityField;
	
	@FindBy(id="shippingpincode")
	private WebElement shipPinField;
	
	@FindBy(name="shipupdate")
	private WebElement shipUpdateButton;
	
	@FindBy(xpath="//div/button[.='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckoutButton;
	
	@FindBy(xpath="//h4[@class='cart-product-description']/a[.='Micromax Canvas Mega 4G']")
	private WebElement productAddedName;
	
	@FindBy(xpath="//li[.='Shopping Cart']")
	private WebElement pageHeader;
	
	public WebElement getProductAddedName() {
		return productAddedName;
	}
	

	public WebElement getPageHeader() {
		return pageHeader;
	}
	
	public WebElement getBillAdressField() {
		return billAdressField;
	}

	public WebElement getBillStateField() {
		return billStateField;
	}

	public WebElement getBillCityField() {
		return billCityField;
	}

	public WebElement getBillPinCode() {
		return billPinCode;
	}

	public WebElement getBillUpdateButton() {
		return billUpdateButton;
	}

	public WebElement getShippAddressField() {
		return shippAddressField;
	}

	public WebElement getShipStateField() {
		return shipStateField;
	}

	public WebElement getShipCityField() {
		return shipCityField;
	}

	public WebElement getShipPinField() {
		return shipPinField;
	}

	public WebElement getShipUpdateButton() {
		return shipUpdateButton;
	}

	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}
	
	public void enterBillingAddressDetails() throws EncryptedDocumentException, IOException, InterruptedException
	{
		wbLib.implicitWaitTime(driver,20);
		
		String billAddress=ex.getDataFromExcel("Sheet2", 4, 0);
		String billState=ex.getDataFromExcel("Sheet2", 4, 1);
		String billCity=ex.getDataFromExcel("Sheet2", 4, 2);
		String billPin=ex.getDataFromExcel("Sheet2", 4, 3);
		
		
		billAdressField.clear();
		billAdressField.sendKeys(billAddress);
		billStateField.clear();
		billStateField.sendKeys(billState);
		billCityField.clear();
		billCityField.sendKeys(billCity);
		billPinCode.clear();
		billPinCode.sendKeys(billPin);
		wbLib.scrollDown(driver,800);
		billUpdateButton.click();
		try {
		wbLib.acceptAlertPopup(driver);
		}
		catch(Exception e)
		{
			
		}
		
	}
	
	public void enterShippingAddress() throws EncryptedDocumentException, IOException, InterruptedException
	{
		wbLib.implicitWaitTime(driver,20);
		String shipAddress=ex.getDataFromExcel("Sheet2", 4, 0);
		String shipState=ex.getDataFromExcel("Sheet2", 4, 1);
		String shipCity=ex.getDataFromExcel("Sheet2", 4, 2);
		String shipPin=ex.getDataFromExcel("Sheet2", 4, 3);
		
		shippAddressField.clear();
		shippAddressField.sendKeys(shipAddress);
		shipStateField.clear();
		shipStateField.sendKeys(shipState);
		shipCityField.clear();
		shipCityField.sendKeys(shipCity);
		shipPinField.clear();
		shipPinField.sendKeys(shipPin);
		wbLib.scrollDown(driver,800);
		shipUpdateButton.click();
		try {
		wbLib.acceptAlertPopup(driver);
		}
		catch(Exception ex)
		{
			
		}
		
		wbLib.mouseHover(driver, proceedToCheckoutButton);
		Thread.sleep(3000);
		wbLib.scrollDown(driver,800);
		getProceedToCheckoutButton().click();
	}

	public void validateProductAddedToCartViaAnotherProduct()
	{
		String prodName=productAddedName.getText();
		String header=pageHeader.getText();
		
		System.out.println("prod name="+prodName);
		System.out.println("header="+header);
		
		boolean flag2=header.contains("Shopping Cart");
		boolean flag1=prodName.contains("MICROMAX");
		
		
		Assert.assertEquals(flag1, true);
		Assert.assertEquals(flag2, true);
		
	}




	

}
