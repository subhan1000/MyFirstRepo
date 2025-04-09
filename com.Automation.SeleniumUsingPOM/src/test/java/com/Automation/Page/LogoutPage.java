package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;

public class LogoutPage extends BasePage{
	
	public LogoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy (xpath="//*[@id=\"userNav-menuItems\"]/a[5]") WebElement logout;
	
	public void Logout() {		
		ClickEvent(logout ,"Logout");
	}
	
}
