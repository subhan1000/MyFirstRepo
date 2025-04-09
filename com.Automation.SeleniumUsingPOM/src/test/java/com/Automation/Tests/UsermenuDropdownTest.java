package com.Automation.Tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.Automation.Base.BaseClass;
import com.Automation.Page.HomePage;
import com.Automation.Page.LoginPage;
import com.Automation.Page.LogoutPage;
import com.Automation.Page.TC6MyProfilePage;
import com.Automation.Page.TC7MySettingPage;
import com.Automation.Page.TC8DeveloperConsolepage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

public class UsermenuDropdownTest extends BaseClass {
	
	
	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	//@BeforeMethod
@Test
	public void TC5_UserMenuListVerification() throws Exception
	{
				
	LoginPage Lpage = new LoginPage(driver);
	HomePage Hpage = new HomePage(driver);
	Thread.sleep(2000);
	Lpage.enterUserName(usernameData);
	Lpage.enterPassword(passwordData);
	Lpage.clickLoginButton();
	Thread.sleep(2000);
	
	Hpage.UserMenu();
	
	}
	
	@Test
	public void TC6_MyProfile_Usermenu() throws Exception 
	{
		LoginPage Lpage = new LoginPage(driver);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		HomePage Hpage = new HomePage(driver);
		Hpage.UserMenu();
		Thread.sleep(2000);
		
		TC6MyProfilePage mp = new TC6MyProfilePage(driver);
		mp.MyProfile();
		mp.EditProfile();
		mp.Frame1();
		mp.About();
		mp.Lastname("Nayak");
		mp.SaveAll();
		mp.defaultframe();
		Thread.sleep(2000);
		//mp.Post();
		//mp.frames();
		//Thread.sleep(2000);
		
		/*MyProfile_PostPage mppost = new MyProfile_PostPage(driver);
		mppost.Frame2();
		Thread.sleep(2000);
		mppost.ShareUpdate("Hi everyone");
		*/
		
		//mp.ShareUpdate("Hi everyone");
		//mp.defaultframe1();
		//mp.Share();
		
		mp.File();
		mp.Uploadfile();
		mp.Choosefile();
		mp.ShareFile();
		mp.moderate();
		mp.UploadPic();
		Thread.sleep(2000);
		mp.Frame3();
		
		mp.ChoosePic();
		mp.defaultframe2();
		mp.Frame4();
		mp.SaveButton();
		mp.defaultframe3();
		mp.Frame5();
		Thread.sleep(2000);
		mp.SaveBtn();
		Thread.sleep(2000);
		//tc6post();
		
		//tc6Save();
		
	}
	
	@Test
	public void TC7_MySettings_Usermenu() throws Exception
	{
		
		LoginPage Lpage = new LoginPage(driver);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		HomePage Hpage = new HomePage(driver);
		Hpage.UserMenu();
		Thread.sleep(2000);
		
		TC7MySettingPage settingpage = new TC7MySettingPage(driver);
		settingpage.MySetting();
		settingpage.Personal();
		settingpage.LoginHistory();
		settingpage.DownloadHistory();
		settingpage.LayoutLink();
		settingpage.Mytab();
		settingpage.CustomeApp();
		settingpage.Available();
		settingpage.RightArrow();
		settingpage.EmailLink();
		settingpage.EmailSetting();
		settingpage.Save();
		settingpage.CalenderReminder();
		settingpage.ActivityReminder();
		settingpage.ReminderBtn();
		
		
	}
	
	@Test
	public void TC8_DeveloperConsole() throws Exception
	
	{
		LoginPage Lpage = new LoginPage(driver);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		HomePage Hpage = new HomePage(driver);
		Hpage.UserMenu();
		Thread.sleep(2000);
		
		TC8DeveloperConsolepage developConsol = new TC8DeveloperConsolepage(driver);
		developConsol.DeveloperConsole();
		
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
		
		LoginPage Lpage = new LoginPage(driver);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		HomePage Hpage = new HomePage(driver);
		Hpage.UserMenu();
		Thread.sleep(2000);
			Thread.sleep(1000);
			LogoutPage loutPage = new LogoutPage(driver);
			loutPage.Logout();
			
	}
	
}
