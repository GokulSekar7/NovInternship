package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.When;

public class WelcomePage extends ProjectSpecificMethod{

	@When ("Click on the {string} tab")
	public void clickTab(String tabName) {
		WebElement opportunitytab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='"+tabName+"']")));
		driver.executeScript("arguments[0].click();", opportunitytab);
	}
	
	
}
