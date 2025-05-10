package com.Appium.Android.Demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class dragNdropApp {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		UiAutomator2Options uia = new UiAutomator2Options();
		uia.setCapability("appPackage ","dragdrop.stufflex.com.dragdrop");
		uia.setCapability("appActivity","dragdrop.stufflex.com.dragdrop.splash");
		uia.setCapability("diviceName","XC45OBPZPFYHMVYP ");
		uia.setCapability("platformName","Android");
		uia.setCapability("platformversion", "12");
		
		
		@SuppressWarnings("deprecation")
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver driver = new AndroidDriver(url, uia);
		Thread.sleep(2000);
		
		//drag and drop
		
		driver.findElement(AppiumBy.id("dragdrop.stufflex.com.dragdrop:id/btn_football")).click();
		Thread.sleep(2000);
		WebElement source_ele = driver.findElement(AppiumBy.id("dragdrop.stufflex.com.dragdrop:id/chooseB"));		
		WebElement destination_ele = driver.findElement(AppiumBy.id("dragdrop.stufflex.com.dragdrop:id/answer"));
		
		Point source = source_ele.getLocation();
		Point destination = destination_ele.getLocation();
		Thread.sleep(2000);
		
		PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");		
		Sequence drag = new Sequence(fingure, 1);
		drag.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), source));
		drag.addAction(fingure.createPointerDown(0));
		drag.addAction(new Pause(fingure, Duration.ofSeconds(1)));
		drag.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), destination));
		drag.addAction(fingure.createPointerUp(0));
		driver.perform(Arrays.asList(drag));
		
		
		
		
		
		
		
		
		
		
	}
}
