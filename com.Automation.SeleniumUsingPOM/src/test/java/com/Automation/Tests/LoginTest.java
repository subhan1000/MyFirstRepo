package com.Automation.Tests;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.Page.HomePage;
import com.Automation.Page.LoginPage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;





public class LoginTest extends BaseClass{
	
	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	//public LoginPage Lpage = new LoginPage(driver);
	//public HomePage Hpage = new HomePage(driver);
	
	@Test(priority = 1)
	public void TC0_PasswordErrormsg() throws InterruptedException
	{
		LoginPage Lpage = new LoginPage(driver);
		
		Lpage.enterUserName(usernameData);
		
		Lpage.clickLoginButton();
		
		 String expected_errorMsg = "Please enter your password.";
		 Thread.sleep(2000);
		String actual_errmsg = Lpage.getTextFromErrorMsg();

				
				
				Assert.assertEquals(actual_errmsg, expected_errorMsg);
				
				/*File src= actual_errorMsg.getScreenshotAs(OutputType.FILE);
					String finalname=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
					takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+finalname+".png");*/
				
	}
	
	@Test(priority = 0)
	public void TC4_ValidateLoginErrormsg () throws InterruptedException
	{
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username1");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password1");
		
		LoginPage Lpage = new LoginPage(driver);
		
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		
		Thread.sleep(1000);
		
		// WebElement errorMsg = driver.findElement(By.id("error"));
		
		 String expected_errorMsg = "Your login attempt has failed.The username or password may be incorrect,or your location or login time may be restricted.Please contact the administrator at your company for help";
			
		 String actual_errorMsg = Lpage.getTextFromErrorMsg1();

			Thread.sleep(2000);
			if(actual_errorMsg.equals(expected_errorMsg))
			{
				System.out.println("Testcase is passed");
			}
			else
			{
				System.out.println("Testcase is failed"); 
			}
		
			//Assert.assertEquals(actual_errorMsg, expected_errorMsg);
	}
	
	@Test(priority = 3)
	public void TC1_LoginPage() throws Exception {
		
		LoginPage Lpage = new LoginPage(driver);
	
		Lpage.enterUserName(usernameData);
	
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
	
	}
	
	@Test(priority = 4)
	public void TC2_RememberMe() throws Exception
	{
		LoginPage Lpage = new LoginPage(driver);
		HomePage Hpage = new HomePage(driver);
		
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
			
		Thread.sleep(500);
		Lpage.remembermeCheckbox();
				
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		Hpage.UserMenu();
		Thread.sleep(1000);	
		Hpage.LogOut();
		
		Thread.sleep(1000);		
	}
	
	@Test(priority = 2)
	public void TC3_ForgotPassword() throws InterruptedException
	{
		
		
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		//driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shubhashree.mallick647@agentforce.com");
		LoginPage Lpage = new LoginPage(driver);
		Lpage.clickforgotPasswordLink();
		Thread.sleep(3000);
		Lpage.enterUsermailId(usernameData);
		Lpage.clickContiueButton();
		
	}
}
