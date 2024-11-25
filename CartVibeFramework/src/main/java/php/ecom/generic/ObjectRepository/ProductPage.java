package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class ProductPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile();
	WebDriver driver=null;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@class='add-cart-button btn-group']")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//a[.='OPPO A57']")
	private WebElement productOption;
	
	public WebElement getAddToCartButton() {
		return addToCartButton;
	}
	
	public WebElement getProductOption() {
		return productOption;
	}
	
	public void addProductToCart() throws InterruptedException
	{
		wbLib.scrollDown(driver,800);
		//wbLib.mouseHover(driver, addToCartButton);
		
		Actions act=new Actions(driver);
		 act.moveToElement(addToCartButton).click().perform();
		
		//getAddToCartButton().click();
		Thread.sleep(3000);
		try {
		wbLib.acceptAlertPopup(driver);
		}
		catch(Exception e)
		{
			
		}
	}


	
}
