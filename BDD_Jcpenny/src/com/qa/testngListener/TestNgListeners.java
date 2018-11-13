package com.qa.testngListener;


import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.qa.stepdefinition.Stepdefinition;

public class TestNgListeners implements ITestListener{
	private WebDriver driver;
	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		//WebDriver driver = null;
		System.out.println("Testcases failed & details are " + result.getName());
		System.out.println("Failed - now Take a screenshot");
		 this.driver = ((Stepdefinition)result.getInstance()).driver;
		 if (!result.isSuccess())
		 {
			 System.out.println("Anu");
			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File scrFile = scrShot.getScreenshotAs(OutputType.FILE);
			System.out.println("Bala");
			try {
				System.out.println("bala");
				FileUtils.copyFile(scrFile,new File("C:\\Users\\anusuya.balamurugan\\eclipse-workspace\\BDD_Jcpenny\\FailedTestCase\\"+result.getMethod().getMethodName()+".png"));
				System.out.println("Screenshot taken");
			} catch (IOException e) {
				
				System.out.print(e.getMessage());
			}
		 }
			
			
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

}
