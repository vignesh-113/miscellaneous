package start.com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class startclass 
{
public static void main(String[] args) 
{
	
 WebDriver driver=new FirefoxDriver();
 driver.get("https://www.google.com");
 driver.close();
 
}
 

}
 
	
	


