package stepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login  extends ProjectSpecificMethod{




@Given ("Load the url")
public void loadTheUrl() {
	System.out.println("GetDriver method in Test method  : " + getDriver());
	getDriver().get("https://login.salesforce.com/");
}

@Given ("Enter the username as (.*)$")
public void enterUsername(String uname) throws IOException {
	try {
		getDriver().findElement(By.id("username")).sendKeys(uname);
		reportStep("Username entered successfully", "pass");
	} catch (Exception e) {
		reportStep("Failed to enter the username", "fail");
	}
	
}

@Given ("Enter the password as {string}")
public void enterPassword(String pwd) throws IOException {
	try {
		getDriver().findElement(By.id("password")).sendKeys(pwd);
		reportStep("password entered successfully", "pass");
	} catch (Exception e) {
		reportStep("unable to enter the password", "fail");
	}
}

@When ("Click on the login button")
public void clickLogin() throws IOException {
	try {
		getDriver().findElement(By.id("Login")).click();
		reportStep("User clicked login button successfully", "pass");
	} catch (Exception e) {
		reportStep("Unable to click the login button", "fail");
	}
}

@Then ("Verify the login successfully")
public void verifyLogin() {
	System.out.println(getDriver().getTitle());
}

}
