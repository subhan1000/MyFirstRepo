package Utils;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ECommerce_Scroll {
	
	//Scroll
	public static void Scroll(AndroidDriver driver) throws InterruptedException {
		
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
		//Thread.sleep(1000);
		//driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"bhardwajnayak @Golu\"]")).click();
		Thread.sleep(2000);
	}
}
