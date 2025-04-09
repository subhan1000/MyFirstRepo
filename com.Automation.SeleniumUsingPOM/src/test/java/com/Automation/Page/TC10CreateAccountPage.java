package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;

public class TC10CreateAccountPage extends BasePage{
	
	
	public TC10CreateAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy (xpath="//*[@id=\"AllTab_Tab\"]/a/img") WebElement imagehome;
	@FindBy (xpath="//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a") WebElement account;
	
	@FindBy (name="new") WebElement newbutton;
	@FindBy (id="acc2") WebElement accName;
	@FindBy (id="acc6") WebElement typedropdown;
	@FindBy (id="00NgK00000Fdu8Z") WebElement customerPriority;
	@FindBy (name="save") WebElement savebutton;
	
	
	public void ImageHome() {		
		ClickEvent(imagehome ,"Imagehome");
	}
	public void Account() {		
		ClickEvent(account ,"Account");
	}
	public void Newbtn() {		
		ClickEvent(newbutton ,"New Button");
	}
	public void AccountName(String data) {		
		Entertext(accName ,data,"Account Name");
	}
	public void Typedropdown() {
		selectByValue(typedropdown, "Technology Partner");
	}
	public void CustomerPriority() {
		selectByValue(customerPriority, "High");
	}
	public void Savebtn() {		
		ClickEvent(savebutton ,"Save Button");
	}
	
	
	
}
