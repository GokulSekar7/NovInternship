package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class HomePage extends ProjectSpecificMethod {

	@When ("Click on the app launcher")
	public void clickAppLauncher() {
		driver.findElement(By.className("slds-icon-waffle")).click();
	}
	
	@When ("Click on the view all button")
	public void clickViewAllBtn() {
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	}
	
}
