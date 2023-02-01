package com.bridgelabz.qa.Automation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators_Test {
	
    WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test 
	public void locators_Types() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
//		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.cssSelector("input[name='email']")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.cssSelector("input[placeholder='Email address or phone number']")).sendKeys("pramod");
//		driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("pramod");
//		driver.findElement(By.name("pass")).sendKeys("revolution2020@)@)");
//		driver.findElement(By.xpath("//button[text()='Log in']")).click();
//		driver.findElement(By.name("login")).click();
//		driver.findElement(By.linkText("Forgotten password?")).click();
//		driver.findElement(By.xpath("//button[contains(@id,'u_0_')]")).click();
//		driver.findElement(By.xpath("//button[contains(@name,'log')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Log')]")).click();
//		driver.findElement(By.partialLinkText("Forgotten")).click();
		
	}
	
	@Test 
	public void locators_Test_For_Gmail(){
		driver.get("https://mail.google.com/mail");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input[name='identifier']")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.id("identifierId")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.id("identifierNext")).click();
		driver.findElement(By.id("password")).sendKeys("pramod");
		driver.findElement(By.id("passwordNext")).click();
	}
}
