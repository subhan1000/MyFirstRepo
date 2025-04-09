package com.Automation.Tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesForce;

public class UsermenuDropdownTest extends BaseSalesForce {
	
	//TC6 is not working for POM framework.
	
	@BeforeMethod
	@Test
	public void TC5_UserMenuListVerification() throws Exception
	{
	
	Thread.sleep(2000);
	WebElement usermenu = driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));
	usermenu.click();
	
	}
	
	@Test
	public void TC6_MyProfile_Usermenu() throws Exception 
	{
	
		tc6Userdropdown();
		tc6AboutTab();
		tc6post();
		tc6FilePhotoUpload();
		tc6Save();
		
	}
	
	@Test
	public void TC7_MySettings_Usermenu() throws Exception
	{
		
			
			Thread.sleep(500);
		
			WebElement MySetting = driver.findElement(By.xpath("//*[@title='My Settings']"));
			MySetting.click();
			
			Thread.sleep(500);
			
			WebElement personal= driver.findElement(By.xpath("//*[@id=\"PersonalInfo_font\"]"));
			personal.click();
			Thread.sleep(500);
			
			WebElement loginHistory = driver.findElement(By.xpath("//*[@id=\"LoginHistory_font\"]"));
			loginHistory.click();
		
			Thread.sleep(500);
			WebElement downloadHistory = driver.findElement(By.xpath("//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a"));
			downloadHistory.click();
			
			Thread.sleep(1000);
			
			WebElement displayLayoutlink = driver.findElement(By.xpath("//*[@id=\"DisplayAndLayout_font\"]"));
			displayLayoutlink.click();
			Thread.sleep(500);
			
			WebElement customizedMyTab = driver.findElement(By.xpath("//*[@id=\"CustomizeTabs_font\"]"));
			customizedMyTab.click();
			Thread.sleep(500);
			
			WebElement customeAppDropdownList = driver.findElement(By.id("p4"));
			selectByVisibleText(customeAppDropdownList, "Salesforce Chatter");
			Thread.sleep(500);
			
			WebElement availableTabs = driver.findElement(By.id("duel_select_0"));
			selectByVisibleText(availableTabs, "Reports");
			
			Thread.sleep(500);
					
		  WebElement rightArrowIcon = driver.findElement(By.xpath("//*[@id=\"duel_select_0_right\"]/img")); 
		  rightArrowIcon.click();
		  Thread.sleep(500);		
		
		
		  WebElement EmailLink = driver.findElement(By.id("EmailSetup_font"));
		  EmailLink.click();
		  Thread.sleep(500);
		  
		  WebElement myEmailSetting = driver.findElement(By.id("EmailSettings_font"));
		  myEmailSetting.click();
		  Thread.sleep(500);
		  
		  WebElement save = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		  save.click();
		 
		 WebElement calenderAndReminders = driver.findElement(By.id("CalendarAndReminders_font"));
		 calenderAndReminders.click();
		 
		 WebElement ActivityReminders = driver.findElement(By.id("Reminders_font"));
		 ActivityReminders.click();
		 
		 WebElement ReminderButton = driver.findElement(By.id("testbtn"));
		 ReminderButton.click();
	}
	
	@Test
	public void TC8_DeveloperConsole() throws Exception
	
	{
		
		
		WebElement developerConsole = driver.findElement(By.xpath("//a[text()='Developer Console']"));
		developerConsole.click();
		
		String ParentWindow = driver.getWindowHandle();
		System.out.println("handleparent window" + ParentWindow);
		
		Thread.sleep(500);
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow.size());
		
		for(String handle : allWindow) {
			
			System.out.println(handle);
			
			if(!handle.equals(ParentWindow))
			{
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				driver.close();
			}
		}
	}
	

	@Test
	public void TC9_Logout() throws Exception
	{
		
			Thread.sleep(1000);
			
			WebElement Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
			Logout.click();
	}
	
}
