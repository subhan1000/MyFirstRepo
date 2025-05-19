package com.Automation.StepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Page.ForgotPasswordPage;
import com.Automation.Page.HomePage;
import com.Automation.Page.LoginPage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefination{
	
	protected static WebDriver driver = null;
	
	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	 LoginPage Lpage;
	 HomePage Hpage;
	 ForgotPasswordPage forgotPage;
	
	
public static void LaunchBrowser(String browserName) {
		
		switch (browserName.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new  ChromeDriver();
			break;			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;			
		default:
			System.out.println("Invalid browser.");
			break;				
		}		
	}

	public static void GoToUrl(String url) throws Exception  {
		
		driver.get(url);
		
	}
	
	public void CloseDriver() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.close();
		
	}
	@Before
	public void BeforeScenario() {
		LaunchBrowser("chrome");
	}
	
	@After
	public void AfterScenario() throws InterruptedException {
		CloseDriver();
	}
	//======================================================================================
	
	@Given("the url {string}")
	public void the_url(String url) throws Exception {
		GoToUrl(url);
	}
	
	@When("I land in {string}")
	public void i_land_in(String page) {
	    if(page.equalsIgnoreCase("loginpage")) {
	    	Lpage = new LoginPage(driver);}
	    
	    else if(page.equalsIgnoreCase("homepage")) {
	    	Hpage = new HomePage(driver);}
	    else if(page.equalsIgnoreCase("forgotpasswordpage")) {
	    	forgotPage = new ForgotPasswordPage(driver);
	    }
	    
	    }
	
	
	
	@When("I enter the username as {string}")
	public void i_enter_the_username_as(String usernameData) {
		Lpage.enterUserName(usernameData);
	}
	@When("I enter the password as {string}")
	public void i_enter_the_password_as(String passwordData) {
		Lpage.enterPassword(passwordData);
	}
	
	@When("I click the login button")
	public void i_click_the_login_button() {
		Lpage.clickLoginButton();
	}

	@Then("I should be able to see the home page")
	public void i_should_be_able_to_see_the_home_page() {
	   System.out.println("Home Page");
	}
		
	
	@When("I click the remember me check box")
	public void i_click_the_remember_me_check_box() {
		Lpage.remembermeCheckbox();
	}

	@Then("click on the user menu")
	public void click_on_the_user_menu() throws InterruptedException {
		Thread.sleep(2000);
		Hpage.UserMenu();
		
	}

	@Then("click the logout link")
	public void click_the_logout_link() {
		Hpage.LogOut();
	}
	@When("I enter the user mail-id as {string}")
	public void i_enter_the_user_mail_id_as(String username_emailId) {
		forgotPage.enterUsermailId(username_emailId);
	}

	@When("I click the forgot password link")
	public void i_click_the_forgot_password_link() {
		Lpage.clickforgotPasswordLink();
	}
	@Then("click on the continue button")
	public void click_on_the_continue_button() {
		forgotPage.clickContiueButton(); 
	}
	@Then("click on the return to login button")
	public void click_on_the_return_to_login_button() throws InterruptedException {
		forgotPage.ReturnLoginButton();
		
	}
	
	@Then("I should be able to see the login error message {string}")
	public void i_should_be_able_to_see_the_login_error_message(String string) {
	   
		String expected_errorMsg = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		
		 String actual_errorMsg = Lpage.getTextFromErrorMsg1();
		 Assert.assertEquals(actual_errorMsg, expected_errorMsg);
	}

	@Then("I should be able to see the password error message {string}")
	public void i_should_be_able_to_see_the_password_error_message(String string) {
	   
		String expected_errorMsg = "Please enter your password.";
		// Thread.sleep(2000);
		String actual_errmsg = Lpage.getTextFromErrorMsg();	
		Assert.assertEquals(actual_errmsg, expected_errorMsg);
		
	}
	

	/*
	 * @Then("I should be able to see the error message {string}") public void
	 * i_should_be_able_to_see_the_error_message(String string) {
	 * 
	 * 
	 * }
	 */
	

}
