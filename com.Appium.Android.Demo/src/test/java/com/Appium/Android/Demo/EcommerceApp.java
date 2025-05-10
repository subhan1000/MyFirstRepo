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

public class EcommerceApp {
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
				
		UiAutomator2Options uia = new UiAutomator2Options();
		uia.setCapability("appPackage ","com.solodroid.solomerce");
		uia.setCapability("appActivity","com.solodroid.solomerce.activities.ActivitySplash");
		uia.setCapability("diviceName","XC45OBPZPFYHMVYP ");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformversion", "12");
		
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, uia);
		Thread.sleep(2000);
		//driver.findElement(AppiumBy.className("android.widget.ImageView")).click();
		
		/*
		 * PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure"); Point
		 * tapPoint = new Point(145,675); Sequence tap = new Sequence(fingure, 1);
		 * tap.addAction(fingure.createPointerMove(Duration.ofSeconds(0),
		 * Origin.viewport(), tapPoint.x, tapPoint.y));
		 * tap.addAction(fingure.createPointerDown(0));
		 * tap.addAction(fingure.createPointerUp(0));
		 * driver.perform(Arrays.asList(tap));
		 */
		Thread.sleep(3000);
		//Swipe
		
		Dimension size = driver.manage().window().getSize();
		int startX = (int)(size.width*0.7);
		int endX = (int) (size.width*0.01);
		int Y = size.height/2;
		Thread.sleep(2000);
	
		PointerInput fingure1 = new PointerInput(Kind.TOUCH, "fingure1");
		Sequence swipe = new Sequence(fingure1, 0);
		swipe.addAction(fingure1.createPointerMove(Duration.ofSeconds(0),Origin.viewport(),startX,Y));
		swipe.addAction(fingure1.createPointerDown(0));
		swipe.addAction(fingure1.createPointerMove(Duration.ofSeconds(1),Origin.viewport(),endX,Y));
		swipe.addAction(fingure1.createPointerUp(0));
		
		driver.perform(Arrays.asList(swipe)); 
		
		
		
		
		
	}

}
