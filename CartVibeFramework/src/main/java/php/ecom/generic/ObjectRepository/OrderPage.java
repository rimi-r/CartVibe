package php.ecom.generic.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;

public class OrderPage {
	
	WebDriverUtilityFile wbLib=new WebDriverUtilityFile(); 
	ExcelUtilityFile ex=new ExcelUtilityFile();
	
	WebDriver driver=null;
	public OrderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[.='Shopping Cart']")
	private WebElement headerField;
	
	@FindBy(xpath="//a[contains(text(),'OPPO A57')]")
	private WebElement productName;
	
	@FindBy(xpath="//td[.='14990']/following-sibling::td/a")
	private WebElement trackButton;
	
	@FindBy(xpath="//td[.='Delivered']")
	private WebElement orderStatus;
	
	public WebElement getHeaderField() {
		return headerField;
	}

	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getTrackButton() {
		return trackButton;
	}


	public WebElement getOrderStatus() {
		return orderStatus;
	}
	
	public void validateProduct(String prodName) {
		
		String prodPage=headerField.getText();
		System.out.println(prodPage);
		String addedProd=productName.getText();
		
		System.out.println(prodName);
		boolean flag1=prodPage.contains("Shopping Cart");
		boolean flag2=addedProd.contains(prodName);
		Assert.assertEquals(flag1, true);
		Assert.assertEquals(flag2, true);
	}
	public void getProductDetailsAndVerify(WebDriver driver,String id)
	{
		trackButton.click();
		wbLib.switchTabsBasedOnTitle(driver, "track-order.php");
		WebElement ele=driver.findElement(By.xpath("//td[.='"+id+"']"));
		String idOrder=ele.getText();
	
		System.out.println(idOrder);
		String ordStatus=orderStatus.getText();
		
		
		System.out.println(ordStatus);
		boolean flag1=ordStatus.contains("Delivered");
		boolean flag2=idOrder.contains(id);
		Assert.assertEquals(flag1, true);
		Assert.assertEquals(flag2, true);
		
	}



	

}


