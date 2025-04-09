package com.Automation.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesForce;

public class ContactTest extends BaseSalesForce{
	
	@Test
	public void TC25_CreateNewContact () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		
		WebElement newBtn = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newBtn.click();
		
		WebElement Lname = driver.findElement(By.xpath("//*[@id=\"name_lastcon2\"]"));
		Lname.sendKeys("Nayak");
		
		WebElement AccName = driver.findElement(By.xpath("//*[@id=\"con4\"]"));
		AccName.sendKeys("Nayak");
		
		WebElement SaveBtn = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		SaveBtn.click();
		

	}
	@Test

	public void TC26_CreateNewViewLink () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		WebElement createNewViewLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createNewViewLink.click();
		
		WebElement viewName = driver.findElement(By.id("fname"));
		viewName.sendKeys("Subh");
		
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		viewUniqueName.clear();
		Thread.sleep(500);
		viewUniqueName.sendKeys("S1");
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		saveBtn.click();
		

	}

	@Test
	public void TC27_RecentContactTab () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		WebElement recentcontactDropdown = driver.findElement(By.xpath("//*[@id=\"hotlist_mode\"]"));
		selectByVisibleText(recentcontactDropdown, "Recently Created");
		
		Thread.sleep(500);
		//driver.close();
	}
	
	@Test
	public void TC28_MyContactFromViewDropDown () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		
		WebElement viewDropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		selectByVisibleText(viewDropdown, "My Contacts");
		
	}
	
	@Test
	public void TC29_ViewContact () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		
		WebElement contactName = driver.findElement(By.linkText("Nayak"));
		contactName.click();
		
		Thread.sleep(1000);

	}
	
	@Test
	public void TC30_ValidateErrorMsg () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		
		WebElement createNewViewLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createNewViewLink.click();
		
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		viewUniqueName.sendKeys("KFLKAJ");
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		saveBtn.click();
		
		 String expected_errorMsg = "Error: You must enter a value";
			
		 String actual_errorMsg = driver.findElement(By.xpath("//div[text()=\" You must enter a value\"]")).getText();

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
	
	@Test
	public void TC31_CanelButton () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		
		WebElement createNewViewLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createNewViewLink.click();
		

		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		viewUniqueName.sendKeys("KFLKAJ");
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[1]"));
		saveBtn.click();
				
		WebElement cancelBtn = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[1]/table/tbody/tr/td[2]/input[2]"));
		cancelBtn.click();
		Thread.sleep(2000);

	}
	
	@Test
	public void TC32_CheckSaveNewBtn () throws Exception
	{
		Contact_Tab();
		Thread.sleep(2000);
		
		WebElement newBtn = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newBtn.click();
		
		WebElement Lname = driver.findElement(By.xpath("//*[@id=\"name_lastcon2\"]"));
		Lname.sendKeys("subha");
		
		WebElement AccName = driver.findElement(By.xpath("//*[@id=\"con4\"]"));
		AccName.sendKeys("nayak");
		
		WebElement SaveAndNewBtn = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[2]"));
		SaveAndNewBtn.click();

	}
	
}
