package php.ecom.UserTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import php.ecom.generic.ObjectRepository.HomePage;
import php.ecom.generic.ObjectRepository.UserLoginPage;
import php.ecom.generic.baseutility.BaseClassFile;

public class UserCreateAccountTest extends BaseClassFile{
	
	@Test(groups={"regressionTest","smokeTesting"})
	public void createUserAccountTest() throws EncryptedDocumentException, IOException
	{
		
		UserLoginPage uLib=new UserLoginPage(driver);
		wbLib.implicitWaitTime(driver,15);
		uLib.getLoginLink().click();
		
		String fullName=ex.getDataFromExcel("Sheet1", 1, 2);
		String emailAdd=ex.getDataFromExcel("Sheet1", 3,3 );
		String contactNo=ex.getDataFromExcel("Sheet1", 1, 4);
		String password=ex.getDataFromExcel("Sheet1", 1, 5);
		String conPassword=ex.getDataFromExcel("Sheet1", 1, 6);
		
		UserLoginPage usLib=new UserLoginPage(driver);
		try {
			usLib.createAccount(fullName, emailAdd, contactNo, password, conPassword);
		}
		catch(Exception e)
		{
			
		}
		
		
		HomePage hpLib=new HomePage(driver);

		hpLib.logoutAction();
//		wbLib.implicitWaitTime(driver, 15);
//		hpLib.getLogoutLink().click();
		
	}

}
