package TestingApplication;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;


public class SwipeDemo extends Emulator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capability();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		driver.findElement(MobileBy.AccessibilityId("9")).click();
		WebElement first = driver.findElement(MobileBy.AccessibilityId("15"));
		WebElement second = driver.findElement(MobileBy.AccessibilityId("45"));
		//swipe action 15 move to 45
		//touch action//long press on element 15 for 2 secs//move to 45//release
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();
		
	}

}
