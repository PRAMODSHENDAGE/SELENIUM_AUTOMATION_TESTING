package com.bridgelabz.qa.Automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Find_Element_Test {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void find_Total_No_Of_Links_Including_Visible_And_Hidden_Links() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int totalLinks = allLinks.size();
		System.out.println("total number of links present on the web page is : "+totalLinks);
		int visibleLinkCount = 0;
		int hiddenLinkCount = 0;
		for (WebElement link : allLinks) {
			if (link.isDisplayed()) {visibleLinkCount++;
			System.out.println(visibleLinkCount+" --> "+link.getText());
			}
			else
			{
				hiddenLinkCount++;
			}
			}
			System.out.println("Total number of visible links :" + visibleLinkCount);
			System.out.println("Total number of hidden links :" + hiddenLinkCount);
			driver.close();
	}
	
	@Test
	public void acti_Time() throws InterruptedException {
		driver.get("https://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("trainee");
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("trainee");
		driver.findElement(By.xpath("//a[@id='loginButton']/div")).click();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@href='/tasks/tasklist.do']")).click();
		List<WebElement> allcheckboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
		int totalcheckboxes = allcheckboxes.size();
		System.out.println("total number of checkboxes present on the web page is : "+totalcheckboxes);
		for (WebElement checkbox : allcheckboxes) {
			if (!checkbox.isSelected()) {
				checkbox.click();
			}
		}
		driver.findElement(By.xpath("(//input[@type='checkbox'])[position()=1]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[last()]")).click();
    }
}

