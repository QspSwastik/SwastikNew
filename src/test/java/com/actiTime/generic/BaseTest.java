package com.actiTime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.actiTime.pages.ActitimeHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest implements AutoConstant
{
	public static WebDriver driver;

	@BeforeSuite
	public void executionStart()
	{
		System.out.println("execution started");
	}

	//@Parameters("browser")
	@BeforeClass
	public void setup()//String browser
	//{
		//if (browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			WebDriverManager.chromedriver().setup();;
			driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
		}
//		else if(browser.equalsIgnoreCase("edge"))
//		{
//			System.setProperty(edge_key, edge_value);
//			driver=new EdgeDriver();
//			driver.manage().window().maximize();
//			driver.get(url);
//		}
//		else
//		{
//			System.setProperty(gecko_key, gecko_value);
//			driver=new FirefoxDriver();
//			driver.manage().window().maximize();
//			driver.get(url);
//		}
//	}

	@AfterClass
	public void teardown() throws InterruptedException
	{

		ActitimeHomePage homePage=new ActitimeHomePage(driver);
		homePage.logoutMethod();
		
		driver.quit();
	}

	@AfterSuite
	public void executionComplete() throws InterruptedException
	{
		System.out.println("execution ends......");
	}
}