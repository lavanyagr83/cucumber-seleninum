Feature: Login application

Scenario: Home page login
Given user is on landing page
When user login into the application with username and password
Then Home page is populated
And cards are displayed