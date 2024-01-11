package com.testcases.salesforce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ManageProducts extends ProjectSpecificMethods{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// Disable notification
					ChromeOptions options=new ChromeOptions();
					options.addArguments("--disable-notifications");
					
					//Launch the URL
					ChromeDriver driver=new ChromeDriver(options);
					Actions act=new Actions(driver);
					driver.get("https://login.salesforce.com");
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
					
					//Login into the salesforce account using valid username and password
					driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
					driver.findElement(By.id("password")).sendKeys("Leaf@223");
					driver.findElement(By.id("Login")).click();
					
					//Click on toggle menu
					driver.findElement(By.className("slds-icon-waffle")).click();
					
					//Click on view all
					WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
					driver.findElement(By.xpath("//button[text()='View All']")).click();
					
					//Click on Sales
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Sales']")));
			       	WebElement sales=driver.findElement(By.xpath("//p[text()='Sales']"));
					driver.executeScript("arguments[0].click();",sales);
					
					//Click on Opportunities
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Opportunities']")));
					WebElement opportunity=driver.findElement(By.xpath("//a[@title='Opportunities']"));
					driver.executeScript("arguments[0].click();", opportunity);
					
					//Enter the opportunity name in the search box
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Opportunity-search-input']")));
					driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Next",Keys.ENTER);
					
					//Click on the opportunity
					//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate outputLookupLink-0065i00000IqhyhAAB-4403:0 forceOutputLookup']")));
					Thread.sleep(3000);
					WebElement searchOpp=driver.findElement(By.xpath("(//tr/th/span/a)[1]"));
					driver.executeScript("arguments[0].click();", searchOpp);
					
					boolean WCFound=false;
					try {
						WCFound= driver.findElement(By.xpath("//a[@title='Qualification']")).isDisplayed();
					} catch(Exception e) {
						System.out.println(e);
						
					}
					System.out.println(WCFound);
					
					//Click on Mark as complete if not complete
					if (!WCFound) {
						
						WebElement markAs=driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-check stepActionIcon slds-button__icon slds-button__icon--left slds-icon_container']"));
						driver.executeScript("arguments[0].click();", markAs);
				        
					}
					
					//Click on Product widget
					driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]")).click();
					
					//Click on Choose price book
					driver.findElement(By.xpath("//a[@title='Choose Price Book']")).click();
					
					//Select on standard
					WebElement stand=driver.findElement(By.xpath("//a[text()='Standard']"));
					driver.executeScript("arguments[0].click();", stand);
					//driver.findElement(By.xpath("//a[@title='Standard']")).click();
					
					//Click on Save
					driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']")).click();
					
					//Choose Add products
					driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]")).click();
					driver.findElement(By.xpath("//a[@title='Add Products']")).click();
					
					//Search SLA
//					driver.findElement(By.xpath("//input[@title='Search Products']")).click();
					WebElement searchBar = driver.findElement(By.xpath("//input[@title='Search Products']"));
					searchBar.sendKeys("SLA"+Keys.ENTER);
					driver.findElement(By.xpath("//span[contains(text(),'in Products')]/..")).click();
					driver.findElement(By.xpath("//h2[text()='Add Products']")).click();
					
//					wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@title='Search Products']")));
					Thread.sleep(2000);
					WebElement selectAll = driver.findElement(By.xpath("(//table)[2]/thead//th[2]"));
					try {
						selectAll.click();
					} catch (Exception e) {
						driver.executeScript("argments[0].click();", selectAll);
					}
					
					driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
					driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td")).sendKeys("1");
					driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td")).sendKeys("2");
					driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td")).sendKeys("5");
					driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td")).sendKeys("10");
					
					driver.findElement(By.xpath("(//span[text()='Save']/parent::button)[2]")).click();
					
					driver.findElement(By.xpath("(//span[text()='Products']/..)[2]")).click();
					
					List<WebElement> productsList = driver.findElements(By.xpath("(//table)[2]/tbody//td[6]"));
					for (int i = 1; i <=productsList.size(); i++) {
						Thread.sleep(1000);
						driver.findElement(By.xpath("((//table)[2]/tbody//td[6])["+i+"]")).click();
						driver.findElement(By.xpath("(//div[text()='Edit'])[2]")).click();
						String productName = driver.findElement(By.xpath("//span[text()='Product']/following::span[@class='uiOutputText']")).getText();
						String productCode = driver.findElement(By.xpath("//span[text()='Product Code']/following::span[@class='uiOutputText']")).getText();
						System.out.println(productName +" : "+ productCode);
						driver.findElement(By.xpath("//span[text()='Close this window']/parent::button")).click();
					}
					
