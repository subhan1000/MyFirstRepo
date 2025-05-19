package com.Automation.StepDefinations;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import com.Automation.Base.BaseClass;
import com.Automation.Page.ForgotPasswordPage;
import com.Automation.Page.HomePage;
import com.Automation.Page.LoginPage;
import com.Automation.Page.LogoutPage;
import com.Automation.Page.TC6MyProfilePage;
import com.Automation.Page.TC7MySettingPage;
import com.Automation.Page.TC8DeveloperConsolepage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UsermenuDropdownStepDefination {
	protected static WebDriver driver = null;
	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	
	LoginPage Lpage;
	 HomePage Hpage;
	 ForgotPasswordPage forgotPage;
	 TC8DeveloperConsolepage developConsol;
	 
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
		
		public void CloseDriver() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.close();
			
		}
		@Before
		public void BeforeScenario() {
			LaunchBrowser("chrome");
		}
		
		@After
		public void AfterScenario() throws InterruptedException {
			CloseDriver();
		}
	 //=============================================================================

		
		@Given("the url is {string}")
		public void the_url_is(String url) throws Exception {
			GoToUrl(url);
		}
		@When("I goto {string}")
		public void i_goto(String page) {
			
			    if(page.equalsIgnoreCase("loginpage")) {
			    	Lpage = new LoginPage(driver);}
			    
			    else if(page.equalsIgnoreCase("homepage")) {
			    	Hpage = new HomePage(driver);}
			    
			    else if(page.equalsIgnoreCase("DevelopConsol")) {
			    	developConsol = new TC8DeveloperConsolepage(driver);}
		}
		@When("I enter the username {string}")
		public void i_enter_the_username(String string) {
			Lpage.enterUserName(usernameData);
		}
		@When("I enter the password {string}")
		public void i_enter_the_password(String string) {
			Lpage.enterPassword(passwordData);
		}
		@When("I click login button")
		public void i_click_login_button() {
			Lpage.clickLoginButton();
		}

		@Then("click on the user menu tab")
		public void click_on_the_user_menu_tab() throws InterruptedException {
			Thread.sleep(2000);
			Hpage.UserMenu();
		}
		
	 	@Then("I should be able to view user menu names")
	 	public void i_should_be_able_to_view_user_menu_names() {
	 	   System.out.println("succesfully executed.");
	 	}
		
		@Then("i click the logout link")
		public void i_click_the_logout_link() {
			Hpage.LogOut();
		}

		@Then("click on the developer console option")
		public void click_on_the_developer_console_option() throws InterruptedException {
			if(developConsol == null)
		    	developConsol = new TC8DeveloperConsolepage(driver);

			Thread.sleep(2000);			
			developConsol.DeveloperConsole();
			}
		
		@Then("click on the close button for developer console window")
		public void click_on_the_close_button_for_developer_console_window() throws InterruptedException {
			String ParentWindow = driver.getWindowHandle();
			System.out.println("handleparent window" + ParentWindow);
			
			Thread.sleep(1000);
			Set<String> allWindow = driver.getWindowHandles();
			System.out.println(allWindow.size());
			
			for(String handle : allWindow) {
				
				System.out.println(handle);
				
				if(!handle.equals(ParentWindow))
				{
					driver.switchTo().window(handle);
					Thread.sleep(2000);
					//driver.close();
				}
			}
		}

	 	
	 	
	 	
	 	
	//@BeforeMethod
@Test
	public void TC5_UserMenuListVerification() throws Exception
	{
				
		/*
		 * LoginPage Lpage = new LoginPage(driver); HomePage Hpage = new
		 * HomePage(driver); Thread.sleep(2000); Lpage.enterUserName(usernameData);
		 * Lpage.enterPassword(passwordData); Lpage.clickLoginButton();
		 * Thread.sleep(2000);
		 */
	
	
	
	}
	
	@Test
	public void TC6_MyProfile_Usermenu() throws Exception 
	{
		LoginPage Lpage = new LoginPage(driver);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		HomePage Hpage = new HomePage(driver);
		Hpage.UserMenu();
		Thread.sleep(2000);
		
		TC6MyProfilePage mp = new TC6MyProfilePage(driver);
		mp.MyProfile();
		mp.EditProfile();
		mp.Frame1();
		mp.About();
		mp.Lastname("Nayak");
		mp.SaveAll();
		mp.defaultframe();
		Thread.sleep(2000);
		//mp.Post();
		//mp.frames();
		//Thread.sleep(2000);
		
		/*MyProfile_PostPage mppost = new MyProfile_PostPage(driver);
		mppost.Frame2();
		Thread.sleep(2000);
		mppost.ShareUpdate("Hi everyone");
		*/
		
		//mp.ShareUpdate("Hi everyone");
		//mp.defaultframe1();
		//mp.Share();
		
		mp.File();
		mp.Uploadfile();
		mp.Choosefile();
		mp.ShareFile();
		mp.moderate();
		mp.UploadPic();
		Thread.sleep(2000);
		mp.Frame3();
		
		mp.ChoosePic();
		mp.defaultframe2();
		mp.Frame4();
		mp.SaveButton();
		mp.defaultframe3();
		mp.Frame5();
		Thread.sleep(2000);
		mp.SaveBtn();
		Thread.sleep(2000);
		//tc6post();
		
		//tc6Save();
		
	}
	
	@Test
	public void TC7_MySettings_Usermenu() throws Exception
	{
		
		LoginPage Lpage = new LoginPage(driver);
		Lpage.enterUserName(usernameData);
		Lpage.enterPassword(passwordData);
		Lpage.clickLoginButton();
		Thread.sleep(2000);
		
		HomePage Hpage = new HomePage(driver);
		Hpage.UserMenu();
		Thread.sleep(2000);
		
		TC7MySettingPage settingpage = new TC7MySettingPage(driver);
		settingpage.MySetting();
		settingpage.Personal();
		settingpage.LoginHistory();
		settingpage.DownloadHistory();
		settingpage.LayoutLink();
		settingpage.Mytab();
		settingpage.CustomeApp();
		settingpage.Available();
		settingpage.RightArrow();
		settingpage.EmailLink();
		settingpage.EmailSetting();
		settingpage.Save();
		settingpage.CalenderReminder();
		settingpage.ActivityReminder();
		settingpage.ReminderBtn();
		
		
	}
	
	@Test
	public void TC8_DeveloperConsole() throws Exception
	
	{
	
		
		//TC8DeveloperConsolepage developConsol = new TC8DeveloperConsolepage(driver);
		//developConsol.DeveloperConsole();
		
		
	}
		
}
