package Pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;


public class BasePage {
	
	public BasePage(AppiumDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

}
