package start.com;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Grid 

{
	 private static  WebDriver driver;
	 String baseURL,nodeURL;
	 
	@BeforeTest
    public void BeforeClass() throws MalformedURLException	    
    {   baseURL="http://google.com";
		nodeURL="http://10.10.110.26:5566/wd/hub";
		DesiredCapabilities cap =null;
		//System.setProperty("webdriver.chrome.driver", "D://ChromeDriver.exe");		
		cap = DesiredCapabilities.firefox();
		cap.setBrowserName("firefox");
		cap.setPlatform(Platform.VISTA);
		
	   	//System.setProperty("webdriver.chrome.driver", "D:/Common drivers/ChromeDriver.exe");	    	  	
    	driver = new RemoteWebDriver(new URL(nodeURL), cap);		    	   	
    	driver.manage().window().maximize();		
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
    }

    @AfterTest
    public void AfterClass()
    {
        driver.close();
        driver.quit();
    }

    @Test(enabled = true)
    public void drag() throws Exception
    {    	
    	driver.get(baseURL);
    	Thread.sleep(5000);
    }
 

}
