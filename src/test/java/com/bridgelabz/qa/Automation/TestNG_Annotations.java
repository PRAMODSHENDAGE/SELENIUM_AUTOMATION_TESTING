 package com.bridgelabz.qa.Automation;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Annotations {

	@BeforeMethod
	 public void beforeMethod() {
	 Reporter.log("beforeMethod", true);
	 }
	@AfterMethod
	 public void afterMethod() {
	 Reporter.log("afterMethod", true);
	 }
	 @BeforeClass
	 public void beforeClass() {
	 Reporter.log("beforeClass", true);
	 }
	 @AfterClass
	 public void afterClass() {
	 Reporter.log("afterClass", true);
	 }
	 @BeforeTest
	 public void beforeTest() {
	 Reporter.log("beforeTest", true);
	 }
	 @AfterTest
	 public void afterTest() {
	 Reporter.log("afterTest", true);
	 }
	@BeforeSuite
	 public void beforeSuite() {
	 Reporter.log("beforeSuite", true);
	}
	@AfterSuite
	 public void afterSuite() {
	 Reporter.log("afterSuite", true);
	}
	@Test (invocationCount=3)
	public void testCase1() {
	System.out.println("This is my First Test Case 1");
	}
	 
	@Test (enabled=false)
	public void testCase2() {
	System.out.println("This is my Second Test Case 2");
	}
	@Test 
	public void testCase3() {
	System.out.println("This is my Second Test Case 3");
	}
}
