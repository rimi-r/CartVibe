package php.ecom.generic.baseutility;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import php.ecom.generic.ObjectRepository.HomePage;
import php.ecom.generic.fileutitlity.ExcelUtilityFile;
import php.ecom.generic.fileutitlity.JsonUtility;
import php.ecom.generic.webdriverutility.UtilityClassObject;
import php.ecom.generic.webdriverutility.WebDriverUtilityFile;



public class BaseClassFile {
	
	public ExcelUtilityFile ex=new ExcelUtilityFile();
	public JsonUtility jv=new JsonUtility();
	public WebDriverUtilityFile wbLib=new WebDriverUtilityFile();
	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	
//	@BeforeSuite(alwaysRun=true)
//	public void configBS() throws SQLException
//	{
//		System.out.println("BeforeSuite");
//	}
	

	@BeforeClass(alwaysRun=true)
	public void configCS() throws IOException, ParseException
	{
		System.out.println("Before class==> launch the browser");
		String browser=jv.getTheDataFromJsonFile("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void configBM() throws IOException, ParseException
	{
		System.out.println("Before Method ==> login");
		String url=jv.getTheDataFromJsonFile("url");
		driver.get(url);
		driver.manage().window().maximize();

	}
	
	@AfterMethod(alwaysRun=true)
	public void configAM() throws InterruptedException
	{
		System.out.println("After Method==> logout");
		
		
	}
	
	@AfterClass(alwaysRun=true)
	public void configAC()
	{
		System.out.println("After Class==> close the application");
		driver.quit();
	}
	
//	@AfterSuite(alwaysRun=true)
//	public void configAS() throws SQLException
//	{
//		System.out.println("After Suite");
//	}
}
