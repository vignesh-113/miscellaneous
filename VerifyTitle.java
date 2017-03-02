package start.com;


import java.io.File;
import java.io.IOException;

import org.apache.bcel.classfile.Utility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.opera.core.systems.scope.services.Exec;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

	public class VerifyTitle 
	{

	ExtentReports report;
	ExtentTest logger; 
	public WebDriver driver;

	@Test
	public void verifyBlogTitle()
	{
	report=new ExtentReports("C:\\Report\\LearnAutomation.html");

	logger=report.startTest("VerifyBlogTitle");

	System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
	driver = new ChromeDriver();

	driver.manage().window().maximize();

	logger.log(LogStatus.INFO, "Browser started ");

	driver.get("http://www.learn-automation.com");

	logger.log(LogStatus.INFO, "Application is up and running");

	String title=driver.getTitle();

	Assert.assertTrue(title.contains("Selenium")); 

	logger.log(LogStatus.PASS, "Title verified");
	}


	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
	    FileUtils.copyFile(scrFile, new File("D:\\testScreenShotOnPass.jpg"));
	    String image= logger.addScreenCapture("D:\\testScreenShotOnPass.jpg");
	    logger.log(LogStatus.FAIL, "Title verification", image);
	}

	report.endTest(logger);
	report.flush();

	driver.get("C:\\Report\\LearnAutomation.html");
	}

}

