package com.Automation.Tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Automation.Base.BaseSalesForce;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

public class RandomTest extends BaseSalesForce {
	
	@Test
	public void TC33_LoggedInUserFnLn () throws Exception
	{
		Thread.sleep(2000);
		WebElement userFnameLname = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		userFnameLname.click();
	}
	
	@Test
	public void TC34_EditLastname () throws Exception
	{
		Thread.sleep(2000);
		WebElement userFnameLname = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a"));
		userFnameLname.click();
		
		WebElement editProfileIcon = driver.findElement(By.xpath("//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div/div/a/img"));
		editProfileIcon.click();
		
		WebElement iframe = driver.findElement(By.id("contactInfoContentId"));
		driver.switchTo().frame(iframe);
		
		WebElement aboutTab = driver.findElement(By.xpath("//*[@id=\"aboutTab\"]/a"));
		aboutTab.click();
		
		WebElement firstname = driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
		firstname.click();
		
		WebElement lastname = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
		lastname.sendKeys("abcd");
		
		WebElement saveAllBtn = driver.findElement(By.xpath("//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]"));
		saveAllBtn.click();
		
	}
	
	@Test
	public void TC35_CustomizationTab () throws Exception
	{
		Thread.sleep(2000);
		WebElement PlusTab = driver.findElement(By.xpath("//a[@href=\"/home/showAllTabs.jsp\"]"));
		PlusTab.click();
		
		WebElement CustomizeMyTab = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[1]/table/tbody/tr/td[2]/input"));
		CustomizeMyTab.click();
		Thread.sleep(500);
		
		WebElement selecteditems = driver.findElement(By.id("duel_select_1"));
		selectByVisibleText(selecteditems, "Coupons");//Content,Contribute,Customers
		Thread.sleep(500);
			
				
		WebElement leftArrowIcon = driver.findElement(By.xpath("//*[@id=\"duel_select_0_left\"]/img"));
					
		leftArrowIcon.click();
			Thread.sleep(1000);
			
		System.out.println("Item removed successfully!");
		
		WebElement Savebtn = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		Savebtn.click();
		
		WebElement UserMenu = driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));
		UserMenu.click();
		Thread.sleep(500);
	
		WebElement Logout = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));
		 Logout.click();
		 Thread.sleep(1000);
	
		 driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(usernameData);
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passwordData);
			
		  WebElement loginBtn = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
		  loginBtn.click();
		 
	}
	
	@Test
	public void TC36_BlockingEvent () throws Exception
	{
		Thread.sleep(2000);
		WebElement datelink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		datelink.click();
		
		WebElement timelink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]"));
		timelink.click();
		
		String mainWindowHandle = driver.getWindowHandle();

        // Open new window (Simulated by clicking a link that opens a new window)
        driver.findElement(By.className("comboboxIcon")).click(); 

        Thread.sleep(500);
       
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        for (String handle : allWindowHandles) {
        	System.out.println(handle);
        	
        	if(!handle.equals(mainWindowHandle)) {
        		
        		driver.switchTo().window(handle);
        		WebElement otherlink = driver.findElement(By.xpath("//a[text()='Other']"));
      		  	otherlink.click();
        		
        	}
      
        }
        driver.switchTo().window(mainWindowHandle);
        
        Thread.sleep(500);
 
		WebElement EndTime = driver.findElement(By.xpath("//input[@id=\"EndDateTime_time\"]"));
		EndTime.click();
		
		WebElement timeOption = driver.findElement(By.xpath("//div[@id='timePickerItem_42']"));
        timeOption.click();
		Thread.sleep(1000);
		
		WebElement Savebtn = driver.findElement(By.xpath("//input[@name=\"save\"]"));
		Savebtn.click();
	}
	
	@Test
	public void TC37_weeklyBlockingEvent () throws Exception
	{
		Thread.sleep(2000);
		WebElement datelink = driver.findElement(By.xpath("//*[@id=\"ptBody\"]/div/div[2]/span[2]/a"));
		datelink.click();
		
		WebElement timelink = driver.findElement(By.xpath("//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]"));
		timelink.click();
		
		String mainWindowHandle = driver.getWindowHandle();

        // Open new window (Simulated by clicking a link that opens a new window)
        driver.findElement(By.className("comboboxIcon")).click(); 

        Thread.sleep(500);
       
        Set<String> allWindowHandles = driver.getWindowHandles();
        
        for (String handle : allWindowHandles) {
        	System.out.println(handle);
        	
        	if(!handle.equals(mainWindowHandle)) {
        		
        		driver.switchTo().window(handle);
        		WebElement otherlink = driver.findElement(By.xpath("//a[text()='Other']"));
      		  	otherlink.click();
        		
        	}
      
        }
        driver.switchTo().window(mainWindowHandle);
        
        Thread.sleep(500);
		
        WebElement EndTime = driver.findElement(By.xpath("//input[@id=\"EndDateTime_time\"]"));
		EndTime.click();
		
		WebElement timeOption = driver.findElement(By.xpath("//div[@id='timePickerItem_38']"));
        timeOption.click();
		Thread.sleep(1000);
		
		
		WebElement RecurrenceCheckbox = driver.findElement(By.xpath("//input[@id = \"IsRecurrence\"]"));
		RecurrenceCheckbox.click();
		
		WebElement weeklyradiobutton = driver.findElement(By.xpath("//input[@id = \"rectypeftw\"]"));
		weeklyradiobutton.click();
		
		
		//--------------------------------------------
		
		try {
	
			// Open the calendar for the end date
			 WebElement RecurrenceEnddate = driver.findElement(By.xpath("//input[@id = 'RecurrenceEndDateOnly']"));
			RecurrenceEnddate.click();
			
			// Calculate today's date and the end date (2 weeks later)
			LocalDate enddate = LocalDate.now().plusWeeks(2);
		 
			// Format dates as per the calendar's expected format
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d");
			String enddateformatted = enddate.format(formatter);
		
			System.out.println(enddateformatted);
		
			DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MM"); // Full month and year 
			String targetMonthYear = enddate.format(monthYearFormatter);
		 
		
		
		while(!driver.findElement(By.xpath("//*[@id=\"datePicker\"]/div[1]")).getText().equalsIgnoreCase(targetMonthYear)) 
		{
		WebElement nextbutton = driver.findElement(By.className("calRight"));
		nextbutton.click();
		break;
		}
		WebElement EndDateElement = driver.findElement(By.xpath("//td[text()='"+ enddateformatted +"']"));
		EndDateElement.click();
		}
		
		finally
		{
			System.out.println("End date selected.");
		}
			
		//---------------------------------------------------
		
		WebElement Savebtn = driver.findElement(By.xpath("//*[@id=\"bottomButtonRow\"]/input[1]"));
		Savebtn.click();
		
		WebElement otherLink = driver.findElement(By.xpath("//span[text()='Other']"));
		otherLink.click();
		Thread.sleep(1000);
		WebElement monthviewIcon = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[1]/div[3]/span[2]/a[3]/img"));
		monthviewIcon.click();
		
	}

}
