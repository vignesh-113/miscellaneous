package Formloop;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {

	public static WebDriver driver;

	public static void main(String []args) throws IOException, InterruptedException 
	  {  
		System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		  //System.setProperty("webdriver.chrome.driver", "C:/Users/Prasanth/Downloads/chromedriver_win32/chromedriver.exe");
		  driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");
		  Thread.sleep(5000);
		  driver.switchTo().frame("iframeResult");
		  driver.findElement(By.id("myFile")).sendKeys("D:/testScreenShot.jpg");
	Thread.sleep(1000);
	driver.findElement(By.cssSelector("input[type='submit']")).click();
	Thread.sleep(1000);
	  }}
