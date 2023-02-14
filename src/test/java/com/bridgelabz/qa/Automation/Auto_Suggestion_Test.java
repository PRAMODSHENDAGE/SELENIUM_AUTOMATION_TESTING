package com.bridgelabz.qa.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Auto_Suggestion_Test {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void auto_Suggestion_Of_Google_search() throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("q")).sendKeys("java");
		List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(text(),'java')]"));
		int count = allOptions.size();
		System.out.println("Number of values Present in the dropdown is: " +count);
		String expectedValue="javascript";
		
//*************	Print all the auto suggestion value     ************//
 		for (WebElement option : allOptions) {
		String text = option.getText();
		Thread.sleep(3000);
		System.out.println(" "+text);
		Thread.sleep(3000);
		if (text.equalsIgnoreCase(expectedValue)) {
			option.click();
			break;
	 }
	}
  }
}
