package Base;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import Pages.HomePage;
import Utils.ECommerce_Scroll;
import Utils.ECommerce_Swipe;
import Utils.ECommerce_ZoomInOut;
import Utils.EcommerceApp;
import io.appium.java_client.android.AndroidDriver;

public class HomeTest extends BaseTest{

	//@Test
	public static void firstTest() throws InterruptedException, MalformedURLException {
		AndroidDriver driver = BaseTest.getDriver();
		HomePage hp = new HomePage(driver);
	
		Thread.sleep(2000);
		EcommerceApp.SingleTap(driver);
		
		Thread.sleep(2000);
		EcommerceApp.DoubleTap(driver);
	}
	//@Test
	public static void secondTest() throws InterruptedException, MalformedURLException {
		AndroidDriver driver = BaseTest.getDriver();
		HomePage hp = new HomePage(driver);
	
		Thread.sleep(2000);
		ECommerce_Swipe.SwipeTap(driver);
		
	}
	
	//@Test
	public static void thirdTest() throws InterruptedException, MalformedURLException {
		AndroidDriver driver = BaseTest.getDriver();
		HomePage hp = new HomePage(driver);
	
		Thread.sleep(2000);
		ECommerce_ZoomInOut.ZoomInOut(driver);
		
	}
	
	@Test
	public static void fourthTest() throws InterruptedException, MalformedURLException {
		AndroidDriver driver = BaseTest.getDriver();
		HomePage hp = new HomePage(driver);
	
		Thread.sleep(2000);
		ECommerce_Scroll.Scroll(driver);
		
	}
}
