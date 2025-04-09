package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;

public class TC8DeveloperConsolepage extends BasePage{

	
	public TC8DeveloperConsolepage(WebDriver driver) {
		super(driver);
	}
		
		@FindBy (xpath="//a[text()='Developer Console']") WebElement developerConsole;
		
		public void DeveloperConsole() {		
			ClickEvent(developerConsole ,"Developer Console");
		}		
		
		
		
	
}