//					searchBar.sendKeys(Keys.ENTER);
//					driver.findElement(By.xpath("//input[@title='Search Products']")).click();
//					searchBar.click();
//					try {
//						driver.findElement(By.xpath("//span[contains(text(),'in Products')]/..")).click();
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					driver.findElement(By.xpath("(//*[@icon-name='utility:search'])[2]//*[name()='svg']")).click();
					

	
	}
	
	
	@Test
	public void runManageProducts() {
		System.out.println(firstName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Opportunities']")));
		WebElement opportunity=driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click();", opportunity);
		
		//Enter the opportunity name in the search box
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Opportunity-search-input']")));
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Next",Keys.ENTER);
		
		//Click on the opportunity
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='slds-truncate outputLookupLink slds-truncate outputLookupLink-0065i00000IqhyhAAB-4403:0 forceOutputLookup']")));
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement searchOpp=driver.findElement(By.xpath("(//tr/th/span/a)[1]"));
		driver.executeScript("arguments[0].click();", searchOpp);
		
		boolean WCFound=false;
		try {
			WCFound= driver.findElement(By.xpath("//a[@title='Qualification']")).isDisplayed();
		} catch(Exception e) {
			System.out.println(e);
			
		}
		System.out.println(WCFound);
		
		//Click on Mark as complete if not complete
		if (!WCFound) {
			
			WebElement markAs=driver.findElement(By.xpath("//lightning-icon[@class='slds-icon-utility-check stepActionIcon slds-button__icon slds-button__icon--left slds-icon_container']"));
			driver.executeScript("arguments[0].click();", markAs);
	        
		}
		
		//Click on Product widget
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]")).click();
		
		//Click on Choose price book
		driver.findElement(By.xpath("//a[@title='Choose Price Book']")).click();
		
		//Select on standard
		WebElement stand=driver.findElement(By.xpath("//a[text()='Standard']"));
		driver.executeScript("arguments[0].click();", stand);
		//driver.findElement(By.xpath("//a[@title='Standard']")).click();
		
		//Click on Save
		driver.findElement(By.xpath("//button[@class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton']")).click();
		
		//Choose Add products
		driver.findElement(By.xpath("(//a[@class='slds-button slds-button--icon-x-small slds-button--icon-border-filled'])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Add Products']")).click();
		
		//Search SLA
//		driver.findElement(By.xpath("//input[@title='Search Products']")).click();
		WebElement searchBar = driver.findElement(By.xpath("//input[@title='Search Products']"));
		searchBar.sendKeys("SLA"+Keys.ENTER);
		driver.findElement(By.xpath("//span[contains(text(),'in Products')]/..")).click();
		
		WebElement selectAll = driver.findElement(By.xpath("(//table)[2]/thead//th[2]"));
		try {
			selectAll.click();
		} catch (Exception e) {
			driver.executeScript("argments[0].click();", selectAll);
		}
		
		driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
		driver.findElement(By.xpath("//a[text()='SLA: Platinum']/ancestor::th/following-sibling::td")).sendKeys("1");
		driver.findElement(By.xpath("//a[text()='SLA: Gold']/ancestor::th/following-sibling::td")).sendKeys("2");
		driver.findElement(By.xpath("//a[text()='SLA: Silver']/ancestor::th/following-sibling::td")).sendKeys("5");
		driver.findElement(By.xpath("//a[text()='SLA: Bronze']/ancestor::th/following-sibling::td")).sendKeys("10");
		
		driver.findElement(By.xpath("(//span[text()='Save']/parent::button)[2]")).click();
		
		driver.findElement(By.xpath("(//span[text()='Products']/..)[2]")).click();
		
		List<WebElement> productsList = driver.findElements(By.xpath("(//table)[2]/tbody//td[6]"));
		for (int i = 1; i <=productsList.size(); i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("((//table)[2]/tbody//td[6])["+i+"]")).click();
			driver.findElement(By.xpath("(//div[text()='Edit'])[2]")).click();
			String productName = driver.findElement(By.xpath("//span[text()='Product']/following::span[@class='uiOutputText']")).getText();
			String productCode = driver.findElement(By.xpath("//span[text()='Product Code']/following::span[@class='uiOutputText']")).getText();
			System.out.println(productName +" : "+ productCode);
			driver.findElement(By.xpath("//span[text()='Close this window']/parent::button")).click();
		}
	}
	
}
