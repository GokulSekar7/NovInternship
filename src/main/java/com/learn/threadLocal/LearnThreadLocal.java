package com.learn.threadLocal;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class LearnThreadLocal {
	
	/*@Test(invocationCount = 3, threadPoolSize = 3)
	public void runTest() {
		ChromeDriver driver = new ChromeDriver();
		System.out.println("Window : "+driver.getWindowHandle());
		System.out.println("Session Id : "+driver.getSessionId());
		driver.close();
	}*/
	
	private static final ThreadLocal<RemoteWebDriver> rt = new ThreadLocal<RemoteWebDriver>();
	
	public static void setDriver() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
//		ChromeDriver driver = new ChromeDriver(option);
		rt.set(new ChromeDriver(option));
		
		
	}
	
	public static RemoteWebDriver getDriver() {
		return rt.get();
	}
	
	public static void main(String[] args) {
		setDriver();
		getDriver().get("https://login.salesforce.com/");
	}
	
	
	
}
