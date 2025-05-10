package Pages;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;


public class HomePage extends BasePage{

	public static final String firstImage = null;
	

	public HomePage(AppiumDriver driver) throws InterruptedException {
		super(driver);
	//Double tap
		Thread.sleep(2000);
		
		
		
	 	
	}
	public void firstImage() {
	
		WebElement driver = null;
		
		WebElement firstImage= driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.solodroid.solomerce:id/category_image\"])[1]"));
		firstImage.click();
		
		WebElement secondImage = driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.solodroid.solomerce:id/category_image\"])[3]"));
		secondImage.click();
		
		
	}
	
}
