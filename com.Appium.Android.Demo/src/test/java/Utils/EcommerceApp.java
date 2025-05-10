package Utils;


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

import Constants.constantfiles;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.touch.offset.PointOption;

public class EcommerceApp {
	
	
		//Single tap
		
		public static void SingleTap(AndroidDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");
		Point tapPoint = new Point(284,652);
		Sequence tap = new Sequence(fingure, 1);
		tap.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x, tapPoint.y));
		tap.addAction(fingure.createPointerDown(0));
		tap.addAction(fingure.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
		
		}
		
		//Double tap
		
		public static void DoubleTap(AndroidDriver driver) throws InterruptedException {
			PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");
			Point tapPoint = new Point(530,652);
			Sequence tap = new Sequence(fingure, 1);
			tap.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x, tapPoint.y));
			tap.addAction(fingure.createPointerDown(0));
			tap.addAction(fingure.createPointerUp(0));
			driver.perform(Arrays.asList(tap));
			
			
			Dimension size = driver.manage().window().getSize();
			int X = size.width/2;
			int Y = size.height/2;
			Thread.sleep(2000);
		
			
			PointerInput fingure1 = new PointerInput(Kind.TOUCH, "fingure1");
			//Point tapPoint = new Point(284,652);
			Sequence DoubleTap = new Sequence(fingure1, 1);
			DoubleTap.addAction(fingure1.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), X,Y));
			DoubleTap.addAction(fingure1.createPointerDown(0));
			DoubleTap.addAction(new Pause(fingure1, Duration.ofMillis(100)));
			DoubleTap.addAction(fingure1.createPointerUp(0));
			DoubleTap.addAction(new Pause(fingure1, Duration.ofMillis(100)));
			DoubleTap.addAction(fingure1.createPointerDown(0));
			DoubleTap.addAction(fingure1.createPointerUp(0));
			
			driver.perform(Arrays.asList(DoubleTap));
			}
		
	
		
		
		
		
		
	

}
