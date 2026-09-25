package org.iitwf.nexuspulse;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
	
	public void onTestSuccess(ITestResult result) {
	    System.out.println("Test passed: " + result.getMethod().getMethodName());

	    Object instance = result.getInstance();
	    BaseClass baseClass = (BaseClass) instance;

		/*
		 * try { // Close alert if present BEFORE screenshot try {
		 * baseClass.driver.switchTo().alert().accept(); } catch
		 * (NoAlertPresentException ignored) {}
		 */
	        try {
				ScreenshotUtil.captureScreenshot(baseClass.driver, result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	   /* } catch (Exception e) {
	        e.printStackTrace();
	    }
	}*/

	}
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test failed: " + result.getMethod().getMethodName());

	    Object instance = result.getInstance();
	    BaseClass baseClass = (BaseClass) instance;

	    try {
	        // Close alert if present BEFORE screenshot
	        try {
	            baseClass.driver.switchTo().alert().accept();
	        } catch (NoAlertPresentException ignored) {}

	        ScreenshotUtil.captureScreenshot(baseClass.driver, result.getMethod().getMethodName());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	

}
