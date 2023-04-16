package com.smart.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass2 extends BaseClass implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		 
		captureScreenshot(result.getMethod().getMethodName()+".png");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName()+".png");
	}

		
	

}
