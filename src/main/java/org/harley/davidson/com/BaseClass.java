package org.harley.davidson.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	@BeforeMethod
	public void preCondition() {
		System.out.println("before");
	}
	
	
	@AfterMethod
	public void postCondition() {
		System.out.println("after");
	}
	
	
}
