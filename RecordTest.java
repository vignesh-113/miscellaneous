package start.com;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;

public class RecordTest {
 
 WebDriver driver;
 ATUTestRecorder recorder;

 @BeforeTest
 public void setup() throws Exception {
  DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
  Date date = new Date();
  //Created object of ATUTestRecorder
  //Provide path to store videos and file name format.
  recorder = new ATUTestRecorder("D:/ScriptVideos/","TestVideo-"+dateFormat.format(date),false);
  //To start video recording.
  recorder.start();  
  System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
	driver = new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("http://google.com/");
 }

 @Test(priority =0)
 public void testCaseOne() throws IOException
 {
 	driver.get("http://www.google.com");
 	//driver.findElement(By.className("gbdh")).click();
 }

 @Test(priority =1)
 public void testCaseTwo()
 {
 	driver.get("http://www.gmail.com");
 	//Assert.assertTrue(false);
 }
 
 @AfterTest
 public void Close() throws Exception {
  driver.close();
  //To stop video recording.
  recorder.stop();
 }
}
