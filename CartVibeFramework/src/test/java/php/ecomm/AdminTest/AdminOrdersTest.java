package php.ecomm.AdminTest;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import php.ecom.generic.ObjectRepository.AdminDashboardPage;
import php.ecom.generic.ObjectRepository.AdminLoginPage;
import php.ecom.generic.ObjectRepository.AdminOrderStatusPage;
import php.ecom.generic.ObjectRepository.HomePage;
import php.ecom.generic.ObjectRepository.OrderPage;
import php.ecom.generic.ObjectRepository.TrackOrderPage;
import php.ecom.generic.ObjectRepository.UserLoginPage;
import php.ecom.generic.baseutility.BaseClassFile;

//@Listeners(php.ecom.generic.listenerutility.ListenerImpClass.class)
public class AdminOrdersTest extends BaseClassFile {
	
	@Test(groups="regressionTest")
	public void changeOrderStatus() throws EncryptedDocumentException, IOException, AWTException, InterruptedException
	{
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		AdminLoginPage adLib=new AdminLoginPage(driver);
		String userName=ex.getDataFromExcel("Sheet3", 1,2);
		String password=ex.getDataFromExcel("Sheet3", 1,3);
		String prodCost=ex.getDataFromExcel("Sheet3", 1,4);
		adLib.loginAsAdmin(userName, password);
		
		AdminDashboardPage apLib=new AdminDashboardPage(driver);
		apLib.updateOrder(prodCost);
		
		AdminOrderStatusPage asLib=new AdminOrderStatusPage(driver);
		String orderName=asLib.changeTheOrderStatus();
		Thread.sleep(3000);
		apLib.getLogoutLink().click();
		adLib.getBackToPortalLink().click();
		
		uLib.getLoginLink().click();
		
		String name=ex.getDataFromExcel("Sheet2", 1, 2);
		String pwd=ex.getDataFromExcel("Sheet2", 1, 3);
		uLib.loginAction(name, pwd);
		HomePage hLib=new HomePage(driver);
		
		TrackOrderPage toLib=new TrackOrderPage(driver);
		toLib.verifyOrderId(orderName, name);
		
		OrderPage odLib=new OrderPage(driver);
		odLib.getProductDetailsAndVerify(driver,orderName);
		
		
		
	}

	@Test(groups="regressionTest")
	public void manageTodayPendingOrder() throws EncryptedDocumentException, IOException, AWTException, InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		AdminLoginPage adLib=new AdminLoginPage(driver);
		String userName=ex.getDataFromExcel("Sheet3", 1,2);
		String password=ex.getDataFromExcel("Sheet3", 1,3);
		String prodCost=ex.getDataFromExcel("Sheet3", 1,4);
		adLib.loginAsAdmin(userName, password);
		
		AdminDashboardPage apLib=new AdminDashboardPage(driver);
		apLib.updateTodayOrder(prodCost);
		Thread.sleep(3000);
		
		AdminOrderStatusPage asLib=new AdminOrderStatusPage(driver);
		
		String orderName=asLib.changeTheTodayOrderStatus();
try {
		apLib.getLogoutLink().click();
}
catch(Exception e) {
		Thread.sleep(3000);
}
		
		adLib.validateLogoutMessage();
		
	}
}
