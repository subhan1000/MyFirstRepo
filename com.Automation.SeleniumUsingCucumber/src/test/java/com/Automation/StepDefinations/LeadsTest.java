package com.Automation.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesForce;

public class LeadsTest extends BaseSalesForce{

	@Test
	public void TC20_leadsTab () throws Exception
	
	{
		Thread.sleep(2000);
		WebElement leadsTablink = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		leadsTablink.click();
		
		Thread.sleep(500);
	}
	
	@Test
	public void TC21_validateLeadsDropdown () throws Exception
	
	{
		Thread.sleep(2000);
		
		WebElement leadsTablink = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		leadsTablink.click();
		
		Thread.sleep(500);
		
		List<WebElement> selectviewdropdown = driver.findElements(By.xpath("//*[@id=\"fcf\"]"));
		for (WebElement select : selectviewdropdown) {
			System.out.println(select.getText());
		}
	}

	
	@Test
	public void TC22_defaultView () throws Exception
	
	{
		Thread.sleep(2000);
		WebElement leadsTablink = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		leadsTablink.click();
		
		Thread.sleep(500);
		
		WebElement selectviewdropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		selectByVisibleText(selectviewdropdown, "Today's Leads");
		
		WebElement usermenu = driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));
		usermenu.click();
		
		WebElement Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		Logout.click();
		
		Thread.sleep(500);
		
		LoginSalesforce();
		
		Thread.sleep(1000);
		WebElement leadsTablink1 = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		leadsTablink1.click();
		
	}
	
	@Test
	public void TC23_TodaysLeads () throws Exception
	
	{
		Thread.sleep(2000);
		WebElement leadsTablink = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		leadsTablink.click();
		
		Thread.sleep(500);
		
		WebElement selectviewdropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));
		selectByVisibleText(selectviewdropdown, "Today's Leads");
		
		WebElement gobtn = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[1]/input"));
		gobtn.click();
	}
	@Test
	public void TC24_ClickNew () throws Exception
	
	{
		Thread.sleep(2000);
		WebElement leadsTablink = driver.findElement(By.xpath("//*[@id=\"Lead_Tab\"]/a"));
		leadsTablink.click();
		
		Thread.sleep(500);
		
		WebElement newBtn = driver.findElement(By.xpath("//*[@id=\"hotlist\"]/table/tbody/tr/td[2]/input"));
		newBtn.click();
	
		WebElement Lname = driver.findElement(By.xpath("//*[@id=\"name_lastlea2\"]"));
		Lname.sendKeys("Subhashree");
		
		WebElement companyName = driver.findElement(By.xpath("//*[@id=\"lea3\"]"));
		companyName.sendKeys("Subhashree And Co");
		
		WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"topButtonRow\"]/input[1]"));
		saveBtn.click();
		
		Thread.sleep(1000);

	}

	
}
