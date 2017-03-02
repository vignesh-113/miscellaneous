package authentication;

import java.util.concurrent.TimeUnit;  

import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;  
  
  
public class AuthinticationRequired {  
  
    public static void main(String[] a) {  
   
     // Initialize driver  
        // WebDriver driver = new FirefoxDriver();  
    	
    	System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
     
      //Maximize browser window   
      driver.manage().window().maximize();  
     
  //driver.get("http://Username:Password@domain_name");  
            //Go to URL  
        driver.get("http://ananthaonline:anantha@43!2@www.ananthaonline.com/admin");  
    
  //Set selenium webdriver get timeout  
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);        
  
       // Browser close   
        //driver.close();  
  
    }  
}  
