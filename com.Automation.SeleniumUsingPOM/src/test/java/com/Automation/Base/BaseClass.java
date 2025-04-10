package com.Automation.Base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Automation.Page.HomePage;
import com.Automation.Page.LoginPage;
import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	//Below are the commented code
	//protected LoginPage Lpage = new LoginPage(driver);
	//protected HomePage Hpage = new HomePage(driver);

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
	
	
	@BeforeMethod
	
	public void FastMethod() throws Exception
	{
		LaunchBrowser("chrome");
		String url = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		GoToUrl(url);
		driver.manage().window().maximize();
		//LoginSalesforce();
		
	}
	
	@AfterMethod
	public void LastMethod() throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.close();
		
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

	
	//===================================================================================================
		//USER MENU DROPDOWN TEST
		
		/*public void tc6Userdropdown() throws InterruptedException
		{
			//Thread.sleep(2000);
			//WebElement usermenu=driver.findElement(By.xpath("//span[@id=\"userNavLabel\"]"));//.id("userNavButton"));
			//usermenu.click();
			
			//Thread.sleep(2000);
			WebElement myprofile=driver.findElement(By.xpath("//a[contains(text(),'My Profile')]"));
			myprofile.click();
			
			Thread.sleep(2000);
			WebElement editprofile=driver.findElement(By.xpath("//img[@src='/img/func_icons/util/pencil12.gif']"));
			editprofile.click();
			
		}
		
		public void tc6AboutTab() throws InterruptedException {
			
			Thread.sleep(2000);
			WebElement iframe=driver.findElement(By.id("contactInfoContentId"));
			
			driver.switchTo().frame(iframe);
			
			
			Thread.sleep(2000);
			WebElement about=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
			about.click();
			
			Thread.sleep(2000);
			WebElement lastname=driver.findElement(By.id("lastName"));
			lastname.clear();
			lastname.sendKeys("Nayak");
			
			Thread.sleep(2000);
			WebElement saveall=driver.findElement(By.xpath("//input[@value='Save All']"));
			saveall.click();
			Thread.sleep(2000);
			
		}*/
		
		/*public void tc6post() throws InterruptedException
		{
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			WebElement post=driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']"));
			post.click();
			
			
			Thread.sleep(2000);
			WebElement frames=driver.findElement(By.xpath("//iFrame[@class='cke_wysiwyg_frame cke_reset']"));
			
			driver.switchTo().frame(frames);
			Thread.sleep(2000);
			
			WebElement shareupdate=driver.findElement(By.xpath("//body[contains(text(),'Share an update')]"));
			shareupdate.sendKeys("Hello everyone");
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			WebElement share=driver.findElement(By.xpath("//input[@value='Share']"));
			share.click();
			
		}*/
		
	/*
		public void tc6FilePhotoUpload() throws Exception
		{
			Thread.sleep(2000);
			WebElement file=driver.findElement(By.id("publisherAttachContentPost"));
			file.click();
			
			WebElement uploadfile=driver.findElement(By.id("chatterUploadFileAction"));
			uploadfile.click();
			
			WebElement choosefile=driver.findElement(By.id("chatterFile"));
			
			choosefile.sendKeys(Constants.BOOK2_EXCEL);
			
			WebElement sharefile=driver.findElement(By.xpath("//input[@value='Share']"));
			sharefile.click();
			
			Thread.sleep(3000);
			
			WebElement moderate=driver.findElement(By.xpath("//*[contains(text(),'Moderator')]"));
			Actions actions=new Actions(driver);	// mouse & keyboard operation (build().perform())
			actions.moveToElement(moderate).build().perform();
			
			WebElement uploadpic=driver.findElement(By.xpath("//*[contains(text(),'Add Photo')]"));
			uploadpic.click();
			
			WebElement frame3=driver.findElement(By.id("uploadPhotoContentId"));
			driver.switchTo().frame(frame3);
			
			WebElement choosepic=driver.findElement(By.xpath("//input[@class='fileInput']"));
			//choosepic.sendKeys("D:\\Development\\Subhashree\\com.Automation.SeleniumUsingTestNG\\src\\test\\resources\\OtherFiles\\kitty.jpg");
			choosepic.sendKeys(Constants.PROFILE_IMAGE);
			System.out.println(Constants.PROFILE_IMAGE);
			System.out.println(Constants.BOOK2_EXCEL);
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
			WebElement frame4=driver.findElement(By.id("uploadPhotoContentId"));
			driver.switchTo().frame(frame4);
			
			WebElement save=driver.findElement(By.xpath("//*[@id='j_id0:uploadFileForm:uploadBtn' and @value=\"Save\"]"));
			Thread.sleep(2000);
			save.click();
			Thread.sleep(2000);
			
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			
		}*/
		public void tc6Save() throws Exception
		{
			WebElement frame5=driver.findElement(By.id("uploadPhotoContentId"));
			driver.switchTo().frame(frame5);
			Thread.sleep(2000);
			WebElement savebtn=driver.findElement(By.id("j_id0:j_id7:save"));
			Thread.sleep(2000);
			savebtn.click();
			System.out.println("Photo uploaded successfully..");
		}
		
	//===================================================================================================================
	
		//OPERTUNITY TEST
		
		public void oppertunity_Tab()
		{
			WebElement oppertunity = driver.findElement(By.xpath("//*[@id=\"Opportunity_Tab\"]"));
			oppertunity.click();
		}
		
	//=======================================================================================================
		
		//CONTACT TEST
		
		public void Contact_Tab() throws InterruptedException
		{
			Thread.sleep(1000);
			WebElement contactsTab = driver.findElement(By.xpath("//*[@id=\"Contact_Tab\"]"));
			contactsTab.click();
			
		}

	
	
}
