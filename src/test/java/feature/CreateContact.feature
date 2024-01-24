Feature: Create Contact

@Positive @Login @Smoke @Contacts
Scenario: Salesforce login with valid credential

Given Load the url
And Enter the username as gokul.sekar@testleaf.com
And Enter the password as 'Leaf@123'
When Click on the login button
Then Verify the login successfully
When Click on the app launcher
And Click on the view all button
And Click on sales
And Click on the 'Contacts' tab