package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.BasePage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

public class LoginPage extends BasePage {

	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	@FindBy(xpath= "//*[@id=\"username\"]")	
	WebElement username;
	
	@FindBy(xpath = "//*[@id=\"password\"]") WebElement password;
	
	@FindBy (xpath="//*[@id=\"Login\"]") WebElement login_button;
	
	@FindBy(xpath= "//input[@id=\"rememberUn\"]") WebElement rememberMe;
	
	@FindBy(xpath="//*[@id=\"error\"]") WebElement passwordactual_error_msg;
	
	@FindBy(xpath="//*[@id=\"error\"]") WebElement validateloginActual_error_msg;
	
	@FindBy(xpath="//*[@id=\"forgot_password_link\"]")	WebElement forgot_password_link;
	
	@FindBy(xpath="//*[@id=\"un\"]")	WebElement username_emailId;
	
	@FindBy(xpath="//*[@id=\"continue\"]")	WebElement Continue_button;
	
	
	
	
	public LoginPage(WebDriver driver)
	{
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	
	public void enterUserName(String data) {
		
		//username.sendKeys(data);
		Entertext(username, data, "unsername field");
	}
	
	public void enterPassword(String data) {

		//password.sendKeys(data);
		Entertext(password, data, "password field");
	}

	public void clickLoginButton() {
	
		//login_button.click();
		ClickEvent(login_button, "login button");
	}

	public void remembermeCheckbox() {
		
		ClickEvent(rememberMe, "Remember Me");
	}

	public String getTextFromErrorMsg()
	{
		waitforVisibility(passwordactual_error_msg, 10,"password field error msg");
		return getTextFromElement(passwordactual_error_msg, " password field error msgtext");
	}

	public String getTextFromErrorMsg1()
	{
		waitforVisibility(validateloginActual_error_msg, 30,"validate login error msg");
		return getTextFromElement(validateloginActual_error_msg, " validate login error msgtext");
	}
	
	
	public void clickforgotPasswordLink() {
		
		//login_button.click();
		ClickEvent(forgot_password_link, "forgot password link");
	}
	
	public void enterUsermailId(String data) {
		
		//username.sendKeys(data);
		Entertext(username_emailId, data, "unsername mail id field");
	}
	
	public void clickContiueButton() {
		
		//login_button.click();
		ClickEvent(Continue_button, "Continue button");
	}
	
}
