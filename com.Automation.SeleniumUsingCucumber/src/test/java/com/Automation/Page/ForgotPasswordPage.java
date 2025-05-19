package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;

public class ForgotPasswordPage extends BasePage {
	
	@FindBy(xpath="//*[@id=\"un\"]")	WebElement username_emailId;	
	@FindBy(xpath="//*[@id=\"continue\"]")	WebElement Continue_button;
	@FindBy(xpath = "//*[@id=\"forgotPassForm\"]/a") WebElement Returnto_Login;

	public ForgotPasswordPage(WebDriver driver) {
		super(driver);
		
	}
	public void enterUsermailId(String data) {
		
		//username.sendKeys(data);
		Entertext(username_emailId, data, "shubhashree.mallick@gmail.com");
	}
	
	public void clickContiueButton() {
		
		//login_button.click();
		ClickEvent(Continue_button, "Continue button");
	}


	public void ReturnLoginButton() throws InterruptedException {
		
		//login_button.click();
		Thread.sleep(1000);
		ClickEvent(Returnto_Login, "ReturnLogin button");
	}
}
