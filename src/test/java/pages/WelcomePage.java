package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;
import io.cucumber.java.en.When;

public class WelcomePage extends BaseClass{

	public WelcomePage(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public WelcomePage() {
		
	}
	
	@When ("Click on the {string} tab")
	public void clickTab(String tabName) {
		WebElement opportunitytab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+tabName+"']")));
		driver.executeScript("arguments[0].click();", opportunitytab);
	}
	
	
}
