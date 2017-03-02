package start.com;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;


public class Sample 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException, AWTException
	{    		
		
		//System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
		//driver = new ChromeDriver();	
		driver = new FirefoxDriver();	
		driver.get("https://yapq.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='right-menu']/i")).click();
		driver.findElement(By.xpath(".//*[@id='sidr-right']/ul/li/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='srch']/input")).sendKeys("Ban");
		driver.findElement(By.xpath(".//*[@id='srch']/input")).sendKeys(Keys.DOWN);
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		//driver.findElement(By.xpath(".//*[@id='srch']/input")).sendKeys(Keys.LEFT);
		driver.findElement(By.xpath(".//*[@id='srch']/input")).sendKeys(Keys.ENTER);
		//selectOptionWithText("Java");
		//driver.findElement(By.xpath("html/body/div[4]/div")).click();
		//driver.wait();
		//driver.quit();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.chord(Keys.ALT, "s")).perform();
		act.sendKeys(Keys.ENTER).perform();
		
	}

}
