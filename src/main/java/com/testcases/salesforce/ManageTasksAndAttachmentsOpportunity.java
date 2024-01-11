package com.testcases.salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class ManageTasksAndAttachmentsOpportunity extends ProjectSpecificMethods {
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
		Actions action = new Actions(driver);
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
		opportunitySearch.sendKeys("TL"+Keys.ENTER);
		opportunitySearch.sendKeys(Keys.ENTER);
		try {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		} catch (Exception e1) {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		}
//		WebElement uploadBtn = driver.findElement(By.xpath("//span[text()='Notes & Attachments']/following::span[@part='button']"));
//		click(uploadBtn);
//		
//		try {
//			Runtime.getRuntime().exec("C:/driver(D)/salesforce.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"/files/dummy.pdf");
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@variant='success']")));
		WebElement doneBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Done']/parent::button")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
//		click(doneBtn);
		action.sendKeys(Keys.ENTER).perform();
	}*/
	
	
	@Test
	public void runManageTasksAndAttachmentsOpportunity() {
		System.out.println(firstName);
		WebElement opportunitiesTab = driver.findElement(By.xpath("//span[text()='Opportunities']/.."));
		click(opportunitiesTab);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@placeholder,'Search')]")));
		WebElement opportunitySearch = driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"));
		opportunitySearch.sendKeys("TL"+Keys.ENTER);
		opportunitySearch.sendKeys(Keys.ENTER);
		try {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		} catch (Exception e1) {
			WebElement firstopportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstopportunity);
		}
//		WebElement uploadBtn = driver.findElement(By.xpath("//span[text()='Notes & Attachments']/following::span[@part='button']"));
//		click(uploadBtn);
//		
//		try {
//			Runtime.getRuntime().exec("C:/driver(D)/salesforce.exe");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"/files/dummy.pdf");
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@variant='success']")));
		WebElement doneBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Done']/parent::button")));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
//		click(doneBtn);
		action.sendKeys(Keys.ENTER).perform();
	}

}
