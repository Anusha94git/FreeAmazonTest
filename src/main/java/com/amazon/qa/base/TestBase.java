package com.amazon.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.amazon.qa.TestUtility.TestUtil;
import com.amazon.qa.TestUtility.WebEventListener;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public TestBase()
	{
		try
		{
			FileInputStream file = new FileInputStream("F:\\Javaworkspace\\FreeAmazonTest\\src\\main\\java\\com\\amazon\\qa\\config\\config.properties");
			prop = new Properties();
			prop.load(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	public void initialization()
	{
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Javaworkspace\\FreeAmazonTest\\driverFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageload_timeout, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
				
	}
	
	

}
