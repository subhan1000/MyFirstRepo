package com.Automation.Base;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.Automation.Utility.Constants;
import com.Automation.Utility.PropertiesUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSalesForce extends BaseClass {
	
	public String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	public String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
	
	
	public void LoginSalesforce() throws Exception {
		
	//loginSalesforce();
	
	driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(usernameData);
	driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(passwordData);
	driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
	//driver.manage().window().maximize();
	//Thread.sleep(1000);
	//driver.close();
	}	
	
	@BeforeMethod
	
	public void FastMethod() throws Exception
	{
		LaunchBrowser("chrome");
		String url = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		GoToUrl(url);
		driver.manage().window().maximize();
		LoginSalesforce();
	}
	
	@AfterMethod
	public void LastMethod() throws InterruptedException
	{
		Thread.sleep(2000);
		//driver.close();
		
	}
//===================================================================================================
	//USER MENU DROPDOWN TEST
	
	public void tc6Userdropdown() throws InterruptedException
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
		
	}
	
	public void tc6post() throws InterruptedException
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
		
	}
	
	public void tc6FilePhotoUpload() throws Exception
	{
		Thread.sleep(2000);
		WebElement file=driver.findElement(By.id("publisherAttachContentPost"));
		file.click();
		
		WebElement uploadfile=driver.findElement(By.id("chatterUploadFileAction"));
		uploadfile.click();
		WebElement choosefile=driver.findElement(By.id("chatterFile"));
		//choosefile.sendKeys("D:\\Development\\Subhashree\\com.Automation.SeleniumUsingTestNG\\src\\test\\resources\\OtherFiles\\Book2.xlsx");
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
		
	}
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
	
	//ACCOUNT-TEST
	
	public void Account_Link() throws InterruptedException
	{
		WebElement imagehome = driver.findElement(By.xpath("//*[@id=\"AllTab_Tab\"]/a/img"));
		imagehome.click();
		Thread.sleep(500);
		
		WebElement account = driver.findElement(By.xpath("//*[@id=\"bodyCell\"]/div[3]/div[2]/table/tbody/tr[1]/td[1]/a"));
		account.click();
		Thread.sleep(500);
	}
//================================================================================================================
	
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
