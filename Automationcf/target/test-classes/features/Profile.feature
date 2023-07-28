Feature: Pricing setup

Scenario: Login to the application
Given open the Chrome browser and goto the toucan website
Then Login to the application
| lavanya | Password@123 |
When Go to the profile
Then Go to pricing 
And Change MDR to 3%
