package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Launch_Browser {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void launch_Chrome_Browser() throws InterruptedException {
	
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		System.out.println("Current page title is:" + title);
		String url = driver.getCurrentUrl();
		System.out.println("Current page url is:" + url);
		String sourcecode = driver.getPageSource();
		System.out.println("Current page sourcecode is:" + sourcecode);
		driver.navigate().to("https://mail.google.com/mail");
		driver.navigate().back();
		driver.navigate().forward();
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("identifierId")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.id("password")).sendKeys("pramod");
		driver.findElement(By.id("passwordNext")).click();
		driver.close();
		
	}

	@Test
	public void browser_Navigations() throws InterruptedException {
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://mail.google.com/mail");
		String expectedUrl = "https://www.google.com/intl/en-GB/gmail/about/";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("The Expected Url is :" + expectedUrl);
		System.out.println("The Actual Url is :" + actualUrl);
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("Displaying correct Web Page");
		}
		else
		{
			System.out.println("Not Displaying correct Web page");
		}
		driver.navigate().back();
		String expectedTitle = "Google";
		String actualTitle = driver.getTitle();
		System.out.println("The Expected Title is :" + expectedTitle);
		System.out.println("The Actual Title is :" + actualTitle);
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Displaying correct Web Page");
		}
		else
		{
			System.out.println("Not Displaying correct Web page");
		}
		driver.navigate().refresh();
		driver.navigate().forward();
		WebElement element = driver.findElement(By.linkText("Sign in"));
		if(element.isDisplayed())
		{
			System.out.println("Displaying correct Web Page");
		}
		else
		{
			System.out.println("Not Displaying correct Web page");
		}
	}
		
	@Test
	public void launch_Firefox_Browser() {
		
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println("Current page title is:" + title);
		String url = driver.getCurrentUrl();
		System.out.println("Current page url is:" + url);
		String sourcecode = driver.getPageSource();
		System.out.println("Current page sourcecode is:" + sourcecode);
		driver.close();
	}
	
	@Test
	public void launch_Edge_Browser() {
		
		System.setProperty("webdriver.edge.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");
		String title = driver.getTitle();
		System.out.println("Current page title is:" + title);
		String url = driver.getCurrentUrl();
		System.out.println("Current page url is:" + url);
		String sourcecode = driver.getPageSource();
		System.out.println("Current page sourcecode is:" + sourcecode);
		driver.close();
		
//		driver.get("https://mail.google.com/mail");
//		driver.findElement(By.id("identifierId")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.id("identifierNext")).click();
//		driver.findElement(By.id("password")).sendKeys("pramod");
//		driver.findElement(By.id("passwordNext")).click();
	}
}
