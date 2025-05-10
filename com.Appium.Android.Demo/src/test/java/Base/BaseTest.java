package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import Constants.constantfiles;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	static AndroidDriver driver= null;
	AppiumServiceBuilder service;
	
	/*
	 * @BeforeTest public void StartServer() throws InterruptedException { service =
	 * new AppiumServiceBuilder() .withAppiumJS(new
	 * File("C:\\Program Files\\nodejs\\node_modules\\npm\\node_modules\\qrcode-terminal\\lib\\main.js"
	 * )) .withIPAddress("127.0.0.1") .withArgument(basepath, "/wd/hub")
	 * .usingPort(4723); service.build().start(); Thread.sleep(5000); }
	 * 
	 * @AfterTest public void EndServer() {
	 * 
	 * service.build().stop(); }
	 */
	
	public static AndroidDriver getDriver() throws MalformedURLException {
		

		UiAutomator2Options uia = new UiAutomator2Options();		
		//uia.setApp("D:\\Subha\\apk file_Akshaya\\Solodroid_E-CommerceApp.apk");
		//uia.setAppPackage("com.oneplus.calculator");
		//uia.setAppActivity("com.oneplus.calculator.Calculator");
		
		uia.setAppPackage(constantfiles.PACKAGE_NAME);
		uia.setAppActivity(constantfiles.ACTIVITY_NAME);
		
		/*
		 * uia.setAppPackage(constantfiles.PACKAGE_NAME1);
		 * uia.setAppActivity(constantfiles.ACTIVITY_NAME1);
		 * 
		 * uia.setAppPackage(constantfiles.PACKAGE_NAME2);
		 * uia.setAppActivity(constantfiles.ACTIVITY_NAME2);
		 * 
		 * uia.setAppPackage(constantfiles.PACKAGE_NAME3);
		 * uia.setAppActivity(constantfiles.ACTIVITY_NAME3);
		 */
		uia.setDeviceName("XC45OBPZPFYHMVYP");
		uia.setAutomationName("UiAutomator2");
		uia.setPlatformName("Android");
		uia.setPlatformVersion("12");
		
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		return driver = new AndroidDriver(url, uia);
		
	}
	
	
	
	

}
