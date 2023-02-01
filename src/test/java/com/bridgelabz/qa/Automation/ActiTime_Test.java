package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActiTime_Test {
	
    WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test 
	public void xpath() {
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("pramod");
		driver.findElement(By.xpath("//input[@class='textField'][@id='username']")).sendKeys("pramod");
//		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("123456");
//		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();	
//		driver.findElement(By.xpath("//a[@id='loginButton']//div[contains(text(),'Login')]")).click();
//		driver.findElement(By.xpath("//a[text()='loginButton']")).click();
//		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
//		driver.findElement(By.xpath("//td[@id='logoContainer']/div/img"));
//		driver.findElement(By.xpath("//a[@href='http://www.actitime.com']")).click();
//		driver.findElement(By.xpath("//a[text()='actiTIME Inc.']")).click();
		driver.findElement(By.xpath("//a[@id='toPasswordRecoveryPageLink']")).click();
		driver.findElement(By.xpath("//a[text()='toPasswordRecoveryPageLink']")).click();
		
		
	}
}
