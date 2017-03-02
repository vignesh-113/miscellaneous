package Formloop;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class toolsqa
{
 static Integer v1;
 static Integer v2;
	
	public static void main(String args[]) throws InterruptedException
	{  
		WebDriver driver;		
		System.setProperty("webdriver.chrome.driver", "D:/Common drivers/chromedriver.exe");
    	driver = new ChromeDriver();		    	   	
    	driver.manage().window().maximize();		
    	driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);
		driver.get("http://store.demoqa.com/products-page/product-category/imacs/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath(".//*[@id='meta']/ul/li[1]/a")).click();
		driver.findElement(By.xpath(".//*[@id='user_login']")).sendKeys("tester");
		driver.findElement(By.xpath("id('user_email')")).sendKeys("demotestingqa@gmail.com");
		driver.findElements(By.xpath(".//*[@id='registerform']/div/strong"));
		 		 	 
		String i1=driver.findElement(By.className("aiowps-captcha-equation")).getText();
		String[] n = i1.split("\\s");
		//System.out.println(n[0]);System.out.println(n[1]);System.out.println(n[2]);System.out.println(n[3]);
		 
		HashMap<String,Integer> hr=new HashMap<String,Integer>();
			hr.put("one",1);				hr.put("two",2);
			hr.put("three",3);				hr.put("four",4);
			hr.put("five",5);				hr.put("six",6);
			hr.put("seven",7);				hr.put("eight",8);
			hr.put("nine",9);			    hr.put("ten",10);
			hr.put("eleven",11);			hr.put("twelve",12);
			hr.put("thirteen",13);			hr.put("fourteen",14);
			hr.put("fifteen",15);			hr.put("sixteen",16);		
			hr.put("seventeen",17);			hr.put("eighteen",18);
			hr.put("nineteen",19);			hr.put("twenty",20);
			
		if(StringUtils.isAlpha(n[0])&&StringUtils.isAlpha(n[2]))
			{
			v1=hr.get(n[0]);
			v2=hr.get(n[2]);
			}
		else if(StringUtils.isNumeric(n[0])&&StringUtils.isNumeric(n[2]))
			{
			v1 = Integer.valueOf(n[0]);//Integer.parseInt(n[0]);
			v2 = Integer.valueOf(n[2]);//Integer.parseInt(n[2]);		 
			}
		else if(StringUtils.isNumeric(n[0])&&StringUtils.isAlpha(n[2]))
			{
			v1 = Integer.valueOf(n[0]);
			v2=hr.get(n[2]);
			}
		else if(StringUtils.isAlpha(n[0])&&StringUtils.isNumeric(n[2]))
			{
			v1=hr.get(n[0]);
			v2 = Integer.valueOf(n[2]);
			}				
		 if(i1.contains("×"))
		 {
			 Integer ans=v1*v2;
			    //System.out.println("IN x \n"+ i1 + ans);
			    driver.findElement(By.name("aiowps-captcha-answer")).sendKeys(String.valueOf(ans));			     
		 }
		 else if(i1.contains("+"))
		 {
			 Integer ans = v1+v2;
			    //System.out.println("IN + \n"+ i1 + ans);
			    driver.findElement(By.name("aiowps-captcha-answer")).sendKeys(String.valueOf(ans));
		 }
		 else if(i1.contains("−"))
		 {
			  Integer ans = v1-v2;
			    //System.out.println("IN - \n"+ i1 + ans);
			    driver.findElement(By.name("aiowps-captcha-answer")).sendKeys(String.valueOf(ans));
		 }				 
		 driver.findElement(By.name("wp-submit")).click();		 		 
	}
}