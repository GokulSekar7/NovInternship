Feature: Login functionality

Scenario: Salesforce login with valid credential

#Given Launch the browser
And Load the url
And Enter the username as 'gokul.sekar@testleaf.com'
And Enter the password as 'Leaf@223'
When Click on the login button
Then Verify the login successfully

Scenario: Salesforce login with Invalid credential

#Given Launch the browser
And Load the url
And Enter the username as 'gokul.sekar@leaf.com'
And Enter the password as 'Java@223'
When Click on the login button
But Verify the login successfully