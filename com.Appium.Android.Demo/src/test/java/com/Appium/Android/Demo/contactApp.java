package com.Appium.Android.Demo;


import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;

public class contactApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
				
		UiAutomator2Options uia = new UiAutomator2Options();
		uia.setCapability("appPackage ","com.google.android.contacts");
		uia.setCapability("appActivity","com.google.android.contacts/com.android.contacts.activities.PeopleActivity");
		uia.setCapability("diviceName","XC45OBPZPFYHMVYP ");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformversion", "12");
		
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, uia);
		Thread.sleep(2000);
		
		//Tap and message
		/*
		PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");
		Point tapPoint = new Point(440,1208);
		Sequence tap = new Sequence(fingure, 1);
		tap.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x, tapPoint.y));
		tap.addAction(fingure.createPointerDown(0));
		tap.addAction(fingure.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
		Thread.sleep(2000);
		driver.findElement(AppiumBy.id("com.google.android.contacts:id/verb_text")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys("hi, how are you doing.");
		driver.hideKeyboard();
		
		//Long press
		
		/*
		PointerInput fingure1 = new PointerInput(Kind.TOUCH, "fingure1");
		Point tapPoint1 = new Point(440,1208);
		Sequence tap1 = new Sequence(fingure1, 1);
		tap1.addAction(fingure1.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint1.x, tapPoint1.y));
		tap1.addAction(fingure1.createPointerDown(0));
		tap1.addAction(new Pause(fingure1,Duration.ofSeconds(1)));
		tap1.addAction(fingure1.createPointerUp(0));
		driver.perform(Arrays.asList(tap1));
		*/
		
		//System.out.println(driver.manage().window().getSize());
		
		//Scroll
		
		Dimension size = driver.manage().window().getSize();
		int startY = (int)(size.height*0.7);
		int endY = (int) (size.height*0.3);
		int center = size.width/2;
		
	
		PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");
		Sequence scroll = new Sequence(fingure, 0);
		scroll.addAction(fingure.createPointerMove(Duration.ofSeconds(0),Origin.viewport(),center,startY));
		scroll.addAction(fingure.createPointerDown(0));
		scroll.addAction(fingure.createPointerMove(Duration.ofSeconds(1),Origin.viewport(),center, endY));
		scroll.addAction(fingure.createPointerUp(0));		
		driver.perform(Arrays.asList(scroll));
		Thread.sleep(1000);
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"bhardwajnayak @Golu\"]")).click();
	
		
		// Another way of doing Scroll (For me not showing the id.)
		
		
	}

}
