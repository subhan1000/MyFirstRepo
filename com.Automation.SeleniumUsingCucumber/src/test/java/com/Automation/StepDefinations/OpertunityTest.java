package com.Automation.StepDefinations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesForce;

public class OpertunityTest extends BaseSalesForce{

	@Test
	public void TC15_opportunityDropDown () throws Exception
	{

		//loginSalesforce();
		Thread.sleep(2000);
		oppertunity_Tab();
		
		List<WebElement> ViewDropdown = driver.findElements(By.xpath("//*[@id=\"fcf\"]"));
		for(WebElement option : ViewDropdown) {
			System.out.println(option.getText());
		}
		
	}
	
	@Test
	public void TC16_NewOpty () throws Exception
	{
		Thread.sleep(2000);
		oppertunity_Tab();
		
		WebElement newBtn = driver.findElement(By.xpath("//input[@name='new']"));
		newBtn.click();
		
		WebElement oppertunityName = driver.findElement(By.xpath("//input[@id='opp3']"));
		oppertunityName.sendKeys("Oppertunity1");
		

		WebElement AccountName = driver.findElement(By.xpath("//input[@id='opp4']"));
		AccountName.sendKeys("Nayak");
		
		WebElement LeadSourceDropdown = driver.findElement(By.xpath("//select[@id='opp6']"));
		selectByVisibleText(LeadSourceDropdown, "Partner Referral");
		
		WebElement CloseDate = driver.findElement(By.xpath("//a[@tabindex='7']"));
		CloseDate.click();
		
		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']"));
		selectByVisibleText(stage, "Qualification");
		
		WebElement probability = driver.findElement(By.xpath("//input[@id='opp12']"));
		probability.sendKeys("0");
		
		WebElement savebtn = driver.findElement(By.xpath("//input[@name='save']"));
		savebtn.click();
		
	}
	
	@Test
	public void TC17_pipelineReport () throws Exception
	{
		Thread.sleep(2000);
		oppertunity_Tab();
		
		Thread.sleep(500);
		
		WebElement StuckOppertunity = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a"));
		StuckOppertunity.click();
		
		//driver.close();
		
	}

	@Test
	public void TC18_StuckOppertunity () throws Exception
	{
		Thread.sleep(2000);
		oppertunity_Tab();
		
		Thread.sleep(500);
		
		WebElement StuckOppertunity = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a"));
		StuckOppertunity.click();
		
	}

	@Test
	public void TC19_QuaterlyReport () throws Exception
	{
		Thread.sleep(2000);
		oppertunity_Tab();
		
		Thread.sleep(500);
		
		WebElement intervalDropdown = driver.findElement(By.xpath("//select[@id='quarter_q']"));
		selectByVisibleText(intervalDropdown, "Current and Next FQ");
		Thread.sleep(500);
		
		WebElement includeDropdown = driver.findElement(By.xpath("//select[@id='open']"));
		selectByVisibleText(includeDropdown, "Open Opportunities");
		
		WebElement runReportbtn = driver.findElement(By.xpath("//*[@id=\"lead_summary\"]/table/tbody/tr[3]/td/input"));
		runReportbtn.click();
		
		Thread.sleep(1000);
		
	}

	
}
