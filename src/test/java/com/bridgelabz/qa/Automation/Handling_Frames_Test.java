package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Handling_Frames_Test {
	
	@Test
	public void frame_Handling() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("file:///C:\\Users\\Admin\\Desktop\\Selenium automation/Page2.html");
	    driver.manage().window().maximize();
	    driver.findElement(By.id("t2")).sendKeys("Pramod");
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("t1")).sendKeys("Shendage");
	    driver.switchTo().defaultContent();
	}
}
