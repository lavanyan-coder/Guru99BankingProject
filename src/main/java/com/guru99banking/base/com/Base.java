package com.guru99banking.base.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Logger logger = Logger.getLogger(Base.class) ;
	public static Actions action ;
	
	public Base() {
		
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\Guru99BankingProject"
					+ "\\src\\main\\resources\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("The exception is:"+ e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("The exception is:"+ e);
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		PropertyConfigurator.configure("C:\\Users\\DELL\\eclipse-workspace\\Guru99BankingProject\\src\\main\\resources\\log4j.properties");
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\\\\\geckodriver.exe");
			 driver = new FirefoxDriver();
			 logger.info("Opening FF browser");
		}
		String url = prop.getProperty("url");
		driver.get(url);
		
		logger.info("Getting the application url");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		logger.info("Maximising window and deletine the cookies");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		action = new Actions(driver);
		
	}
	public static void clickElement(WebElement element )
	{
		System.out.println("entering clickElement method");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element );
	}
}
