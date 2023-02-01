package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScript_Executor_Test {
     WebDriver driver;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void enter_Text_Into_Disabled_Textbox() throws InterruptedException{	
		driver.get("file:///C:\\Users\\Admin\\Desktop\\Selenium automation/DisabledTextBox.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    JavascriptExecutor js =(JavascriptExecutor) driver;
	    js.executeScript("document.getElementById('t1').value='admin'");
	    js.executeScript("document.getElementById('t2').value=''");
	    js.executeScript("document.getElementById('t2').value='manager'");
	    js.executeScript("document.getElementById('t2').type='button'");
	}
	
	@Test
	public void scroll_Up_and_Down_On_Web_Page() throws InterruptedException{	
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	    js.executeScript("window.scrollBy(0,-600)");
	}
	
	@Test
	public void scroll_Up_and_Down_to_specific_Element_on_Webpage () throws InterruptedException{	
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		WebElement element = driver.findElement(By.xpath("//img[contains(@src,'applitools')]"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is " +x);
		System.out.println("Y coordinate is " +y);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	@Test
	public void scroll_Down_till_Bottom_Of_Web_Page() throws InterruptedException{	
		driver.get("https://www.selenium.dev/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		WebElement element = driver.findElement(By.linkText("About Selenium"));
		int x = element.getLocation().getX();
		int y = element.getLocation().getY();
		System.out.println("X coordinate is " +x);
		System.out.println("Y coordinate is " +y);
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
}