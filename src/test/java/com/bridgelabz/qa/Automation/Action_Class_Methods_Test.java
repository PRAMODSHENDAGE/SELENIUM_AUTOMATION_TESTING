package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Action_Class_Methods_Test {
	
    WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void action_Class_Methods() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions =new Actions(driver);
		WebElement element = driver.findElement(By.id("email"));
//		actions.contextClick(element).perform();
		WebElement element1 = driver.findElement(By.id("pass"));
		actions.moveToElement(element1).click().perform();
		actions.doubleClick(element).perform();
	}
	
	@Test
	public void drag_And_Drop() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		WebElement pick = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		Thread.sleep(3000);
		Actions actions =new Actions(driver);
//		actions.dragAndDrop(pick, drop).perform();
		actions.clickAndHold(pick).perform();
		actions.moveToElement(drop).release().perform();
     }
	
	@Test
	public void keyBoard_Operations_Test() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		driver.get("https://www.facebook.com/");
		WebElement element = driver.findElement(By.id("email"));
		actions.keyDown(Keys.SHIFT).perform();
		actions.sendKeys("Pramod");
		actions.keyUp(Keys.SHIFT).perform();
	}		
}
