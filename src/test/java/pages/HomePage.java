package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass {
	
	
	
	

	@When ("Click on the app launcher")
	public HomePage clickAppLauncher() {
		getDriver().findElement(By.className("slds-icon-waffle")).click();
		return this;
	}
	
	@When ("Click on the view all button")
	public AppLauncherPage clickViewAllBtn() {
		getDriver().findElement(By.xpath("//button[text()='View All']")).click();
		return new AppLauncherPage();
	}
	
}
