package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Popup_Handling_Test {
	
  public static  WebDriver driver;
	
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
		driver.get("https://www.freepdfconvert.com/pdf-to-word");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Choose PDF file")).click();
		Runtime.getRuntime().exec("C:\\Users\\Admin\\Desktop\\Selenium automation\\page1.exe");
	}
	
	@Test
	public void file_Upload_Popup_Using_Sendkeys() throws IOException {
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\Admin\\Downloads\\Sprocket-converted.pdf");
		driver.findElement(By.xpath("//button[@type='button']")).click();
	}
	
	@Test
	public void get_The_Window_ID_Test() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		String windowid = driver.getWindowHandle();
		System.out.println("The current window id is: " +windowid);
	}
	
	@Test
	public void child_Browser_Popup() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentId = driver.getWindowHandle();
		System.out.println("The current window id is: " +parentId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println("The all window id's are: " +allWindowID);
		int count = allWindowID.size();
		System.out.println("The number of windows opened by selenium are: " +count);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for(String WindowHandle : allWindowID) {
			driver.switchTo().window(WindowHandle);
			String title = driver.getTitle();
			System.out.println("The title of Browser window is: " +title);
			if(WindowHandle.equals(parentId)) {
				driver.close();
			}
		}
		driver.quit();
	}
	
	@Test
	public void close_child_Browser_Window() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentId = driver.getWindowHandle();
		System.out.println("The current window id is: " +parentId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println("The all window id's are: " +allWindowID);
		int count = allWindowID.size();
		System.out.println("The number of windows opened by selenium are: " +count);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		for(String WindowHandle : allWindowID) {
			driver.switchTo().window(WindowHandle);
			String title = driver.getTitle();
			System.out.println("The title of Browser window is: " +title);
			if(!WindowHandle.equals(parentId)) {
				driver.close();
			}
		}
		driver.quit();
	}
	
	@Test
	public void close_Specific_Browser_Window() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println("The all window id's are: " +allWindowID);
		int count = allWindowID.size();
		System.out.println("The number of windows opened by selenium are: " +count);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String expected_title = "IRCTC Next Generation eTicketing System";
		for(String WindowHandle : allWindowID) {
			driver.switchTo().window(WindowHandle);
			String actual_title = driver.getTitle();
			System.out.println("The title of Specified Browser window is: " +actual_title);
			if(actual_title.contains(expected_title)) {
				driver.close();
			}
		}
		driver.quit();
	}
}
