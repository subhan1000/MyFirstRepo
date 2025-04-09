package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Automation.Base.BasePage;

public class HomePage extends BasePage {
	
	@FindBy (xpath="//span[@id=\"userNavLabel\"]") WebElement usermenu;
	
	@FindBy (xpath="//*[@id=\"userNav-menuItems\"]/a[5]") WebElement logout;
	
	
	public HomePage(WebDriver driver)
	{
		//PageFactory.initElements(driver, this);
		super(driver);
	}
	
	public void UserMenu() {
		
		ClickEvent(usermenu, "User Menu");
	}
	
	public void LogOut() {
		
		ClickEvent(logout, "Logout");
	}
}
