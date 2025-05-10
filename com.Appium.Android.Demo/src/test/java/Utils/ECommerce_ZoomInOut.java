package Utils;

import java.awt.Point;
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

public class ECommerce_ZoomInOut {
	
	
		public static void ZoomInOut(AndroidDriver driver) throws InterruptedException {
			Thread.sleep(2000);
			PointerInput fingure = new PointerInput(Kind.TOUCH, "fingure");
			Point tapPoint= new Point(284,652);
			Sequence tap = new Sequence(fingure, 1);
			tap.addAction(fingure.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint.x, tapPoint.y));			
			tap.addAction(fingure.createPointerDown(0));
			tap.addAction(fingure.createPointerUp(0));
			driver.perform(Arrays.asList(tap));
			
			Thread.sleep(2000);
			PointerInput fingure0 = new PointerInput(Kind.TOUCH, "fingure0");
			Point tapPoint0 = new Point(530,652);
			Sequence tap0 = new Sequence(fingure0, 1);
			tap0.addAction(fingure0.createPointerMove(Duration.ofSeconds(0), Origin.viewport(), tapPoint0.x, tapPoint0.y));
			tap0.addAction(fingure0.createPointerDown(0));
			tap0.addAction(fingure0.createPointerUp(0));
			driver.perform(Arrays.asList(tap0));
			
			 			
			Dimension size = driver.manage().window().getSize();
			int startX1 =(int)(size.width*0.4);
			int startY1 =(int)(size.height*0.5);
			
			int endX1 =(int)(size.width*0.4);
			int endY1 =(int)(size.height*0.3);
			
			int startX2 =(int)(size.width*0.6);
			int startY2 =(int)(size.height*0.5);
			
			int endX2=(int)(size.width*0.4);
			int endY2 =(int)(size.height*0.7);
			
			Thread.sleep(2000);
			//ZoomIn
			PointerInput fingure1 = new PointerInput(Kind.TOUCH,"fingure1");
			
			Sequence FingureUp = new Sequence(fingure1, 0);
			FingureUp.addAction(fingure1.createPointerMove(Duration.ofMillis(700), Origin.viewport(), startX1,startY1));
			FingureUp.addAction(fingure1.createPointerDown(0));
			FingureUp.addAction(new Pause(fingure1, Duration.ofSeconds(1)));
			FingureUp.addAction(fingure1.createPointerMove(Duration.ofMillis(700), Origin.viewport(), endX1,endY1));
			FingureUp.addAction(fingure1.createPointerUp(0));
			
			PointerInput fingure2 = new PointerInput(Kind.TOUCH,"fingure2");
		
			Sequence FingureDown = new Sequence(fingure2, 0);
			FingureDown.addAction(fingure2.createPointerMove(Duration.ofMillis(700), Origin.viewport(), startX2,startY2));
			FingureDown.addAction(fingure2.createPointerDown(0));
			FingureDown.addAction(new Pause(fingure2, Duration.ofSeconds(1)));
			FingureDown.addAction(fingure2.createPointerMove(Duration.ofMillis(700), Origin.viewport(), endX2,endY2));
			FingureDown.addAction(fingure2.createPointerUp(0));
			
			driver.perform(Arrays.asList(FingureUp,FingureDown));
			Thread.sleep(2000);
			//ZoomOut
			PointerInput fingure3 = new PointerInput(Kind.TOUCH,"fingure3");
			
			Sequence FingureUp1 = new Sequence(fingure3, 0);
			FingureUp1.addAction(fingure3.createPointerMove(Duration.ofMillis(700), Origin.viewport(), endX1,endY1));
			FingureUp1.addAction(fingure3.createPointerDown(0));
			FingureUp1.addAction(new Pause(fingure3, Duration.ofSeconds(1)));
			FingureUp1.addAction(fingure3.createPointerMove(Duration.ofMillis(700), Origin.viewport(), startX1,startY1));
			FingureUp1.addAction(fingure3.createPointerUp(0));
			
			PointerInput fingure4 = new PointerInput(Kind.TOUCH,"fingure4");
		
			Sequence FingureDown1 = new Sequence(fingure4, 0);
			FingureDown1.addAction(fingure4.createPointerMove(Duration.ofMillis(700), Origin.viewport(), endX2,endY2));
			FingureDown1.addAction(fingure4.createPointerDown(0));
			FingureDown1.addAction(new Pause(fingure4, Duration.ofSeconds(1)));
			FingureDown1.addAction(fingure4.createPointerMove(Duration.ofMillis(700), Origin.viewport(), startX2,startY2));
			FingureDown1.addAction(fingure4.createPointerUp(0));
			
				driver.perform(Arrays.asList(FingureUp1,FingureDown1));
			}
		}


