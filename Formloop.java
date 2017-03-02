package Formloop;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Formloop.Exllib;

public class Formloop{	
	public static WebDriver driver;
	
	public void executeTest(String testName) throws Exception{
		String scenarioName=testName;
		System.out.println(scenarioName);
		Exllib ex = new Exllib();
		//driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
		int numTestSteps=ex.getRowCount(scenarioName);
		System.out.println(scenarioName+"="+numTestSteps);
		
	for(int testStep=1002;testStep<=11969;testStep++){		
		
		driver.findElement(By.cssSelector("input[type='button']")).click();
		//driver.findElement(By.id("btnAddServiceCenter")).click();		
		
		String sno = ex.getExcelValue(scenarioName, testStep, 0);
		String serviceoption = ex.getExcelValue(scenarioName, testStep, 1);
		String zipcode = ex.getExcelValue(scenarioName, testStep, 2);
		String address = ex.getExcelValue(scenarioName, testStep, 3);
		String city = ex.getExcelValue(scenarioName, testStep, 4);
		String state = ex.getExcelValue(scenarioName, testStep, 5);
				
		System.out.println(sno +"--"+ serviceoption +"--"+ zipcode +"--"+ address +"--"+ city+state);
		
		driver.findElement(By.id("txtserviceCenterName")).sendKeys(serviceoption);
		driver.findElement(By.id("txtAddress1")).sendKeys(address);
		driver.findElement(By.id("txtCity")).sendKeys(city);
		driver.findElement(By.id("txtState")).sendKeys(state);
		driver.findElement(By.id("txtZip")).sendKeys(zipcode);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(500);
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		//WebElement element =wait.until(ExpectedConditions.elementToBeClickable(By.id("")));
	}
	
	}
	@BeforeTest
	public void Beforetest() throws Exception
	{		
	   //DesiredCapabilities DesireCaps = new DesiredCapabilities();
       //DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "D:/Common drivers/phantomjs-2.0.0-windows/bin/phantomjs.exe");
       //WebDriver driver=new PhantomJSDriver(DesireCaps);
        //WebDriver driver = new HtmlUnitDriver();	
	System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
	driver = new ChromeDriver();	
	driver.get("http://mtest.sumtwo.in/amcf/admin");
	driver.manage().window().maximize();		
	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
	driver.findElement(By.id("txtEmailId")).sendKeys("admin@sumtwo.com");
	driver.findElement(By.id("txtPassword")).sendKeys("welcome");
	driver.findElement(By.id("btnLogin")).click();
	driver.get("http://mtest.sumtwo.in/amcf/admin/metaController/viewServiceCenter");
	driver.findElement(By.linkText("AMCF")).click();
	}
	
	
	@Test
	 public void pincode() throws Exception
 	 {
 		executeTest("zipcode");
 	 }
	
}
