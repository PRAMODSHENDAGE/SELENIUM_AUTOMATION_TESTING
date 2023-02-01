package com.bridgelabz.qa.Automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Facebook_Tests {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void sign_Up() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.findElement(By.xpath("//a[@href='/r.php?locale=en_GB&display=page']")).click();
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		
		// ****************************** FIRST NAME ****************************** // 
		
//		driver.findElement(By.name("firstname")).sendKeys("Pramod");
//      driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys("Pramod");
//		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Pramod");
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_b')]")).sendKeys("Pramod");
//		driver.findElement(By.cssSelector("input[aria-label='First name']")).sendKeys("Pramod");
		driver.findElement(By.xpath("//input[@aria-label='First name']")).sendKeys("Pramod");

		// ****************************** LASST NAME ****************************** // 
		
//		driver.findElement(By.name("lastname")).sendKeys("Shendage");
//      driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Shendage");
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Shendage");
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_d')]")).sendKeys("Shendage");
//		driver.findElement(By.cssSelector("input[aria-label='Surname']")).sendKeys("Shendage");
		driver.findElement(By.xpath("//input[@aria-label='Surname']")).sendKeys("Shendage");
		
		// ****************************** MOBILE NUMBER AND EMAIL ADDRESS ****************************** // 
		
//		driver.findElement(By.name("reg_email__")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.name("reg_email__")).sendKeys("9892033294");
//		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.cssSelector("input[name='reg_email__']")).sendKeys("9892033294");
//		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9892033294");
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_g')]")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_g')]")).sendKeys("9892033294");
//		driver.findElement(By.cssSelector("input[aria-label='Mobile number or email address']")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.cssSelector("input[aria-label='Mobile number or email address']")).sendKeys("9892033294");
		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("9892033294");
		
		// ****************************** EMAIL ADDRESS CONFIRMATION ****************************** // 
		
//		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.cssSelector("input[name='reg_email_confirmation__']")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_j')]")).sendKeys("shendagepramod@gmail.com");
//		driver.findElement(By.cssSelector("input[aria-label='Re-enter email address']")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.xpath("//input[contains(@aria-label,'enter')]")).sendKeys("shendagepramod@gmail.com");
		
		// ****************************** NEW PASSWORD ****************************** // 
		
//		driver.findElement(By.id("password_step_input")).sendKeys("Qwerty@123");
//		driver.findElement(By.name("reg_passwd__")).sendKeys("Qwerty@123");
		driver.findElement(By.cssSelector("input[data-type='password']")).sendKeys("Qwerty@123");
//		driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys("Qwerty@123");
		
		// ****************************** DATE OF BIRTH ****************************** // 
		
//		driver.findElement(By.id("day")).sendKeys("20");
//		driver.findElement(By.id("month")).sendKeys("october");
//		driver.findElement(By.id("year")).sendKeys("1994");
//		driver.findElement(By.name("birthday_day")).sendKeys("20");
//		driver.findElement(By.name("birthday_month")).sendKeys("october");
//		driver.findElement(By.name("birthday_year")).sendKeys("1994");
		driver.findElement(By.cssSelector("select[title='Day']")).sendKeys("20");
		driver.findElement(By.cssSelector("select[title='Month']")).sendKeys("october");
		driver.findElement(By.cssSelector("select[title='Year']")).sendKeys("1994");
		
		// ****************************** GENDER ****************************** // 
		
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_5')]")).click();
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_4')]")).click();
//		driver.findElement(By.xpath("//input[contains(@id,'u_0_6')]")).click();
//		driver.findElement(By.xpath("//input[@type='radio'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@type='radio'][@value='2']")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();

		// ****************************** SIGN UP BUTTON ****************************** // 
		
//		driver.findElement(By.xpath("//button[contains(text(),'Sign')]")).click();
//		driver.findElement(By.name("websubmit")).click();
//		driver.findElement(By.xpath("//button[contains(@id,'u_0_s')]")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
		// ****************************** ALREADY HAVE AN ACCOUNT ****************************** // 
		
//		driver.findElement(By.xpath("//a[contains(text(),'account')]")).click();
//		driver.findElement(By.xpath("//a[starts-with(text(),'Already')]")).click();
//		driver.findElement(By.linkText("Already have an account?")).click();
		
	}
	
	// ****************************** FACEBOOK SIGN IN ****************************** // 
	
	@Test
	public void sign_In() throws InterruptedException {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("email")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.name("pass")).sendKeys("revolution2020@)@)");
		driver.findElement(By.name("login")).click();
		String url = driver.getCurrentUrl();
		System.out.println("Current page url is:" + url);
		String expectedUrl="https://www.facebook.com/";
		String actualUrl = driver.getCurrentUrl();
		if(actualUrl.contains(expectedUrl)){
			System.out.println("Home page is displayed");
			} else {
			System.out.println("Home page is not displayed");
		     }
		driver.close();
	}
}

