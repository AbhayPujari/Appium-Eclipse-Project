package TestingApplication;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Basics extends Emulator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capability();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//performing some operations
		//click on preference
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
//		driver.findElement(MobileBy.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
//		driver.findElementByXPath("//android.widget.TextView[@text=\"Preference\"]").click();
		
		//click on Preference dependencies
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		
		//click on wifi check box
		driver.findElement(MobileBy.id("android:id/checkbox")).click();

		//click on wifi settings
//		driver.findElementByXPath("//*[@resource-id=\"android:id/title\"]").click();
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"WiFi settings\"]")).click();
//		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		
		//entering password
		driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("sai");
		
		//to click cancel
//		driver.findElement(MobileBy.xpath("//android.widget.Button[@text=\"CANCEL\"]")).click();
		//cancel using classname & index (since classname is same for cancel and ok, we can use this way)
		driver.findElements(MobileBy.xpath("//android.widget.Button")).get(0).click();
		
		//go back to homescreen using navigate().back for 3 times
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
		
		
	}

}
