package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login  extends BaseClass{



@Given ("Load the url")
public Login loadTheUrl() {
	try {
		
		getDriver().get("https://login.salesforce.com/");
		
		reportStep("pass", "Url loaded successfully");
		
	} catch (Exception e) {
		reportStep("fail", "failed to load the url "+e);
	}
	return this;
}

@Given ("Enter the username as {string}")
public Login enterUsername(String uname) {
	try {
		getDriver().findElement(By.id("username")).sendKeys(uname);
		reportStep("pass", "Username entered successfully");
	} catch (Exception e) {
		reportStep("fail", "Unable enter username ");
	}
	return this;
}

@Given ("Enter the password as {string}")
public Login enterPassword(String pwd) {
	getDriver().findElement(By.id("password")).sendKeys(pwd);
	return this;
}

@When ("Click on the login button")
public Login clickLogin() {
	try {
		try {
			getDriver().findElement(By.id("Login")).click();
		} catch (ElementClickInterceptedException e) {
			WebElement loginBtn = getDriver().findElement(By.id("Login"));
			getDriver().executeScript("arguments[0].click()", loginBtn);
		}
		
		reportStep("pass", "Login btn clicked successfully");
	} catch (Exception e) {
		reportStep("fail", "Failed to click login "+e);
	}
	return this;
}

@Then ("Verify the login successfully")
public HomePage verifyLogin() {
	System.out.println(getDriver().getTitle());
	return new HomePage();
}

}
