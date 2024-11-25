package php.ecom.UserTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import php.ecom.generic.ObjectRepository.CartPage;
import php.ecom.generic.ObjectRepository.HomePage;
import php.ecom.generic.ObjectRepository.PaymentMethodPage;
import php.ecom.generic.ObjectRepository.ProductPage;
import php.ecom.generic.ObjectRepository.ShipBillAddressPage;
import php.ecom.generic.ObjectRepository.UserLoginPage;
import php.ecom.generic.baseutility.BaseClassFile;
import php.ecom.generic.webdriverutility.UtilityClassObject;

public class MyAccountTest extends BaseClassFile {
	
	@Test(groups="regressionTest")
	public void updateAddressInUserAccount() throws EncryptedDocumentException, IOException, InterruptedException
	{
		UtilityClassObject.getTest().log(Status.INFO, "--Execution started--");
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		String name=ex.getDataFromExcel("Sheet2", 1, 2);
		String pwd=ex.getDataFromExcel("Sheet2", 1, 3);
		uLib.loginAction(name, pwd);
		
		
		String address=ex.getDataFromExcel("Sheet4", 1, 2);
		String state=ex.getDataFromExcel("Sheet4", 1, 3);
		String city=ex.getDataFromExcel("Sheet4", 1, 4);
		String pin=ex.getDataFromExcel("Sheet4", 1, 5);
		ShipBillAddressPage sbLib=new ShipBillAddressPage(driver);
		sbLib.updateBillingAddress(address, state, city, pin);
		
		String prodName=ex.getDataFromExcel("Sheet2", 1, 4);
		HomePage hpLib=new HomePage(driver);
		wbLib.implicitWaitTime(driver, 20);
		Thread.sleep(3000);
		hpLib.searchForProduct(prodName);
		
		ProductPage pgLib=new ProductPage(driver);
		pgLib.addProductToCart();
		
		CartPage cLib=new CartPage(driver);
		cLib.enterShippingAddress();
		
		PaymentMethodPage pLib=new PaymentMethodPage(driver);
		pLib.payViaCod();
	
		hpLib.logoutAction();
	}
	
	

}
