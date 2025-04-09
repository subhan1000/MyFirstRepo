package com.Automation.Base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {


	 public static WebDriver driver = null;
	 public static WebDriverWait wait = null;
	 public static String today = LocalDate.now().format(DateTimeFormatter.ofPattern("d"));

	public static void LaunchBrowser(String browserName) {
		
		switch (browserName.toLowerCase()) {
		
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new  ChromeDriver();
			break;
			
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			
		default:
			System.out.println("Invalid browser.");
			break;
				
		}
		
	}

	public static void GoToUrl(String url) throws Exception  {
		
		driver.get(url);
		
	}
	
	public static void Entertext(WebElement ele, String data, String objName) {
		
		if(ele.isDisplayed())
		{
			ele.clear();
			ele.sendKeys(data);
			System.out.println("Data entered to "+ objName);
		}
		else
		{
			System.out.println(objName +"textbox is not dispalyed.");
		}
	}
	
	
	public static void ClickEvent(WebElement ele, String objName) {
		
		if(ele.isEnabled()) {
			ele.click();
			System.out.println("Button is clicked "+objName);
		}
		else
		{
			System.out.println(objName +"button is not displayed");
		}
		
	}
		
	/*public static void SelectCheckbox(WebElement ele, String objName) {
		
		list<webElement> checkboxes = new list<webElement>;
		for(WebElement checkbox: checkboxes) {
			
		}*/
	
	public static void selectByVisibleText(WebElement ele, String value) {
		
		Select select = new Select(ele);
		select.selectByVisibleText(value);
		System.out.println(value +" selected form the dropdown list.");
	}
	

	public static void waitforVisibility(WebElement ele, long timeInSec, String ObjName )
	{
		System.out.println(ObjName +" waiting fo visibility for maximum of "+ timeInSec +"sec");
		wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	
	/*public static void loginSalesforce()throws Exception {
		
		LaunchBrowser("chrome");
		GoToUrl("https://login.salesforce.com/");
		 
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shubhashree.mallick647@agentforce.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test@123");
		driver.findElement(By.xpath("//input[@id=\"rememberUn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		Thread.sleep(500);
	}
	*/
	
	
	public static void selectByValue(WebElement ele, String value)
	{
		Select select =new Select(ele);
		select.selectByValue(value);
		System.out.println(value+" got selected from dropdown list");
	}

	
}
