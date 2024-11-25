package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class ProductDetailsPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile();
	WebDriver driver=null;
	public ProductDetailsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='product-info text-left']//a[.='Micromax Canvas Mega 4G']")
	private WebElement prodImage;
	
	@FindBy(xpath="//a[.='Micromax Canvas Mega 4G']/../../../div[@class='cart clearfix animate-effect']//li")
	private WebElement prodToCart;
	
	
	public WebElement getProdImage() {
		return prodImage;
	}

	public WebElement getProdToCart() {
		return prodToCart;
	}
	
	public void clickOnNewProduct() throws InterruptedException
	{
		wbLib.implicitWaitTime(driver, 10);
		wbLib.scrollDown(driver, 1500);
		wbLib.mouseHover(driver, prodImage);
		prodToCart.click();
		wbLib.acceptAlertPopup(driver);
	}
	

}
