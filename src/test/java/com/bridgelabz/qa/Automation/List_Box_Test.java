package com.bridgelabz.qa.Automation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class List_Box_Test {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void drop_Down_Handling() {
		driver.get("https://www.facebook.com/login/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		driver.findElement(By.name("firstname")).sendKeys("Pramod");
		driver.findElement(By.name("lastname")).sendKeys("Shendage");
		driver.findElement(By.name("reg_email__")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("shendagepramod@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("Qwerty@12344444");
		WebElement daydrop = driver.findElement(By.id("day"));
		Select day = new Select (daydrop);
		day.selectByIndex(19);
		day.selectByValue("20");
		day.selectByVisibleText("20");
		
		WebElement monthdrop = driver.findElement(By.id("month"));
		Select month = new Select (monthdrop);
		month.selectByIndex(9);
		month.selectByValue("10");
		month.selectByVisibleText("Oct");
		
		WebElement yeardrop = driver.findElement(By.id("year"));
		Select year = new Select (yeardrop);
		year.selectByIndex(29);
		year.selectByValue("1994");
		year.selectByVisibleText("1994");
	}
	
	@Test
	public void multi_Select_List_Box_Testing() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement list = driver.findElement(By.id("mtr"));
//********  Create an object of Select class and pass the address of list box as an argument
		Select Item = new Select(list);
//********  getOptions() method returns a list of all the elements of the list box
		List<WebElement> options = Item.getOptions();
		int size = options.size();
		System.out.println("Number of elements present inside the listbox is : "+ size);
//*********  Print all the elements present in the list box
		for (WebElement webElement : options) {
		String text = webElement.getText();
		System.out.println(text);
		}
		Item.selectByIndex(0);
		Item.selectByValue("v");
		Item.selectByVisibleText("DOSA");
		List<WebElement> allSelectedOptions = Item.getAllSelectedOptions();
		int size2 = allSelectedOptions.size();
		System.out.println("Number of items that is selected in the list box is : "+size2);
		System.out.println("Selected items are printed below ");
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
			}
		
		System.out.println("check whether it is a multiple select listbox or not");
		boolean multiple = Item.isMultiple();
		System.out.println(multiple +" yes , it is multi select");
		if (multiple) {
//********   Print the first selected option in the list box
		WebElement firstSelectedOption = Item.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText()+" is the first selected item in the list box");
//********   deselect the item present in 0th index.
		Item.deselectByIndex(0);
//********   Print the first selected option in the list box
		WebElement firstSelectedOption1 = Item.getFirstSelectedOption();
		System.out.println(firstSelectedOption1.getText()+" is the first selected item");
		
		Item.deselectByValue("v");
		//Print the first selected option in the list box
		WebElement firstSelectedOption2 = Item.getFirstSelectedOption();
		System.out.println(firstSelectedOption2.getText()+" is the first selected item");
		Item.selectByVisibleText("POORI");
	}
  }
	
	@Test
	public void print_List_Values_In_Sorted_Order() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select Item = new Select(listElement);
		List<WebElement> allOptions = Item.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		ArrayList<String> list = new ArrayList<String>();
		for (WebElement option : allOptions) {
		String text = option.getText();
		System.out.println(text);
		list.add(text);
		}
		Collections.sort(list);
		System.out.println("-----print the value in sorted order----");
		for (String value : list) {
		System.out.println(value); 
	}
  }
	
	@Test
	public void print_Unique_Element_In_List_Box() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select Item = new Select(listElement);
		List<WebElement> allOptions = Item.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		HashSet<String> allElements = new HashSet<String>();
		for (WebElement option : allOptions) {
		String text = option.getText();
		System.out.println(text);
		allElements.add(text);
	  }
		System.out.println(allElements);
	}
	
	@Test
	public void print_Unique_Element_In_Sorted_Order() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement listElement = driver.findElement(By.id("mtr"));
		Select Item = new Select(listElement);
		List<WebElement> allOptions = Item.getOptions();
		int count = allOptions.size();
		System.out.println(count);
		System.out.println("-----print the values in the list ----");
		TreeSet<String> allElements = new TreeSet<String>();
		for (WebElement option : allOptions) {
		String text = option.getText();
		System.out.println(text);
		allElements.add(text);
		}
		System.out.println(allElements);
	}

	@Test
	public void check_List_Has_Duplicate_Values() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement listBox = driver.findElement(By.id("mtr"));
		Select Item = new Select(listBox);
		List<WebElement> allOptions = Item.getOptions();
		int count1 = allOptions.size();
		System.out.println("Number of elements in the list are:" +count1);
		HashSet<String> allElementText = new HashSet<String>();
		 for (int i = 0; i < count1; i++) {
		 String text = allOptions.get(i).getText();
		 System.out.println(text);
		 allElementText.add(text);
	   }
		 int count2 = allElementText.size();
		 System.out.println("Number of elements in the hashset is :" +count2);
		 if (count1==count2) {
		 System.out.println("list box has NO duplicate values");
		 }
		 else{
			 System.out.println("list box has duplicate values");
		 }
		 System.out.println(allElementText);
		 driver.close();
	}
	
	@Test
	public void print_The_Duplicate_Item_In_The_List() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement listBox = driver.findElement(By.id("mtr"));
		Select Item = new Select(listBox);
		List<WebElement> allOptions = Item.getOptions();
		int count1 = allOptions.size();
		System.out.println("Number of elements in the list are:" +count1);
		HashSet<String> allElementText = new HashSet<String>();
		 for (int i = 0; i < count1; i++) {
		 String text = allOptions.get(i).getText();
		 if (!allElementText.add(text)) {
			 System.out.println(text +" is the duplicate item in the list box");
			 }
			 }
			 System.out.println(allElementText.size());
			 System.out.println(allElementText);
			 driver.close();
	  }
	
	@Test
	public void print_Occurance_Of_Poori_In_The_List() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\Multi List Box.html");
		driver.manage().window().maximize();
		WebElement list = driver.findElement(By.id("mtr"));
		Select Item = new Select(list);
		List<WebElement> allElements = Item.getOptions();
		HashMap<String, Integer> hashMapObj = new HashMap<String, Integer>();
		for (WebElement element : allElements) {
			String text = element.getText();
			if (hashMapObj.containsKey(text)) {
			Integer value = hashMapObj.get(text);
			value++;
			hashMapObj.put(text, value);
			}else{
				hashMapObj.put(text, 1);
	 }
   }
		Set<String> allKeys = hashMapObj.keySet();
		for (String key : allKeys) {
		Integer value = hashMapObj.get(key);
		System.out.println(key +" -->"+ value);
		if (value>1) {
			System.out.println("Occurance of " + key + " is :" + value);
   }
  }
 }
}