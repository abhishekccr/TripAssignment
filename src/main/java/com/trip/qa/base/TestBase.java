package com.trip.qa.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public static  WebDriver driver;
	
	public TestBase()
	{
		
	}
	public static  WebDriver initialization() throws IOException 
	{
	
		Properties prop = new Properties();
		
		FileInputStream fis = new FileInputStream("/Users/abhishekchaudhary/eclipse-workspace/NSWTripPlannerTest/src/main/java/com/trip/qa/config/config1.properties");
		prop.load(fis);
	     String browsername= prop.getProperty("browser");
	     System.out.println(browsername);
	
		if (browsername.equalsIgnoreCase(browsername))
		{
			
			 System.setProperty("webdriver.gecko.driver", "/Users/abhishekchaudhary/Downloads/geckodriver");
			   driver= new FirefoxDriver();
			   
			
		}
		
		else if (browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/abhishekchaudhary/Downloads/chromedriver");
			   driver= new ChromeDriver();
			   
			
		}
		
		
	driver.get(prop.getProperty("url"));
	
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
	
	return driver;
		
	}

}

