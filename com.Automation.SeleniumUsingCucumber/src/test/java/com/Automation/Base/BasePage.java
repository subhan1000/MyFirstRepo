package com.Automation.Base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;
import com.github.dockerjava.api.model.Driver;

public class BasePage {

	/*
	 * public String usernameData =
	 * PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,
	 * "username"); public String passwordData =
	 * PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES,
	 * "password");
	 */
	protected WebDriver driver;
	// public static WebDriver driver = null;
	private WebDriverWait wait = null;
	 public static String today = LocalDate.now().format(DateTimeFormatter.ofPattern("d"));

	
	 public BasePage(WebDriver driver)
		{
		 	this.driver = driver;
			PageFactory.initElements(driver, this);
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
	

	public void waitforVisibility(WebElement ele, long timeInSec, String ObjName )
	{
		System.out.println(ObjName +" waiting fo visibility for maximum of "+ timeInSec +"sec");
		
			wait=new WebDriverWait(driver,timeInSec);
		
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

	public String getTextFromElement(WebElement ele, String objName) {
		String data=null;
		if(ele.isDisplayed()) {
			data = ele.getText();
		}
		else {
			//mylog.error(objName+" not dispalyed");
			System.out.println("not maching");
		}
		return data;
	}


	
	public static void selectByValue(WebElement ele, String value)
	{
		Select select =new Select(ele);
		select.selectByValue(value);
		System.out.println(value+" got selected from dropdown list");
	}

	
}
