package php.ecom.generic.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import php.ecom.generic.baseutility.BaseClassFile;
import php.ecom.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	
	public static ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("-ISuite started");
		String date=new Date().toString().replaceAll(":", "-");
		spark=new ExtentSparkReporter("./Advanced_report/report"+date+".html");
		spark.config().setDocumentTitle("CartVobeReport");
		spark.config().setReportName("CartVibe");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("ISuite stopped");
		report.flush();
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("ITestResult started");
		String mName=result.getMethod().getMethodName();
		test=report.createTest(mName);
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, mName+"--started--");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String mName=result.getMethod().getMethodName();
		System.out.println("OnTestSuccess");
		test.log(Status.PASS,mName);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String mName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) BaseClassFile.sdriver;
		String photo=ts.getScreenshotAs(OutputType.BASE64);
		String date=new Date().toString().replaceAll(":","-");
		test.addScreenCaptureFromBase64String(photo,mName+" "+date);
		test.log(Status.FAIL, mName+"--Failed--");
		test.log(Status.FAIL, result.getThrowable());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("onTestSkipped");
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("ITestContext Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("ITestContext Finish");
		
	}

}
