package testcase;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.Login;

public class TC_002 extends BaseClass{

	
	@Test
	public void runTc001() {
		new Login()
		.loadTheUrl()
		.enterUsername("gokul.sekar@testleaf.com")
		.enterPassword("Leaf$123")
		.clickLogin()
		.verifyLogin()
		.clickAppLauncher()
		.clickViewAllBtn()
		.clickSales()
		.clickTab("Leads");
		
	}
	
	
	@BeforeTest
	public void setData() {
		testcaseName ="Login testcase2";
		testcaseDesc ="Login testcase2 with positive data";
		authorName = "gokul";
		categoryName = "regression";
	}
}
