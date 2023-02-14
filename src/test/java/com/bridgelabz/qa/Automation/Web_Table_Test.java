package com.bridgelabz.qa.Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Web_Table_Test {

	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\CQA_113_SELENIUM_AUTOMATION\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void web_Table_Diff_Scenarios() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\WebTable.html");
		driver.manage().window().maximize();
//*********		Count Total number of rows present in the table     *********// 
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int totalRows = allRows.size();
		System.out.println("Total Number of Rows Present in the Table are :"+ totalRows);
//*********	    Count total number of columns present in the table   *********//
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int totalColumns = allColumns.size();
		System.out.println("Total Number of Columns Present in the Table are :"+ totalColumns);
//*********	    Count number of cells present in the table     *********//
		List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
		int totalCells = allCells.size();
		System.out.println("Total Number of Cells Present in the Table are:" + totalCells);
		
		int countNumberValue = 0;
		int sum=0;
		for (WebElement cell : allCells) {
		String cellValue = cell.getText();
		try{
		int number = Integer.parseInt(cellValue);
		System.out.println(""+number);
		countNumberValue++;
		sum = sum+number;
		}catch (Exception e) {
		}
		}
		System.out.println("Total count of numeric values is :"+countNumberValue);
		System.out.println("Total sum of all the numeric values is :"+sum);
	}
	
	@Test
	public void sum_Of_Marks() {
		driver.get("C:\\Users\\Admin\\Desktop\\Selenium automation\\WebTable_StudentMarks.html");
		driver.manage().window().maximize();
		List<WebElement> marksCell = driver.findElements(By.xpath("/html/body/table/tbody/tr[2]/td[3]|/html/body/table/tbody/tr[3]/td[3]|/html/body/table/tbody/tr[4]/td[3]"));
		int totalCells = marksCell.size();
		System.out.println("Total Number of Cells Present in the Table are:" + totalCells);
		int countNumberValue = 0;
		int sum=0;
		for (WebElement cell : marksCell) {
		String cellValue = cell.getText();
		try{
		int number = Integer.parseInt(cellValue);
		System.out.println(""+number);
		countNumberValue++;
		sum = sum+number;
		}catch (Exception e) {
		}
		}
		System.out.println("Total count of numeric values is :"+countNumberValue);
		System.out.println("Total sum of all the Marks is :"+sum);
		
		WebElement element = driver.findElement(By.xpath("/html/body/table/tbody/tr[5]/td[3]"));
		String expectedMarks = "100";
		String actualMarks = element.getText();
        System.out.println("The Expected Marks are:" + expectedMarks);
        System.out.println("The Actual Marks are :" + actualMarks);
        driver.close();
        if (actualMarks.equals(expectedMarks)) 
        {
            System.out.println("Total Marks from table is same as sum of Marks" );
        } 
        else 
        {
            System.out.println("Total Marks from table is not same as sum of Marks");
        }
	}
}
