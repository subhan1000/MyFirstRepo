package Utils;

import java.awt.Point;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.android.AndroidDriver;

public class ECommerce_Swipe
	{
	
	//Swipe
	
	public static void SwipeTap(AndroidDriver driver) throws InterruptedException {
				
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
		Thread.sleep(2000);
	}
	
	}
