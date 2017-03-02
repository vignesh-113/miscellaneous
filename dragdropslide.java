package Formloop;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.xpath.functions.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.common.base.Predicate;

import static java.util.concurrent.TimeUnit.*;

	public class dragdropslide {
	    private static  WebDriver driver;	    

	    
	    @FindBy(id="txtUserName")
		private WebElement UserName;	
		
		@FindBy(id="txtpassword")
		private WebElement Password;	
		
		@FindBy(id="btnLogin")
		private WebElement Login;
		
	    @BeforeClass
	    public void BeforeClass()	    
	    {   
	    	System.setProperty("webdriver.chrome.driver", "D:/Common drivers/ChromeDriver.exe");	    	  	
	    	driver = new ChromeDriver();		    	   	
	    	driver.manage().window().maximize();		
	    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
	    }

	    @AfterClass
	    public void AfterClass()
	    {
	        driver.close();
	        driver.quit();
	    }

	    @Test(enabled = true)
	    public void drag() throws Exception
	    {
	    	
	       driver.get("https://the-internet.herokuapp.com/drag_and_drop");
	       Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ESCAPE);
	    	System.out.println(driver.getTitle());
	    	//driver.get("http://appdev.eventplanningpad.com/");
	        //driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/iframe")));
	        Thread.sleep(5000);
	        WebElement d1 = driver.findElement(By.id("column-a"));
	        WebElement d2 = driver.findElement(By.id("column-b"));
	        new Actions(driver).moveToElement(d1).clickAndHold().release(d2).build().perform();
	        Thread.sleep(5000);
//	        driver.findElement(By.id("txtUserName")).sendKeys("demo");			
//	        driver.findElement(By.id("txtpassword")).sendKeys("demo123!@#");		
//	        driver.findElement(By.id("btnLogin")).click();
//	        
//	        Thread.sleep(6000);
//	        
//	        List<WebElement> draggable = driver.findElements(By.tagName("text"));	
//	        outerloop:
//	        for(WebElement web:draggable){
//	        if(web.getText().equals(("CW")))
//	        {	        	        	
//	        Point point = web.getLocation();
//	        System.out.println(point.x+","+point.y);
//	        break outerloop;
//	        }
//	        }
//	        
//	        new Actions(driver).moveByOffset(149, 530).clickAndHold().build().perform();
//			
//	        Thread.sleep(10000);
	     
	        
	        //driver.switchTo().frame(0);
	        //Thread.sleep(1000);
	        //WebElement draggable = driver.findElement(By.xpath("//*[@id='draggable']"));
	        //new Actions(driver).dragAndDropBy(draggable, 200, 120).build().perform();
	        //Thread.sleep(5000);
	    }

	    @Test(enabled = false)
	    public void drop() throws Exception
	    {	    	
	        driver.get("http://jqueryui.com/demos/droppable/");
	        Thread.sleep(1000);
	        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/iframe")));
	        Thread.sleep(1000);
	        WebElement d1 = driver.findElement(By.id("draggable"));
	        WebElement d2 = driver.findElement(By.id("droppable"));
	        new Actions(driver).dragAndDrop(d1, d2).build().perform();
	        Thread.sleep(5000);
	    }

	    @Test(enabled = false)
	    public void slide() throws Exception
	    {
	    	driver.get("http://jqueryui.com/demos/slider/");
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("E:/sample.jpeg"),true);
	    	HashMap<Integer,Integer> hour=new HashMap<Integer,Integer>();
	    	hour.put(11,120);
	    	hour.put(12,150);
	    	hour.put(13,180);
	    	hour.get(11);
	    	System.out.println(hour.get(11)+hour.get(12)+hour.get(13));
	        Thread.sleep(1000);
	        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div/div[2]/div/div/iframe")));
	        Thread.sleep(1000);
	        //int xoffset=120;
	        //int yoffset=0;
	        
	        WebElement draggable = driver.findElement(By.className("ui-slider-handle"));
	        Point point = draggable.getLocation();
	        
	        System.out.println(point.x+""+draggable.getLocation());
	        new Actions(driver).dragAndDropBy(draggable, hour.get(13), 0).build().perform();
	        
	        Thread.sleep(5000);
	        
	        Point point2 = draggable.getLocation();
	        System.out.println(point2.y+""+draggable.getLocation());
	        Point point3 = draggable.getLocation();
	        System.out.println(point3.getX()+""+draggable.getLocation());
	        new Actions(driver).dragAndDropBy(draggable, hour.get(11), 0).build().perform();		
	        Point point4 = draggable.getLocation();
	        System.out.println(point4.getY()+""+draggable.getLocation());
	        
	        File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile1, new File("E:/sample1.jpeg"),true);
	    }
	}
