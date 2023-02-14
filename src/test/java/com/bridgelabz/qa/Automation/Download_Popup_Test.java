package com.bridgelabz.qa.Automation;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Download_Popup_Test {

	@Test
	public void file_Download_Using_Chrome() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "C:\\Users\\Admin\\Downloads\\New folder");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		driver.get("http://www.seleniumhq.org/download/");
		String xp = "//div[3]//div[1]//div[2]//p[2]//a[1]";
		driver.findElement(By.xpath(xp)).click();
	}
	
	@Test
	public void file_Download_Using_Firefox() throws IOException, InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		FirefoxProfile profile = new FirefoxProfile();
		String key = "browser.helperApps.neverAsk.saveToDisk";
		String value = "application/zip";
		profile.setPreference(key, value);
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", "C:\\Users\\Admin\\Downloads\\New folder");
		DesiredCapabilities cap = new DesiredCapabilities();
		driver.get("http://www.seleniumhq.org/download/");  
		driver.findElement(By.xpath("//div[3]//div[1]//div[2]//p[2]//a[1]")).click();
	}
}
