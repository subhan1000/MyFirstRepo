

Feature: Implemeting the User menu dropdown functionality

Background:

		Given the url is "https://login.salesforce.com/"
    When I goto "LoginPage"
    When I enter the username "shubhashree.mallick647@agentforce.com"
    And I enter the password "Test@123"
    When I click login button
    When I goto "HomePage"

  Scenario: UserMenu List Verification   
    
    Then 	click on the user menu tab
    And I should be able to view user menu names

  Scenario: Select Logout option from user menu
  
    Then 	click on the user menu tab
  	Then i click the logout link
  	
  Scenario: Select Developers Console option from user menu 
    
    Then 	click on the user menu tab
    Then click on the developer console option
    And click on the close button for developer console window
    
    
    
    
    
    
    
    
    
    
    
    
    