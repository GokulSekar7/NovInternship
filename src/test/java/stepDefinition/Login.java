package stepDefinition;

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
public void enterUsername(String uname) {
	getDriver().findElement(By.id("username")).sendKeys(uname);
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

@Given ("Enter the password as {string}")
public void enterPassword(String pwd) {
	getDriver().findElement(By.id("password")).sendKeys(pwd);
}

@When ("Click on the login button")
public void clickLogin() {
	getDriver().findElement(By.id("Login")).click();
}

@Then ("Verify the login successfully")
public void verifyLogin() {
	System.out.println(getDriver().getTitle());
}

}
