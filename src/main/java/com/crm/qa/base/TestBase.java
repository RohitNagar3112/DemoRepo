package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.qa.util.TestUtils;
import com.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListner;
	public TestBase()
	{
		try {
			
			FileInputStream fis=new FileInputStream("C:/Users/win 10/workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initilization()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\win 10\\Desktop\\Naveen\\chromedriver.exe");
			ChromeOptions option=new ChromeOptions();
			option.setAcceptInsecureCerts(true);
			option.addArguments("--disable-notifications");
			
			driver = new ChromeDriver(option);
			
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\win 10\\Desktop\\Naveen\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		//Now create object of EventListnerHandler to register it with EventFiringWebDriver
		eventListner= new WebEventListener();
		e_driver.register(eventListner);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.PAGE_LOAD_TIMEOUT , TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
