package com.bridgelabz.qa.Automation;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager_Test {
	
	@Test
	public void webDriverManager_Chrome_Driver_Test() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://mvnrepository.com/");	
	}
	
	@Test
	public void webDriverManager_Firefox_Driver_Test() {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("revolu");
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		.until(ExpectedConditions.elementToBeClickable(By.name("login")));
//		driver.findElement(By.name("login")).click();
		
	}
	
	@Test
	public void webDriverManager_Edge_Driver_Test() {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("https://mvnrepository.com/");	
	}
}
