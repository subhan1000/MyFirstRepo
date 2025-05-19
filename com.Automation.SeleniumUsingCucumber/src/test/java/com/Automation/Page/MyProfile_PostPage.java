package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;
import com.Automation.Utility.Constants;

public class MyProfile_PostPage extends BasePage{

	public MyProfile_PostPage(WebDriver driver)
	{
		super(driver);
		
	}
	
	//@FindBy (xpath="//a[@id='publisherAttachTextPost']") WebElement post;
	
	
	@FindBy (xpath="//iFrame[@class='cke_wysiwyg_frame cke_reset']") 
	WebElement frames;
	
	@FindBy (xpath="//html/body[contains(text(),'Share an update,')]")
	WebElement shareUpdate;
	
	@FindBy (id="uploadPhotoContentId") WebElement frame5;	
	@FindBy (id="j_id0:j_id7:save") WebElement savebtn;
	
//public void Post() {
//		ClickEvent(post ,"Post");
	//}
	
public void frames() {
		
		ClickEvent(frames ,"Frames");
		
	}
public void iframe1() { 
	
	 driver.switchTo().frame(frames); 
	 System.out.println("switched to frame1");
	}
public void ShareUpdate(String data) {
	
		//shareUpdate = driver.findElement(By.xpath("//html/body[contains(text(),'Share an update,')]"));
		Entertext(shareUpdate, data, "Share and Update");
	}
	
@FindBy (id="uploadPhotoContentId") WebElement frame3;
@FindBy (xpath="//input[@class='fileInput']") WebElement choosepic;
public void Frame3() {
	driver.switchTo().frame(frame3);
}

public void ChoosePic() {	
	choosepic.sendKeys(Constants.PROFILE_IMAGE);
}
public void defaultframe3() {		
	driver.switchTo().defaultContent();
}
public void Frame5() {
	driver.switchTo().frame(frame5);
}
public void SaveBtn() {		
	ClickEvent(savebtn ,"Click Save");
	System.out.println("Photo uploaded successfully..");
}
	
	
}
