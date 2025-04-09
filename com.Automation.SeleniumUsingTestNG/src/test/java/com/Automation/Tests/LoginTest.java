package com.Automation.Tests;

import java.io.File;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
import com.Automation.Base.BaseSalesForce;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;





public class LoginTest extends BaseSalesForce{
	
	//Priority in -ve nos executes first.
	
	@Test(priority = 1)
	public void TC0_PasswordErrormsg() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(usernameData);
		//driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		
		 String expected_errorMsg = "Please enter your password.";
				
			 String actual_errorMsg = driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();

				Thread.sleep(2000);
				
				if(actual_errorMsg.equals(expected_errorMsg))
				{
					System.out.println("Testcase is passed");
				}
				else
				{
					System.out.println("Testcase is failed"); 
					/*File src= actual_errorMsg.getScreenshotAs(OutputType.FILE);
					String finalname=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
					takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+finalname+".png");*/
				}
	}
	
	@Test(priority = 0)
	public void TC4_ValidateLoginErrormsg () throws InterruptedException
	{
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username1");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password1");
		
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(usernameData);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passwordData);
		
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		
		Thread.sleep(1000);
		
		// WebElement errorMsg = driver.findElement(By.id("error"));
		
		 String expected_errorMsg = "Your login attempt has failed.The username or password may be incorrect,or your location or login time may be restricted.Please contact the administrator at your company for help";
			
		 String actual_errorMsg = driver.findElement(By.xpath("//*[@id=\"error\"]")).getText();

			Thread.sleep(2000);
			
			if(actual_errorMsg.equals(expected_errorMsg))
			{
				System.out.println("Testcase is passed");
			}
			else
			{
				System.out.println("Testcase is failed"); 
			}
		
	}
	
	@Test(priority = 3)
	public void TC1_LoginPage() throws Exception {
		
		LoginSalesforce();
		
		Thread.sleep(2000);
		/*
		 * WebElement logout =
		 * driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		 * logout.click();
		 */
		
	}
	
	@Test(priority = 4)
	public void TC2_RememberMe() throws Exception
	{
		//LoginSalesforce();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(usernameData);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passwordData);
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@id=\"rememberUn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		Thread.sleep(1000);
		WebElement usermenu = driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));
		usermenu.click();
		Thread.sleep(1000);
	
		WebElement logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		logout.click();
		
		
	}
	
	@Test(priority = 2)
	public void TC3_ForgotPassword() throws InterruptedException
	{
		
		//LoginSalesforce();
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		//driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shubhashree.mallick647@agentforce.com");
		driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id=\"un\"]")).sendKeys(usernameData);
		
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	}
}
