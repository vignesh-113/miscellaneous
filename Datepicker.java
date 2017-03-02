package Formloop;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xpath.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.base.Predicate;

import static java.util.concurrent.TimeUnit.*;

	public class Datepicker {
	    private static  WebDriver driver;
	    private static Logger Log = Logger.getLogger(Log.class.getName());

	    @BeforeClass
	    public void BeforeClass()
	    {    DOMConfigurator.configure("log4j.xml");	
	    	System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
	    	driver = new ChromeDriver();
	    	Log.info("New driver instantiated");
	    	driver.manage().window().maximize();		
	    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
	    }

	    @AfterClass
	    public void AfterClass()
	    {
	        //driver.close();
	       // driver.quit();
	    }

	    @Test(enabled = true)
	    public void drop() throws Exception
	    {	   
	        driver.get("http://dhtmlx.com/docs/products/dhtmlxTree/");
	        //Thread.sleep(5000);
	        //driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/iframe")));
	        Thread.sleep(2000);
	        Reporter.log("Application Lauched successfully | ");
	        WebElement From = driver.findElement(By.xpath("//span[contains(text(),'Thrillers')]"));
	        WebElement To = driver.findElement(By.xpath("//span[contains(text(),'History')]"));
	        Actions builder = new Actions(driver);
	        Action dragAndDrop = builder.clickAndHold(From)        
	        .moveToElement(To)	         
	        .release(To)	         
	        .build();	         
	        dragAndDrop.perform();
	        
	        //new Actions(driver).dragAndDrop(From, To).build().perform();
	        //Thread.sleep(5000);
	    }
	    
	    @Test(enabled = false)
	    public void getdate() throws Exception
	    {
	        driver.get("https://jqueryui.com/datepicker/");
	        Thread.sleep(1000);
	        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/iframe")));
	        Thread.sleep(1000);
	        
	        //System.out.println(driver.findElement(By.xpath("//*[@id='datepicker']")).getText());
	          
	        driver.findElement(By.xpath("//*[@id='datepicker']")).sendKeys("09/28/2015");
	        //Thread.sleep(5000);
	       System.out.println(driver.findElement(By.xpath("//*[@id='datepicker']")).getAttribute("value"));
	        
	        //System.out.println(((JavascriptExecutor)driver).executeScript ("return document.getElementById('datepicker').getAttribute('input');"));
	        
	    }
	    
	}
