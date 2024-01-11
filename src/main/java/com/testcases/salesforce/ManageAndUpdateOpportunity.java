package com.testcases.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class ManageAndUpdateOpportunity  extends ProjectSpecificMethods{
//	static ChromeDriver driver;
	private static void click(WebElement ele) {
		try {
			ele.click();

		} catch (Exception e) {
			driver.executeScript("arguments[0].click();", ele);
		}
	}
	

	/*public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@223");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement opportunitiesTab = driver.findElement(By.xpath("//span[text()='Opportunities']/.."));
		click(opportunitiesTab);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder,'Search')]")));
		WebElement opportunitySearch = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
		opportunitySearch.sendKeys("Testleaf"+Keys.ENTER);
		opportunitySearch.sendKeys(Keys.ENTER);
		try {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		} catch (Exception e1) {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		}
		WebElement newTaskIcon = driver.findElement(By.xpath("//h2[text()='Activity Publisher']/..//span[text()='New Task']/.."));
		click(newTaskIcon);
		WebElement subjectDD = driver.findElement(By.xpath("//label[text()='Subject']/..//input"));
		click(subjectDD);
		WebElement emailValue = driver.findElement(By.xpath("//label[text()='Subject']/..//span[text()='Email']/../.."));
		click(emailValue);
		WebElement dateIcon = driver.findElement(By.xpath("//span[text()='Select a date for Due Date']/parent::button"));
		click(dateIcon);
		WebElement nextDayDate = driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td"));
		click(nextDayDate);
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
		WebElement emailIcon = driver.findElement(By.xpath("//h2[text()='Activity Publisher']/..//span[text()='Email']/.."));
		click(emailIcon);
		driver.findElement(By.xpath("//span[text()='To']/../..//input")).sendKeys("walker@testleaf.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Subject')]")).sendKeys("Exploring Opportunities for Qeagle");
		driver.switchTo().frame(0);
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@title='Email Body']"));
		driver.switchTo().frame(innerFrame);
		WebElement emailContent = driver.findElement(By.tagName("body"));
		emailContent.clear();
		emailContent.sendKeys("Hi Walker,\r\n"
				+ "\r\n"
				+ "I'm Gokul from Testleaf . Noticed Qeagle and thought we might have some exciting opportunities together. Can we set up a brief call to discuss?");
		driver.switchTo().defaultContent();
		WebElement sendBtn = driver.findElement(By.xpath("//span[text()='Send']/.."));
		click(sendBtn);
		try {
			driver.findElement(By.xpath("//*[text()='Review the errors on this page.']"));
			WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']/.."));
			click(closeBtn);
		} catch (Exception e) {
			
		}
		
		WebElement widgetBtn = driver.findElement(By.xpath("//span[text()='Show more actions']/ancestor::a"));
		click(widgetBtn);
		WebElement changeStatus = driver.findElement(By.xpath("//div[text()='Change Status']/.."));
		click(changeStatus);
		WebElement statusDD = driver.findElement(By.xpath("//span[text()='Status']/following::a"));
		click(statusDD);
		WebElement completedOption = driver.findElement(By.xpath("//a[text()='Completed']")); 
		click(completedOption);
		saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
		driver.close();
		
	}*/

	@Test
	public void runManageAndUpdateOpportunity() {
		Faker faker =  new Faker();
		firstName = faker.name().firstName();
		String cname = faker.company().name();
		
		WebElement opportunitiesTab = driver.findElement(By.xpath("//span[text()='Opportunities']/.."));
		click(opportunitiesTab);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder,'Search')]")));
		WebElement opportunitySearch = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
		opportunitySearch.sendKeys("Testleaf"+Keys.ENTER);
		opportunitySearch.sendKeys(Keys.ENTER);
		try {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		} catch (Exception e1) {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		}
		WebElement newTaskIcon = driver.findElement(By.xpath("//h2[text()='Activity Publisher']/..//span[text()='New Task']/.."));
		click(newTaskIcon);
		WebElement subjectDD = driver.findElement(By.xpath("//label[text()='Subject']/..//input"));
		click(subjectDD);
		WebElement emailValue = driver.findElement(By.xpath("//label[text()='Subject']/..//span[text()='Email']/../.."));
		click(emailValue);
		WebElement dateIcon = driver.findElement(By.xpath("//span[text()='Select a date for Due Date']/parent::button"));
		click(dateIcon);
		WebElement nextDayDate = driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td"));
		click(nextDayDate);
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
		WebElement emailIcon = driver.findElement(By.xpath("//h2[text()='Activity Publisher']/..//span[text()='Email']/.."));
		click(emailIcon);
		driver.findElement(By.xpath("//span[text()='To']/../..//input")).sendKeys("walker@testleaf.com");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Subject')]")).sendKeys("Exploring Opportunities for Qeagle");
		driver.switchTo().frame(0);
		WebElement innerFrame = driver.findElement(By.xpath("//iframe[@title='Email Body']"));
		driver.switchTo().frame(innerFrame);
		WebElement emailContent = driver.findElement(By.tagName("body"));
		emailContent.clear();
		emailContent.sendKeys("Hi Walker,\r\n"
				+ "\r\n"
				+ "I'm Gokul from Testleaf . Noticed Qeagle and thought we might have some exciting opportunities together. Can we set up a brief call to discuss?");
		driver.switchTo().defaultContent();
		WebElement sendBtn = driver.findElement(By.xpath("//span[text()='Send']/.."));
		click(sendBtn);
		try {
			driver.findElement(By.xpath("//*[text()='Review the errors on this page.']"));
			WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']/.."));
			click(closeBtn);
		} catch (Exception e) {
			
		}
		
		WebElement widgetBtn = driver.findElement(By.xpath("//span[text()='Show more actions']/ancestor::a"));
		click(widgetBtn);
		WebElement changeStatus = driver.findElement(By.xpath("//div[text()='Change Status']/.."));
		click(changeStatus);
		WebElement statusDD = driver.findElement(By.xpath("//span[text()='Status']/following::a"));
		click(statusDD);
		WebElement completedOption = driver.findElement(By.xpath("//a[text()='Completed']")); 
		click(completedOption);
		saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
	}
	
	
}
