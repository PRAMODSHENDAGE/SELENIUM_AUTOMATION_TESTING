package com.bridgelabz.qa.Automation;

import java.awt.Checkbox;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebElement_Test {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void webElement_Testing() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Sign up for Facebook")).click();
	    driver.findElement(By.name("firstname")).sendKeys("Pramod");
	    driver.findElement(By.name("firstname")).clear();
	    System.out.println(driver.findElement(By.name("firstname")).getAttribute("class"));
	    System.out.println(driver.findElement(By.name("websubmit")).getCssValue("background-color"));
	    System.out.println(driver.findElement(By.name("websubmit")).getSize());
	    System.out.println(driver.findElement(By.name("websubmit")).getSize().getWidth());
	    System.out.println(driver.findElement(By.name("websubmit")).getSize().getHeight());
	    System.out.println(driver.findElement(By.name("birthday_day")).getRect().getWidth());
	    System.out.println(driver.findElement(By.name("websubmit")).getLocation());
	    System.out.println(driver.findElement(By.name("websubmit")).getLocation().getX());
	    System.out.println(driver.findElement(By.name("websubmit")).getLocation().getY());
	    System.out.println(driver.findElement(By.xpath("//a[starts-with(text(),'Already')]")).getText());
	    System.out.println(driver.findElement(By.name("websubmit")).getTagName());
	    System.out.println(driver.findElement(By.name("websubmit")).isDisplayed());
	    System.out.println(driver.findElement(By.name("websubmit")).isEnabled());
	    driver.findElement(By.xpath("//input[contains(@id,'u_0_5')]")).click();
	    System.out.println(driver.findElement(By.xpath("//input[contains(@id,'u_0_5')]")).isSelected());
	}
	
	@Test
	public void remove_Value_From_Text_Using_Sendkeys_Method() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
		String value = driver.findElement(By.id("email")).getAttribute("value");
		System.out.println("Value present inside the text box is : "+value);
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("pramodshendage");
		driver.findElement(By.id("email")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
		driver.close();
	}
	
	@Test
	public void print_Tooltip_Using_Get_Attribute() throws InterruptedException {
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		WebElement Checkbox = driver.findElement(By.id("keepLoggedInCheckBox"));
		String tooltipText = Checkbox.getAttribute("title");
		System.out.println(tooltipText);
	}
	
	@Test
	public void different_Ways_OF_Clicking_Button() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.id("loginbutton")).click();
		driver.findElement(By.id("loginbutton")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("loginbutton")).submit();
	}
}
