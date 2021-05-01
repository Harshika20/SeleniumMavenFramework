package com.selenium.testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.selenium.pageObjects.Login;

public class LoginClass extends Login {

	WebDriver driver = null;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test ;

	@BeforeSuite
	public void setup1() {
		
		

		htmlReporter = new ExtentHtmlReporter("/Users/hdhamank/eclipse-workspace/SeleniumMaven/extentNew.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	public void setUpTest() {
		
		System.setProperty("webdriver.chrome.driver", "/Users/hdhamank/eclipse-workspace/SeleniumMaven/Drivers/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void test1() throws InterruptedException, IOException {


		 test = extent.createTest("Test Login");
		driver.get("https://www.linkedin.com/home");
		Login.signin(driver).click();
		Thread.sleep(300);
		Login.username(driver).sendKeys("harshika.dhamankar@gmail.com");
		Thread.sleep(10);
		Thread.sleep(10);
		Login.password(driver).sendKeys("Harshu!20100");
		Thread.sleep(10);
		Login.login_btn(driver).click();
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		test.pass("Logged in successfully");


		// log with snapshot
//		test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());

		// test with snapshot
		test.addScreenCaptureFromPath("screenshot.png");
	}
	
//	@Test
//	public void test2() throws InterruptedException, IOException {
//
//		test = extent.createTest("Test Login");
//		
//		test.log(Status.INFO, "This step shows usage of log(status, details)");
//		Assert.fail("Login Failed");
//
//
//		// log with snapshot
////		test1.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
//
//		// test with snapshot
//		test.addScreenCaptureFromPath("screenshot.png");
//	}

	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Logged in successfully");
	}

	@AfterMethod
	@AfterSuite
	public void tearDown() {
		extent.flush();

	}
}
