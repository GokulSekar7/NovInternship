package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LeadsPage extends ProjectSpecificMethod {

	
	@When ("Click on the {string} button")
	public void clickNewBtn(String text) {
		WebElement newBtn = getDriver().findElement(By.xpath("//a[@title='"+text+"']"));
		click(newBtn);
	}
	
	//(.*)$   --> object, any string/text
	@Given ("Select salutation as (.*)$")
	public void selectSalutation(String text) {
		WebElement salutationDD = getDriver().findElement(By.xpath("//button[contains(@aria-label,'Salutation')]"));
		click(salutationDD);
		WebElement mrSalutation = getDriver().findElement(By.xpath("//span[text()='"+text+".']"));
		click(mrSalutation);
	}
	
	@Given ("Enter the Last Name as (.*)$")
	public void enterLastName(String lname) {
		WebElement lastName = getDriver().findElement(By.xpath("//input[@name='lastName']"));
		lastName.sendKeys(lname);
	}
	
	
	@Given ("Enter the CompanyName as (.*)$")
	public void enterCname(String cname) {
		WebElement companyName = getDriver().findElement(By.xpath("//input[@name='Company']"));
		companyName.sendKeys(cname);
		
	}
	
	@Given ("Enter the title as (.*)$")
	public void enterTitle(String title) {
		WebElement titleWE = getDriver().findElement(By.xpath("//input[@name='Title']"));
		titleWE.sendKeys(title);
	}
	
	@When ("Click {string} button")
	public void clickSaveBtn(String text) {
		WebElement saveBtn = getDriver().findElement(By.xpath("//button[text()='"+text+"']"));
		click(saveBtn);
	}
}
