

Feature: Implemeting the login functionality

Background:
		Given the url "https://login.salesforce.com/"
    When I land in "LoginPage"
    When I enter the username as "shubhashree.mallick647@agentforce.com"
   
    
  Scenario: Successful login
  
    And I enter the password as "Test@123"
    When I click the login button
    When I land in "HomePage"
    Then I should be able to see the home page

  Scenario: RememberMe login
  
   
    And I enter the password as "Test@123"
    When I click the remember me check box
    When I click the login button
     When I land in "HomePage"
    Then 	click on the user menu
    Then click the logout link
   
  Scenario: Test forgot password  
	
		When I click the forgot password link
     When I land in "ForgotpasswordPage"
     When I enter the user mail-id as "shubhashree.mallick@gmail.com"
    Then 	click on the continue button
  	Then click on the return to login button
    
    
    Scenario: Validate Login Errormsg   
    
    And I enter the password as "Test"    
    When I click the login button
    Then I should be able to see the login error message "Please check your username and password. If you still can't log in, contact your Salesforce administrator."
   

    Scenario: Password Error msg
   
    And I enter the password as ""    
    When I click the login button
    Then I should be able to see the password error message "Please enter your password."
   
    
    
    
    
    