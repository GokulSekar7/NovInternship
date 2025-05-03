package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class TC_001 extends BaseClass{

	@BeforeTest
	public void setData() {
		testcaseName ="Login testcase";
		testcaseDesc ="Login testcase with positive data";
		authorName = "gokul";
		categoryName = "regression";
	}
	
	
	@Test
	public void runTc001() {
		new Login()
		.loadTheUrl()
		.enterUsername("gokul.sekar@testleaf.com")
		.enterPassword("Leaf$123")
		.clickLogin();
		
	}
	
}
