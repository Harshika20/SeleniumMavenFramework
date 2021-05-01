package com.selenium.testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportWithTestNG {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver = null;
	
	@BeforeTest
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent4.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	@Test
	public void test1() throws IOException {
		
		ExtentTest test = extent.createTest("FirstTest","Sample Description");
		driver.get("https://www.linkedin.com/home");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		
		test.pass("Url launched successfully");

        // info(details)
        test.info("This step shows usage of info(details)");
        
        // log with snapshot
        test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test.addScreenCaptureFromPath("screenshot.png");
        
        
		
	}
	@AfterTest
	public void tearDownTest() {
		// calling flush writes everything to the log file
		extent.flush();
	}

}
