package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validating_Page_Test {

WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void verify_Home_Page_Using_Url() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("revolution2020@)@)");
		driver.findElement(By.name("login")).click();
		String expectedUrl = "https://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		System.out.println("The Expected Url is :" + expectedUrl);
		System.out.println("The Actual Url is :" + actualUrl);
		driver.close();
		if(actualUrl.equals(expectedUrl))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is not displayed");
		}
	}
	
	@Test
	public void verify_Home_Page_Using_Title() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("revolution2020@)@)");
		driver.findElement(By.name("login")).click();
		String expectedTitle = "Log in to Facebook";
		String actualTitle = driver.getTitle();
		System.out.println("The Expected Title is :" + expectedTitle);
		System.out.println("The Actual Title is :" + actualTitle);
		driver.close();
		if(actualTitle.equals(expectedTitle))
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is not displayed");
		}
	}
	
	@Test
	public void verify_Home_Page_Using_Web_Element() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.name("login"));
		driver.close();
		if(element.isDisplayed())
		{
			System.out.println("Home page is displayed");
		}
		else
		{
			System.out.println("Home page is not displayed");
		}
	}
	
	@Test
	public void verify_Email_Error_Msg_On_Fb_Login_Page() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("sbdgfv@gmail.com");
		driver.findElement(By.name("login")).click();
		WebElement element = driver.findElement(By.linkText("Find your account and log in."));
		String expectedError = "Find your account and log in.";
		String actualError = element.getText();
        System.out.println("The Expected Error is:" + expectedError);
        System.out.println("The Actual Error is :" + actualError);
        driver.close();
        if (actualError.equals(expectedError)) 
        {
            System.out.println("Email error message is validate successfully" );
        } 
        else 
        {
            System.out.println("Email error message is not validate successfully");
        }
    }
	
	@Test
	public void verify_Password_Error_Msg_On_Fb_Login_Page() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("adgrfrt");
		driver.findElement(By.name("login")).click();
		WebElement element = driver.findElement(By.linkText("Forgotten password?"));
		String expectedError = "Forgotten password?";
		String actualError = element.getText();
        System.out.println("The Expected Error is:" + expectedError);
        System.out.println("The Actual Error is :" + actualError);
        driver.close();
        if (actualError.equals(expectedError)) 
        {
            System.out.println("Password error message is validate successfully" );
        } 
        else 
        {
            System.out.println("Password error message is not validate successfully");
        }
    }
	
	@Test
	public void verify_Email_And_Password_entered_isnt_connected_to_an_account() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("sbdgfv@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("adgrfrt");
		driver.findElement(By.name("login")).click();
		WebElement element = driver.findElement(By.linkText("Find your account and log in."));
		String expectedError = "Find your account and log in.";
		String actualError = element.getText();
        System.out.println("The Expected Error is:" + expectedError);
        System.out.println("The Actual Error is :" + actualError);
        driver.close();
        if (actualError.equals(expectedError)) 
        {
            System.out.println("Email & Password error message is validate successfully" );
        } 
        else 
        {
            System.out.println("Email & Password error message is not validate successfully");
        }
    }
}
