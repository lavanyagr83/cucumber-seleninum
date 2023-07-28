Feature: Search and place the order for products

Scenario: User can seacrch the product in the home page and offers page
Given User is on GreenCart  Landing Page
When user searched with short name "Tom" and extract actual product
Then user go and search with same short name in offers page if product exist
And Verify the homePageProductName and OffersPageProductName are same