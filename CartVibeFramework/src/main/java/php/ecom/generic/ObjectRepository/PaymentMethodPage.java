package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class PaymentMethodPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public PaymentMethodPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@value='COD']")
	private WebElement codRadio;
	
	@FindBy(xpath="//input[@value='Internet Banking']")
	private WebElement ibRadio;
	
	@FindBy(name="submit")
	private WebElement submitButton;
	
	
	public WebElement getCodRadio() {
		return codRadio;
	}
	
	public WebElement getIbRadio() {
		return ibRadio;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}
	
	public void payViaCod()
	{
		wbLib.implicitWaitTime(driver, 20);
		codRadio.click();
		submitButton.click();
	}
	
	public void payViaIB()
	{
		wbLib.implicitWaitTime(driver, 20);
		ibRadio.click();
		submitButton.click();
	}



}
