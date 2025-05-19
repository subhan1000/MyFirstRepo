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
		//*[@id="userNav-menuItems"]/a[3]
		
		public void DeveloperConsole() throws InterruptedException {			
			Thread.sleep(1000);
			
			ClickEvent(developerConsole ,"Developer Console");
			
		}		
		
		
		
	
}

