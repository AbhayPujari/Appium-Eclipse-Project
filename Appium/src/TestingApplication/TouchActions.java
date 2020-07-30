package TestingApplication;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.WebElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TouchActions extends Emulator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capability();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		//click on views
		//driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Views\")")).click();
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//verifying number of clickable elements
		System.out.println(driver.findElementByAndroidUIAutomator("new UiSelector().clickable(true)").getSize());	

		WebElement Expand=driver.findElement(MobileBy.AccessibilityId("Expandable Lists"));
		//driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Expandable Lists\")").click();
		
		//similar to actions class in selenium, touchAction is part of appium
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(Expand))).perform();
		//t.tap(tapOptions().withPosition(x,y));
		
		//to click on custom adapter
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		
		//long press on people name for 2-3 secs & fetch the text of alert
		WebElement ppl_name=driver.findElement(MobileBy.xpath("//android.widget.TextView[@text=\"People Names\"]"));
		t.longPress(longPressOptions().withElement(element(ppl_name)).withDuration(ofSeconds(2))).release().perform();
		System.out.println(driver.findElement(MobileBy.id("android:id/title")).getText());
		System.out.println(driver.findElementByAndroidUIAutomator("UiSelector().text(\"Sample action\")").getText());
		
	}
}
