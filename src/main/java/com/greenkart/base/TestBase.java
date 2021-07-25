package com.greenkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public TestBase() {
		 prop=new Properties();
		
		try {
			FileInputStream fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\greenkart\\config\\config.properties");
			// passing the path of config file path
			try {
				prop.load(fis); //loading the config file
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver_91.0.4472.101.exe");
			driver=new ChromeDriver();
			
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
	
		
	}

}
