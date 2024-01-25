package pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login  extends BaseClass{

public Login(RemoteWebDriver driver) {
	this.driver = driver;
}

@Given ("Load the url")
public Login loadTheUrl() {
	System.out.println("Driver value  : " + driver);
	driver.get("https://login.salesforce.com/");
	return this;
}

@Given ("Enter the username as {string}")
public Login enterUsername(String uname) {
	driver.findElement(By.id("username")).sendKeys(uname);
	return this;
}

@Given ("Enter the password as {string}")
public Login enterPassword(String pwd) {
	driver.findElement(By.id("password")).sendKeys(pwd);
	return this;
}

@When ("Click on the login button")
public Login clickLogin() {
	driver.findElement(By.id("Login")).click();
	return this;
}

@Then ("Verify the login successfully")
public HomePage verifyLogin() {
	System.out.println(driver.getTitle());
	return new HomePage(driver);
}

}
