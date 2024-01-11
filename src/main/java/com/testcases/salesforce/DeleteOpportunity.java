package com.testcases.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteOpportunity {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@223");
		driver.findElement(By.id("Login")).click();
		
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		
		WebElement viewAllBtn = driver.findElement(By.xpath("//button[text()='View All']"));
		
		try {
			viewAllBtn.click();

		} catch (StaleElementReferenceException e) {
			driver.findElement(By.className("slds-icon-waffle")).click();
			viewAllBtn = driver.findElement(By.xpath("//button[text()='View All']"));
			viewAllBtn.click();
		}
		driver.findElement(By.xpath("//p[text()='Sales']")).click();	
		WebElement opportunitytab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@title='Opportunities']")));
		driver.executeScript("arguments[0].click();", opportunitytab);
		
		WebElement searchBar = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
		searchBar.sendKeys("Testleaf"+Keys.ENTER);
		searchBar.sendKeys(Keys.ENTER);
		WebElement widgetDD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody//td[8]")));
		try {
			widgetDD.click();

		} catch (StaleElementReferenceException e) {
			widgetDD = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody//td[8]")));
			widgetDD.click();
			
		}catch (Exception e) {
			driver.executeScript("arguments[0].click();", widgetDD);
		}
		
		WebElement WidgetDeleteBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@title='Delete']/parent::a")));
		
		try {
			WidgetDeleteBtn.click();

		} catch (Exception e) {
			driver.executeScript("arguments[0].click();", WidgetDeleteBtn);
		}
		
		WebElement deleteBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Delete']")));
		try {
			deleteBtn.click();

		} catch (Exception e) {
			driver.executeScript("arguments[0].click();", deleteBtn);
		}
		
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@id,'toastDescription')]")));
		
		driver.close();
	}

}
