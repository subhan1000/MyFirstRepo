package com.Automation.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.Automation.Base.BasePage;
import com.Automation.Utility.Constants;

public class TC6MyProfilePage extends BasePage{
	
	
	public TC6MyProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy (xpath="//a[contains(text(),'My Profile')]") WebElement myprofile;
	@FindBy (xpath="//img[@src='/img/func_icons/util/pencil12.gif']") WebElement editProfile;
	@FindBy (id="contactInfoContentId") WebElement frame1;
	@FindBy (xpath="//a[contains(text(),'About')]") WebElement about;
	@FindBy (id="lastName") WebElement lastname;
	@FindBy (xpath="//input[@value='Save All']") WebElement Saveall_button;
	@FindBy (xpath="//a[@id='publisherAttachTextPost']") WebElement post;
	@FindBy (xpath="//iframe[@class='cke_wysiwyg_frame cke_reset']") WebElement frame2;
	@FindBy (xpath="//html/body[contains(text(),'Share an update,')]")WebElement shareUpdate;
	@FindBy (xpath="//input[@value='Share']") WebElement share;
	@FindBy (id="publisherAttachContentPost") WebElement file;
	@FindBy (id="chatterUploadFileAction") WebElement uploadfile;
	@FindBy (id="chatterFile") WebElement choosefile;
	@FindBy (xpath="//*[contains(text(),'Moderator')]") WebElement moderate;
	@FindBy (xpath ="//*[contains(text(),'Add Photo')]") WebElement uploadpic;
	@FindBy (id="uploadPhotoContentId") WebElement frame3;
	@FindBy (xpath="//input[@class='fileInput']") WebElement choosepic;
	@FindBy (id="uploadPhotoContentId") WebElement frame4;
	@FindBy (xpath="//*[@id='j_id0:uploadFileForm:uploadBtn' and @value=\"Save\"]") WebElement save;
	@FindBy (id="uploadPhotoContentId") WebElement frame5;	
	@FindBy (id="j_id0:j_id7:save") WebElement savebtn;
	
	
	
	public void MyProfile() {		
		ClickEvent(myprofile ,"My Profile");
	}

	public void EditProfile() {		
		ClickEvent(editProfile ,"Edit Profile");
	}
	
	public void Frame1() {		
		driver.switchTo().frame(frame1);
	}
	
	public void About() {		
		ClickEvent(about ,"About tab");
	}
	
	public void Lastname(String data) {		
		Entertext(lastname, data, "Last Name");
	}

	public void SaveAll() {		
		ClickEvent(Saveall_button ,"Save all button");
		
	}
	public void defaultframe() {		
		driver.switchTo().defaultContent();
	}
		
	public void Post() {
		ClickEvent(post ,"Post");
	}
		
	public void frames() {		
		ClickEvent(frame2 ,"Frames");		
	}

	 public void Frame2() { 
		 driver.switchTo().frame(frame2); 
		 System.out.println("switched to frame2");
	}
	 
	public void ShareUpdate(String data){		
		Entertext(shareUpdate, data, "Share and Update");
	}
	
	public void defaultframe1() {		
		driver.switchTo().defaultContent();
	}
	
	public void Share() {		
		ClickEvent(share ,"Share Button");
	}
	
	public void File() {		
		ClickEvent(file ,"File Tab");
	}	

	public void Uploadfile() {		
		ClickEvent(uploadfile ,"Upload file");
	}

	public void Choosefile() {	
		choosefile.sendKeys(Constants.BOOK2_EXCEL);
	}
	
	public void ShareFile() {		
		ClickEvent(share ,"Share File");
	}
	
	public void moderate() {		
		Actions actions=new Actions(driver);	// mouse & keyboard operation (build().perform())
		actions.moveToElement(moderate).build().perform();
	}
	
	public void UploadPic() {		
		ClickEvent(uploadpic ,"Upload profile pic");
	}
	
	public void Frame3() {
		driver.switchTo().frame(frame3);
	}
	
	public void ChoosePic() {	
		choosepic.sendKeys(Constants.PROFILE_IMAGE);
	}
	public void defaultframe2() {		
		driver.switchTo().defaultContent();
	}
	public void Frame4() {
		driver.switchTo().frame(frame4);
	}
	public void SaveButton() {		
		ClickEvent(save ,"Click Save");
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
