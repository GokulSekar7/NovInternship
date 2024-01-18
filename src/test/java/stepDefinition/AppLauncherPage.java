package stepDefinition;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class AppLauncherPage extends ProjectSpecificMethod {

	@When ("Click on sales")
	public void clickSales() {
		getDriver().findElement(By.xpath("//p[text()='Sales']")).click();	
		
	}
	
}
