package com.Appium.Android.Demo;

import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLPermission;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import Base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class CalculatorAppDemo {
	static AndroidDriver driver= null;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws MalformedURLException {
	
		/*
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage ","com.oneplus.calculator");
		dc.setCapability("appActivity","com.oneplus.calculator.Calculator");
		dc.setCapability("diviceName","XC45OBPZPFYHMVYP ");
		dc.setCapability("platformName","Android");
		dc.setCapability("platformversion", "12");
			
		*/
		
		
		UiAutomator2Options uia = new UiAutomator2Options();		
		//uia.setApp("D:\\Subha\\apk file_Akshaya\\Solodroid_E-CommerceApp.apk");
		uia.setAppPackage("com.oneplus.calculator");
		uia.setAppActivity("com.oneplus.calculator.Calculator");
		uia.setDeviceName("XC45OBPZPFYHMVYP");
		uia.setAutomationName("UiAutomator2");
		uia.setPlatformName("Android");
		uia.setPlatformVersion("12");
		
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url, uia);
		
		//driver.findElement(AppiumBy.id("com.oneplus.calculator:id/digit_5")).click();
		//driver.findElement(AppiumBy.accessibilityId("plus")).click();
		//driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.oneplus.calculator:id/digit_2\"]")).click();
		
		//Single Tap
		
		PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");
		Point tapPoint = new Point(425,1630);
		Sequence tap = new Sequence(fingure, 1);
		tap.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x, tapPoint.y));
		tap.addAction(fingure.createPointerDown(0));
		tap.addAction(fingure.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
		
		
		PointerInput fingure1 = new PointerInput(Kind.TOUCH, "fingure");
		Point tapPoint1 = new Point(960,1886);
		Sequence tap1 = new Sequence(fingure1, 1);
		tap1.addAction(fingure1.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint1.x, tapPoint1.y));
		tap1.addAction(fingure1.createPointerDown(0));
		tap1.addAction(fingure1.createPointerUp(0));
		driver.perform(Arrays.asList(tap1));
		
		
		PointerInput fingure2 = new PointerInput(Kind.TOUCH, "fingure");
		Point tapPoint2 = new Point(425,1886);
		Sequence tap2 = new Sequence(fingure2, 1);
		tap2.addAction(fingure2.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint2.x, tapPoint2.y));
		tap2.addAction(fingure2.createPointerDown(0));
		tap2.addAction(fingure2.createPointerUp(0));
		driver.perform(Arrays.asList(tap2));
		
		
		
		
		
		
		
		
		
	}	

}
