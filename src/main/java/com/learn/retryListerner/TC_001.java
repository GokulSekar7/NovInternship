package com.learn.retryListerner;

import org.testng.annotations.Test;

public class TC_001 {

	
	@Test(retryAnalyzer = RetryAnalyzer.class,timeOut = 500)
	public void runTC_001() {
		System.out.println("Hello!!");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			
		}
	}
}
