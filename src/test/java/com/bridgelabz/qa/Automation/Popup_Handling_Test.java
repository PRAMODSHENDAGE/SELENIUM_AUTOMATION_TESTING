package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Popup_Handling_Test {
	
    WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void simple_Alert_Popup_Test() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("alertButton")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	@Test
	public void simple_Confirmation_Popup_Test() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("confirmButton")).click();
		Alert alert = driver.switchTo().alert();
//		alert.accept();
		alert.dismiss();
	}
	
	@Test
	public void simple_Prompt_Popup_Test() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("promtButton")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Pramod");
		alert.accept();
//		alert.dismiss();
	}
	
	@Test
	public void hidden_Division_Popup() throws InterruptedException {
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@class='flex flex-middle  t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']")).click();
        driver.findElement(By.xpath("//div[@aria-label='Sat Feb 04 2023']")).click();
	}
	
	@Test
	public void file_Upload_Popup() throws IOException {
		driver.get("https://www.ilovepdf.com/compress_pdf");
		driver.manage().window().maximize();
		driver.findElement(By.id("pickfiles")).click();
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\Selenium automation\\page.exe");
	}
}
