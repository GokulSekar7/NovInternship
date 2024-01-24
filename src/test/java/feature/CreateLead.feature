Feature: Create Lead

@Positive @Lead @Functional
Scenario Outline: Salesforce login with valid credential

Given Load the url
And Enter the username as gokul.sekar@testleaf.com
And Enter the password as 'Leaf@123'
When Click on the login button
Then Verify the login successfully
When Click on the app launcher
And Click on the view all button
And Click on sales
And Click on the 'Leads' tab
And Click on the 'New' button
Given Select salutation as <salutation value>
And Enter the Last Name as <last name>
And Enter the CompanyName as <company name>
And Enter the title as <title>
When Click 'Save' button


Examples:
|salutation value|last name|company name|title|
|Mr|Sekar|Testleaf|QA|
|Mr|Babu|Qeagle|CEO|
|Mr|Hari|Qeagle|VP|
