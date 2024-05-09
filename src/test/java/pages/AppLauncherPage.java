package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import base.BaseClass;
import io.cucumber.java.en.When;

public class AppLauncherPage extends BaseClass {

	
	
	
	@When ("Click on sales")
	public WelcomePage clickSales() {
		getDriver().findElement(By.xpath("//p[text()='Sales']")).click();	
		return new WelcomePage();
	}
	
}
