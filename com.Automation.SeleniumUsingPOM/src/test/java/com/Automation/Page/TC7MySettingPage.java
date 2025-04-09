package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;

public class TC7MySettingPage extends BasePage{
	
	public TC7MySettingPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy (xpath="//*[@title='My Settings']") WebElement MySetting;
	@FindBy (xpath="//*[@id=\"PersonalInfo_font\"]") WebElement personal;
	@FindBy (xpath="//*[@id=\"LoginHistory_font\"]") WebElement loginHistory;
	@FindBy (xpath="//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a") WebElement downloadHistory;
	@FindBy (xpath="//*[@id=\"DisplayAndLayout_font\"]") WebElement displayLayoutlink;
	@FindBy (xpath="//*[@id=\"CustomizeTabs_font\"]") WebElement customizedMyTab;
	@FindBy (id="p4") WebElement customeAppDropdownList;
	@FindBy (id="duel_select_0") WebElement availableTabs;
	@FindBy (xpath="//*[@id=\"duel_select_0_right\"]/img") WebElement rightArrowIcon;	
	@FindBy (id="EmailSetup_font") WebElement EmailLink;
	@FindBy (id="EmailSettings_font") WebElement myEmailSetting;
	@FindBy (xpath="//*[@id=\"bottomButtonRow\"]/input[1]") WebElement save;
	@FindBy (id="CalendarAndReminders_font") WebElement calenderAndReminders;
	@FindBy (id="Reminders_font") WebElement ActivityReminders;
	@FindBy (id="testbtn") WebElement reminderButton;

	
	public void MySetting() {		
		ClickEvent(MySetting ,"My Setting");
	}
	public void Personal() {		
		ClickEvent(personal ,"Personal");
	}
	public void LoginHistory() {		
		ClickEvent(loginHistory ,"Login History");
	}
	public void DownloadHistory() {		
		ClickEvent(downloadHistory ,"Download History");
	}
	public void LayoutLink() {		
		ClickEvent(displayLayoutlink ,"Display layout Link");
	}
	public void Mytab() {		
		ClickEvent(customizedMyTab ,"Customized My tab");
	}
	public void CustomeApp() {	
		selectByVisibleText(customeAppDropdownList, "Salesforce Chatter");
		//ClickEvent(customeAppDropdownList ,"Cutome App Dropdown list");
	}
	public void Available() {	
		selectByVisibleText(availableTabs, "Reports");
		//ClickEvent(availableTabs ,"Available Tab");
	}
	public void RightArrow() {		
		ClickEvent(rightArrowIcon ,"Right Arrow Link");
	}
	public void EmailLink() {		
		ClickEvent(EmailLink ,"Email Link");
	}
	public void EmailSetting() {		
		ClickEvent(myEmailSetting ,"My Email Setting");
	}
	public void Save() {		
		ClickEvent(save ,"Save button");
	}
	public void CalenderReminder() {		
		ClickEvent(calenderAndReminders ,"Calender and Reminder");
	}
	public void ActivityReminder() {		
		ClickEvent(ActivityReminders ,"Activity reminders");
	}
	public void ReminderBtn() {		
		ClickEvent(reminderButton ,"Reminder button");
	}
	
	
	
	
	
}
