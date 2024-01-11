package com.testcases.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SalesforceNavigationAndLeadInteraction {


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
	
	
	@Test(dependsOnMethods = "com.testcases.salesforce.LeadConversionAndOpportunityManagement.runLeadConversionAndOpportunityManagement")
	public void runSalesforceNavigationAndLeadInteraction() {
		
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
		
	
		
		
		
		
//Search and Open Existing Lead:
		
		//Search for the existing lead.
		WebElement leadSearchBar = driver.findElement(By.xpath("//input[@name='Lead-search-input']"));
		leadSearchBar.sendKeys("Beast"+Keys.ENTER);
		leadSearchBar.sendKeys(Keys.ENTER);
		
		//Open the lead.
		WebElement firstResultingLead = driver.findElement(By.xpath("//table/tbody//th//a"));
		try {
			click(firstResultingLead);
		} catch (Exception e1) {
			firstResultingLead = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstResultingLead);
		}
		
		
		
//Update Lead Status:
		
		//Click on the "Details" tab.
		WebElement detailsTab = driver.findElement(By.xpath("//a[@id='detailTab__item']"));
		click(detailsTab);
		
		//Click on the edit icon for the lead status.
		WebElement currentGenerator = driver.findElement(By.xpath("//span[text()='Current Generator(s)']"));
		action.moveToElement(currentGenerator).perform();
		
		WebElement leadStatusEditIcon = driver.findElement(By.xpath("//span[text()='Edit Lead Status']/parent::button"));
		click(leadStatusEditIcon);
		try {
			click(leadStatusEditIcon);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		//Change the lead status to 'Working - Contacted'.
		WebElement leadStatusDD = driver.findElement(By.xpath("//button[contains(@aria-label,'Lead Status')]"));
		click(leadStatusDD);
		
		WebElement workingContactedValue = driver.findElement(By.xpath("//*[@data-value='Working - Contacted']"));
		click(workingContactedValue);
		
		//Click on the save button.
		WebElement saveBtn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		click(saveBtn);
		try {
			click(saveBtn);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		

		
		
		
		
//Mark Status as Complete (if not marked):
		
		//Check if 'Working - Contacted' is marked as completed.
		WebElement workingContacted = driver.findElement(By.xpath("//a[@data-tab-name='Working - Contacted']"));
		String workingContactedStatus = workingContacted.getAttribute("aria-selected");
		if(workingContactedStatus.equalsIgnoreCase("true")) {
			
			//If not, click on 'Mark status as complete'.
			WebElement markAsComplete = driver.findElement(By.xpath("//span[text()='Mark Status as Complete']/.."));
			click(markAsComplete);
			
		}
		
		

		
		
		
		
//Convert Lead to Opportunity:
		
		
		//Click on the widget near 'Submit for Approval'.
		WebElement widgetForLead = driver.findElement(By.xpath("//span[text()='Show more actions']/parent::button"));
		click(widgetForLead);
		
		//Click on the "Convert" button.
		WebElement convertOption = driver.findElement(By.xpath("//span[text()='Convert']/.."));
		click(convertOption);
		
		WebElement convertBtn = driver.findElement(By.xpath("//button[text()='Convert']/.."));
		click(convertBtn);
		
		//Close the pop-up window.
		WebElement closeWindow = driver.findElement(By.xpath("//span[text()='Close this window']/.."));
		click(closeWindow);
		
		
		
		
		
//Verify Opportunity Details:
		
		//Navigate to the "Opportunities" tab.
		WebElement opportunitiesTab = driver.findElement(By.xpath("//span[text()='Opportunities']/.."));
		click(opportunitiesTab);
		
		//Search for the opportunity by the company name converted from the lead.
		WebElement opportunitySearchBar = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		opportunitySearchBar.sendKeys("Testleaf"+Keys.ENTER);
		opportunitySearchBar.sendKeys(Keys.ENTER);
		
		//Open the opportunity.
		WebElement firstResultingOpportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
		try {
			click(firstResultingOpportunity);
		} catch (Exception e1) {
			firstResultingOpportunity = driver.findElement(By.xpath("//table/tbody//th//a"));
			click(firstResultingOpportunity);
		}
		
		//Verify the account name (company name from the lead) at the top left.
		WebElement accountNameWE = driver.findElement(By.xpath("//p[text()='Account Name']/..//button/span"));
		String accountName = accountNameWE.getText();
		if(accountName.contains("Testleaf")) {
			System.out.println("Account name Testleaf verified successfully");
		}else {
			System.out.println("Unable to verify the account name as Testleaf");
		}
		
		//Verify contact at the right bottom (contact name is the lead name).
		WebElement contactNameWE = driver.findElement(By.xpath("//img[@title='Contact']/following::a"));
		String contactName = contactNameWE.getText();
		if(contactName.contains("Beast")) {
			System.out.println("Contact name Beast verified successfully");
		}else {
			System.out.println("Unable to verify the contact name as Beast");
		}
		
		
		
		
		
		
//Create a New Task:
		
		//Click on the "New Task" icon.
		WebElement newTaskIcon = driver.findElement(By.xpath("(//button[@aria-label='New Task'])[2]"));
		click(newTaskIcon);
		
		//Choose the subject as "Other".
		WebElement subjectField = driver.findElement(By.xpath("//label[text()='Subject']/..//input"));
		click(subjectField);
		
		WebElement otherSubject = driver.findElement(By.xpath("//*[@data-value='Other']"));
		click(otherSubject);
		
		//Enter the due date as tomorrow.
		WebElement dueDate = driver.findElement(By.xpath("//label[text()='Due Date']/..//input"));
		click(dueDate);
		
		WebElement tommorrowDate = driver.findElement(By.xpath("//td[@class='slds-is-today']/following-sibling::td"));
		click(tommorrowDate);
		
		//Click on the save button.
		saveBtn = driver.findElement(By.xpath("(//span[text()='Save']/..)[3]"));
		click(saveBtn);
		
		
		
		
		
		
//Upload Sample File:
		
		//Upload a sample file under "Notes and Attachments."
		WebElement uploadFiles = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFiles.sendKeys(System.getProperty("user.dir")+"/files/dummy.pdf");
		
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@variant='success']")));
		WebElement doneBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Done']/parent::button")));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			 
		}
		action.sendKeys(Keys.ENTER).perform();
		
		//Verify the file name under "Notes and Attachments."
		WebElement fileNameWE = driver.findElement(By.xpath("//div[@class='filerow']//span[contains(@class,'itemTitle')]"));
		String fileName = fileNameWE.getAttribute("title");
		if(fileName.contains("dummy")) {
			System.out.println("file name dummy verified successfully");
		}else {
			System.out.println("Unable to verify the file name as dummy");
		}
		
		
		
		
	
		
		
//Update Opportunity Stage:
			
		//Click on the "Details" tab.
		detailsTab = driver.findElement(By.xpath("(//a[text()='Details'])[2]"));
		click(detailsTab);
		try {
			click(detailsTab);
		} catch (Exception e) {
			detailsTab = driver.findElement(By.xpath("//a[@id='detailTab__item']"));
			click(detailsTab);
		}
		
		//Click on the stage icon for the stage dropdown.
		WebElement primaryCampaign = driver.findElement(By.xpath("//span[text()='Primary Campaign Source']"));
		action.moveToElement(primaryCampaign).perform();
		
		WebElement stageEditIcon = driver.findElement(By.xpath("//button[@title='Edit Stage']"));
		click(stageEditIcon);
		
		//Change the stage to "Needs Analysis."
		WebElement stageDD = driver.findElement(By.xpath("//button[contains(@aria-label,'Stage')]"));
		click(stageDD);
		
		WebElement needAnalysisValue = driver.findElement(By.xpath("//*[@data-value='Needs Analysis']"));
		click(needAnalysisValue);
		
		//Enter the description as "Attachments uploaded successfully."
		String descriptionContent = "Attachments uploaded successfully";
		WebElement description = driver.findElement(By.xpath("//textarea[@class='slds-textarea']"));
		description.clear();
		description.sendKeys(descriptionContent);
		
		// Click on the save button.
		saveBtn = driver.findElement(By.xpath("//button[@name='SaveEdit']"));
		click(saveBtn);
		
		
		
		
		
		
		
//Verify Stage Completion:
		
		//Check if "Needs Analysis" is marked as completed.
		WebElement needAnalysisWE = driver.findElement(By.xpath("//a[@data-tab-name='Needs Analysis']"));
		String needAnalysisStatus = needAnalysisWE.getAttribute("aria-selected");
		if(needAnalysisStatus.equalsIgnoreCase("true")) {
			//If not, click on "Mark stage as complete."
			WebElement markAsComplete = driver.findElement(By.xpath("//span[text()='Mark Stage as Complete']/.."));
			click(markAsComplete);
		}
		
		driver.close();
	}
	
	
}
