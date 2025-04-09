package com.Automation.Tests;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.Page.HomePage;
import com.Automation.Page.LoginPage;
import com.Automation.Page.TC10CreateAccountPage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

public class AccountTest extends BaseClass{
	
	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	

	@Test	
	public void TC10_CreateAccount () throws Exception
	{
		LoginPage Lpage = new LoginPage(driver);
		//HomePage Hpage = new HomePage(driver);
		Thread.sleep(2000);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		TC10CreateAccountPage createAccount = new TC10CreateAccountPage(driver);
		createAccount.ImageHome();
		createAccount.Account();
		createAccount.Newbtn();
		createAccount.AccountName("Subha");
		createAccount.Typedropdown();
		createAccount.CustomerPriority();
		createAccount.Savebtn();
		
		
		
		
		/*Account_Link();
		
		WebElement newbutton = driver.findElement(By.name("new"));
		newbutton.click();
		Thread.sleep(500);
		
		driver.findElement(By.id("acc2")).sendKeys("Subha");
		
		
		WebElement typedropdown = driver.findElement(By.id("acc6"));
		selectByValue(typedropdown, "Technology Partner");
		Thread.sleep(500);
		
		WebElement customerPriority = driver.findElement(By.id("00NgK00000Fdu8Z"));
		selectByValue(customerPriority, "High");
		Thread.sleep(500);
		
		WebElement savebutton = driver.findElement(By.name("save"));
		savebutton.click();
		Thread.sleep(500);
		*/
	}
	
	@Test
	public void TC11_CreateNewView () throws Exception
	{
	
		Thread.sleep(2000);
		Account_Link();
		
		WebElement createnewView = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[2]"));
		createnewView.click();
		Thread.sleep(500);
		
		WebElement viewName =driver.findElement(By.id("fname"));
		viewName.sendKeys("SubhaN");
		WebElement viewUniqueName = driver.findElement(By.id("devname"));
		viewUniqueName.sendKeys("S_Nayak");
		
		WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		savebutton.click();
		
		Thread.sleep(1000);
	}
	
	@Test
	public void TC12_EditView () throws Exception

	{
		Thread.sleep(2000);
		
		Account_Link();
		Thread.sleep(500);
		WebElement viewdrowdown = driver.findElement(By.name("fcf"));
		viewdrowdown.clear();
		selectByVisibleText(viewdrowdown, "ma");
	
		WebElement editLink = driver.findElement(By.xpath("//*[@id=\"filter_element\"]/div/span/span[2]/a[1]"));
		editLink.click();
		
		Thread.sleep(500);
		WebElement viewName = driver.findElement(By.id("fname"));
		viewName.clear();
		viewName.sendKeys("sama");

		
		WebElement fieldDropdown = driver.findElement(By.id("fcol1"));
		selectByVisibleText(fieldDropdown, "Account Name");
		
		WebElement operatorDropdown = driver.findElement(By.id("fop1"));
		selectByVisibleText(operatorDropdown, "contains");
		
		WebElement value = driver.findElement(By.id("fval1"));
		value.clear();
		value.sendKeys("bh");
		//selectByVisibleText(valueDropdown, "a");
		
		WebElement savebutton = driver.findElement(By.xpath("//*[@id=\"editPage\"]/div[3]/table/tbody/tr/td[2]/input[1]"));
		savebutton.click();
		
		Thread.sleep(1000);

		
	}
	
	@Test
	public void TC13_MergeAccount() throws InterruptedException
	{
		Thread.sleep(2000);
		Account_Link();
		WebElement MergeAccount = driver.findElement(By.xpath("//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a"));
		MergeAccount.click();
		
		WebElement MergeAccountTextArea = driver.findElement(By.xpath("//input[@id=\"srch\"]"));
		MergeAccountTextArea.sendKeys("subha");
		
		WebElement findAccountBtn = driver.findElement(By.xpath("//input[@value=\"Find Accounts\"]"));
		findAccountBtn.click();
		
		Thread.sleep(1000);
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@class='list']/tbody/tr//input[@name='cid']"));
		
		int countselection = 0;
		
		for(WebElement checkbox:checkboxes) {
			
			if (!checkbox.isSelected()) 
		    {
		    		checkbox.click();
		    		countselection++;
		    		 System.out.println("Checkbox clicked for row " + (countselection));
		    }
			if(countselection >=2) {
				break;
			}
		}
		Thread.sleep(2000);
		WebElement nextbtn = driver.findElement(By.xpath("//input[@name='goNext']"));
		nextbtn.click();
		Thread.sleep(2000);
		
		WebElement mergebtn = driver.findElement(By.xpath("//input[@title='Merge']"));
		mergebtn.click();
		Thread.sleep(5000);
		
		 Alert alert = driver.switchTo().alert(); 
		 System.out.println(alert.getText());
		 alert.accept();
		
	}
	
	
	
	@Test
	public void TC14_CreateAccountReport() throws InterruptedException
	{
			Thread.sleep(2000);
			Account_Link();
			 
		 	WebElement lastActivityLink = driver.findElement(By.linkText("Accounts with last activity > 30 days"));
			lastActivityLink.click();
			Thread.sleep(500);
				
			WebElement dateFieldDropdown = driver.findElement(By.xpath("//*[@id ='ext-gen148']"));
			dateFieldDropdown.click();

			Thread.sleep(2000);
			WebElement dateFieldDropdown1 = driver.findElement(By.xpath("//*[@id=\"ext-gen275\"]/div[3]"));			
			dateFieldDropdown1.click();
			 
			Thread.sleep(1000);
					
			WebElement FromDate = driver.findElement(By.xpath("//*[@id=\"ext-gen153\"]"));
			FromDate.click();
			
			Thread.sleep(500);
			WebElement Datebtn1 = driver.findElement(By.xpath("//*[@id=\"ext-gen291\"]"));
			Datebtn1.click();
			
			WebElement toDate = driver.findElement(By.xpath("//*[@id=\"ext-gen155\"]"));
			toDate.click();
			WebElement Datebtn2 = driver.findElement(By.xpath("//*[@id=\"ext-gen306\"]"));
			Datebtn2.click();
			
			WebElement savebtn = driver.findElement(By.xpath("//*[@id=\"ext-gen50\"]"));
			savebtn.click();
			
			WebElement reportName = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_reportNameField\"]"));
			reportName.sendKeys("Report1");
			WebElement reportUniqueName = driver.findElement(By.xpath("//*[@id=\"saveReportDlg_DeveloperName\"]"));
			reportUniqueName.sendKeys("R1");
			
			Thread.sleep(1000);
			
			WebElement SaveAndRunBtn = driver.findElement(By.xpath("//*[@id=\"ext-gen326\"]"));
			SaveAndRunBtn.click();
			
			
	}
	

	
	
}
