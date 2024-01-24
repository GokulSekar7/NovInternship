package com.testcases.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LeadConversionAndOpportunityManagement {

static RemoteWebDriver driver;
static WebDriverWait wait;
Actions action;

	private static void click(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch (Exception e) {
			driver.executeScript("arguments[0].click();", ele);
		}
		
	}
	
	
	@Test
	public void runLeadConversionAndOpportunityManagement() {
		
//Login to Salesforce:
		String myName = "Walker";
		String myCname ="Qeagle";
		String myPhno = "9872478996";
		
		//Open the Salesforce login page: https://login.salesforce.com.
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		action = new Actions(driver);
		driver.get("https://login.salesforce.com/");
		
		//Enter valid credentials and log in.
		driver.findElement(By.id("username")).sendKeys("gokul.sekar@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@223");
		driver.findElement(By.id("Login")).click();
		
		
		
		
		//Navigate to Leads: 
		
		//Click on the toggle menu button in the left corner.
		driver.findElement(By.className("slds-icon-waffle")).click();
		
		//Select "View All" and click on the "Sales" app from the App Launcher.
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Navigate to the "Leads" tab.
		WebElement leadsTab = driver.findElement(By.xpath("//span[text()='Leads']"));
		click(leadsTab);
		
		
		
//Create a New Lead:
		
		//Click on the "New" button.
		WebElement newBtn = driver.findElement(By.xpath("//a[@title='New']"));
		click(newBtn);
		
		//Select salutation as 'Mr' or 'Ms'.
		WebElement salutationDD = driver.findElement(By.xpath("//button[contains(@aria-label,'Salutation')]"));
		click(salutationDD);
		WebElement mrSalutation = driver.findElement(By.xpath("//span[text()='Mr.']"));
		click(mrSalutation);
		
		//Enter the Last Name as 'Name using java faker' (Eg: Beast).
		String lname = "Beast";
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		lastName.sendKeys(lname);
		
		//Enter the CompanyName as 'Company name using java faker' (Eg: Testleaf).
		String cname = "Testleaf";
		WebElement companyName = driver.findElement(By.xpath("//input[@name='Company']"));
		companyName.sendKeys(cname);
		
		//Enter the title as 'QA'.
		String titleName = "QA";
		WebElement title = driver.findElement(By.xpath("//input[@name='Title']"));
		title.sendKeys(titleName);
		
		
		//Click "Save" and verify the lead name (salutation + lastName, e.g., Mr. Beast).
		WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		click(saveBtn);
		WebElement leadNameWE = driver.findElement(By.xpath("//*[@slot='primaryField']"));
		String leadName = leadNameWE.getText();
		if(leadName.contains(lname)) {
			System.out.println("Lead name "+leadName+" verified successfully");
		}else {
			System.out.println("Unable to verify the lead name "+leadName);
		}
		
		
		//Verify the title QA and Company details are correct.
		WebElement titleWE = driver.findElement(By.xpath("//p[text()='Title']/following::lightning-formatted-text"));
		String leadTitle = titleWE.getText();
		if(leadTitle.contains(titleName)) {
			System.out.println("Title "+titleName+" verified successfully");
		}else {
			System.out.println("Unable to verify the title "+titleName);
		}
		
		WebElement companyWE = driver.findElement(By.xpath("//p[text()='Company']/following::lightning-formatted-text"));
		String leadCompanyName = companyWE.getText();
		if(leadCompanyName.contains(cname)) {
			System.out.println("Company name "+cname+" verified successfully");
		}else {
			System.out.println("Unable to verify the company name "+cname);
		}
		
		
		
		
//Send an Email:
				
		//Click on the widget for the email.
		WebElement emailWidget = driver.findElement(By.xpath("//button[@title='Email']/following-sibling::*/button"));
		click(emailWidget);
		
		//Click 'Add email to do list'.
		WebElement emailToDoList = driver.findElement(By.xpath("//*[text()='Add Email to To Do List']/.."));
		click(emailToDoList);
		
		//Choose subject as 'Email'.
		WebElement subjectField = driver.findElement(By.xpath("//label[text()='Subject']/..//input"));
		click(subjectField);
		
		WebElement emailSubject = driver.findElement(By.xpath("//*[@data-value='Email']"));
		click(emailSubject);
		
		//Choose due date as 'Tomorrow date'.
		WebElement dueDate = driver.findElement(By.xpath("//label[text()='Due Date']/..//input"));
		click(dueDate);
		
		WebElement tommorrowDate = driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td"));
		click(tommorrowDate);
		
		//Click on the save button.
		saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
		
		
		
		
//Verify Sent Email: 

		//Click on the "Email" under the Activity tab.
		WebElement emailIcon = driver.findElement(By.xpath("//button[@aria-label='Email']"));
		click(emailIcon);
		
		//Enter the mail id into the 'To' field as 'LastName@companyName.com' (e.g.,Beast@Testleaf.com).
		WebElement toEmail = driver.findElement(By.xpath("//ul[@aria-label='To']//input"));
		toEmail.sendKeys(lname+"@"+cname+".com");
		
		//Enter the subject as 'Exploring Opportunities for "Company name"' (e.g.,Testleaf).
		emailSubject = driver.findElement(By.xpath("//input[@placeholder='Enter Subject...']"));
		emailSubject.sendKeys("'Exploring Opportunities for "+cname);
		
		//Clear the content and enter the specified information.
		String mailContent = "I'm "+myName+" from "+myCname+" . Noticed "+cname+" and thought we might have some exciting opportunities together. Can we set up a brief call to discuss?\r\n"
				+ "\r\n"
				+ "Best Regards.\r\n"
				+ myName+"\r\n"
				+ myPhno;
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='CK Editor Container']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Email Body']")));
		WebElement emailContent = driver.findElement(By.xpath("//body"));
		emailContent.clear();
		emailContent.sendKeys(mailContent);
		
		driver.switchTo().defaultContent();
		
		//Click on the "Send" button.
		WebElement sendBtn = driver.findElement(By.xpath("//span[text()='Send']/parent::button"));
		click(sendBtn);
		
		
		
		
//Change Email Status:
		
		//Click on the widget for 'Email" under 'upcoming & overdue'.
		WebElement upcomingMailWidget = driver.findElement(By.xpath("//button[@title='Upcoming & Overdue']/following::span[text()='Show more actions']/../.."));
		click(upcomingMailWidget);
		
		//Click on the "Change Status".
		WebElement changeStatusWE = driver.findElement(By.xpath("//div[@title='Change Status' and @role='button']/parent::a"));
		click(changeStatusWE);
		
		//Change the status to completed.
		WebElement changeStatusDD = driver.findElement(By.xpath("//a[@class='select']"));
		click(changeStatusDD);
		
		WebElement completedValue = driver.findElement(By.xpath("//a[text()='Completed']"));
		click(completedValue);
		
		//Click on the save button.
		saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
		
		driver.close();
				
	}
	
}
