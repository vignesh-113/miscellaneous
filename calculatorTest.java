package Formloop;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.base.Predicate;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class calculatorTest { 
	ExtentReports report;
	ExtentTest logger; 
	public WebDriver driver;
	
	@BeforeTest
	public void Beforetest() throws Exception
	{		
	System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
	driver = new ChromeDriver();	
	report=new ExtentReports("D:\\Report\\testScreenShotOnFailreport.html");
	 				
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//Launch google 
	driver.get("http://www.google.co.in");
		
	}
	
	@Test(enabled = true,priority = 0)
	//Tests google calculator 
	public void googleCalculator() throws IOException
	{ 
//		System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
//		driver = new ChromeDriver();
		
//		report=new ExtentReports("D:\\Report\\testScreenShotOnFailreport.html");
//		
//		logger=report.startTest("Verify Page Title");
//		Reporter.log("Browser started");
		
		logger=report.startTest("Verify Page Title");
		
		logger.log(LogStatus.INFO, "Browser started");
		
		logger.log(LogStatus.INFO, "Navigated to www.google.co.in");
		
		try
	{ //Set implicit wait of 10 seconds 
				
	    String title=driver.getTitle();

	    logger.log(LogStatus.INFO, "Get the current title");
	    Reporter.log("Get the current title");
	    
	    Assert.assertTrue(title.contains("Google"));

	    logger.log(LogStatus.PASS, "Title verified");
	    Reporter.log("Title verified");
	     
		Thread.sleep(500);
		//Write 2+2 in google textbox 
		WebElement googleTextBox = driver.findElement(By.id("lst-ib"));
		googleTextBox.clear();
		googleTextBox.sendKeys("2+2");
		//Click on searchButton 
		WebElement searchButton = driver.findElement(By.className("lsb"));
		searchButton.click(); 
		Thread.sleep(5000);
		logger.log(LogStatus.INFO, "Application is calculating");
		Reporter.log("Application is calculating");
		
		//Get result from calculator
		WebElement calculatorTextBox = driver.findElement(By.className("cwtlotc"));
		String result = calculatorTextBox.getText(); 
		System.out.println(calculatorTextBox.getText());
		//Intentionaly checking for wrong calculation of 2+2=5 in order to take screenshot for faling test 
		Assert.assertEquals(result, "4"); 
		report.endTest(logger);
		} 
	catch(Exception e)
	{
	Assert.fail(); 
	//To fail test in case of any element identification failure 
	} } 
	
	@Test(enabled = true,priority = 1)
	public void test2() throws InterruptedException
	{
		logger=report.startTest("Test2");
		WebElement googleTextBox = driver.findElement(By.id("lst-ib"));
		googleTextBox.clear();		
		googleTextBox.sendKeys("3+3");
		logger.log(LogStatus.INFO, "Application is calculating");
		Reporter.log("Application is calculating");
		WebElement searchButton = driver.findElement(By.className("lsb"));
		searchButton.click(); 
		Thread.sleep(5000);		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("cwtlotc")));
		System.out.println(element.getText());
		
		WebElement calculatorTextBox = driver.findElement(By.className("cwtlotc"));
		String result = calculatorTextBox.getText(); 
		
		//Intentionaly checking for wrong calculation of 2+2=5 in order to take screenshot for faling test 
		Assert.assertEquals(result, "6"); 
		
	}
	
	@AfterMethod 
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException, InterruptedException 
	{ Exit:
		if (testResult.getStatus() == ITestResult.FAILURE) 
		{ 
			System.out.println("result"+"---"+testResult.getStatus());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File("D:\\testScreenShotOnFail"+dateFormat.format(new Date())+".jpg"));
		    String image= logger.addScreenCapture("D:\\testScreenShotOnFail"+dateFormat.format(new Date())+".jpg");
		    
			logger.log(LogStatus.FAIL, "Title verification", image);
			
			break Exit;
		} 
		else if (testResult.getStatus() == ITestResult.SUCCESS)
		{	
			System.out.println("result"+"---"+testResult.getStatus());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
		    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		    FileUtils.copyFile(scrFile, new File("D:\\testScreenShotOnPass"+dateFormat.format(new Date())+".jpg"));
		    String image= logger.addScreenCapture("D:\\testScreenShotOnPass"+dateFormat.format(new Date())+".jpg");
		    logger.log(LogStatus.PASS, "Title verification", image);
		    
		   break Exit;
		}
		//driver.close();
//		Reporter.log("Browser closed");
//		
//		report.endTest(logger);
//		report.flush();
		 
		//driver.get("D:\\Report\\testScreenShotOnFailreport.html");
	}
	
@AfterSuite	
	public void afterTest()
		{
			//driver.close();
			Reporter.log("Browser closed");
			
			report.endTest(logger);
			report.flush();
			 
			driver.get("D:\\Report\\testScreenShotOnFailreport.html");
		}
	
	
	}

