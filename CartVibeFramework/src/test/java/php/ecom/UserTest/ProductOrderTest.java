package php.ecom.UserTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import php.ecom.generic.ObjectRepository.CartPage;
import php.ecom.generic.ObjectRepository.HomePage;
import php.ecom.generic.ObjectRepository.OrderPage;
import php.ecom.generic.ObjectRepository.PaymentMethodPage;
import php.ecom.generic.ObjectRepository.ProductDetailsPage;
import php.ecom.generic.ObjectRepository.ProductPage;
import php.ecom.generic.ObjectRepository.UserLoginPage;
import php.ecom.generic.baseutility.BaseClassFile;

public class ProductOrderTest extends BaseClassFile {
	
	@Test(groups={"regressionTest","smokeTesting"})
	public void placeAnOrderForProductByCod() throws EncryptedDocumentException, IOException, InterruptedException
	{
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		String name=ex.getDataFromExcel("Sheet2", 1, 2);
		String pwd=ex.getDataFromExcel("Sheet2", 1, 3);
		uLib.loginAction(name, pwd);
		
		String prodName=ex.getDataFromExcel("Sheet2", 1, 4);
		HomePage hpLib=new HomePage(driver);
		wbLib.implicitWaitTime(driver, 20);
		Thread.sleep(3000);
		hpLib.searchForProduct(prodName);
		
		ProductPage pgLib=new ProductPage(driver);
		pgLib.addProductToCart();

		CartPage cLib=new CartPage(driver);
		cLib.enterBillingAddressDetails();
		cLib.enterShippingAddress();
		
		
		
		PaymentMethodPage pLib=new PaymentMethodPage(driver);
		pLib.payViaCod();
		
		OrderPage opLib=new OrderPage(driver);
		opLib.validateProduct(prodName);

		hpLib.logoutAction();
		
	}
	
	@Test(groups="regressionTest")
	public void addNewProductFromProductDetailsPageTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		String name=ex.getDataFromExcel("Sheet2", 1, 2);
		String pwd=ex.getDataFromExcel("Sheet2", 1, 3);
		uLib.loginAction(name, pwd);
		
		String prodName=ex.getDataFromExcel("Sheet2", 1, 4);
		HomePage hpLib=new HomePage(driver);
		wbLib.implicitWaitTime(driver, 20);
		Thread.sleep(3000);
		hpLib.searchForProduct(prodName);
		
		ProductPage pLib=new ProductPage(driver);
		wbLib.scrollDown(driver, 800);
		pLib.getProductOption().click();
		ProductDetailsPage pdLib=new ProductDetailsPage(driver);
		pdLib.clickOnNewProduct();
		Thread.sleep(3000);
		
		CartPage cLib=new CartPage(driver);
		cLib.validateProductAddedToCartViaAnotherProduct();

		hpLib.logoutAction();
	}
	
	@Test(groups="regressionTest")
	public void placeAnOrderForProductByInternetBanking() throws EncryptedDocumentException, IOException, InterruptedException
	{
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		String name=ex.getDataFromExcel("Sheet2", 1, 2);
		String pwd=ex.getDataFromExcel("Sheet2", 1, 3);
		uLib.loginAction(name, pwd);
		
		String prodName=ex.getDataFromExcel("Sheet2", 1, 4);
		HomePage hpLib=new HomePage(driver);
		wbLib.implicitWaitTime(driver, 20);
		Thread.sleep(3000);
		hpLib.searchForProduct(prodName);
		
		ProductPage pgLib=new ProductPage(driver);
		pgLib.addProductToCart();

		CartPage cLib=new CartPage(driver);
		wbLib.scrollDown(driver, 300);
		cLib.getProceedToCheckoutButton().click();
		
		
		PaymentMethodPage pLib=new PaymentMethodPage(driver);
		pLib.payViaIB();
		
		OrderPage opLib=new OrderPage(driver);
		opLib.validateProduct(prodName);

		hpLib.logoutAction();
		
	}

}
