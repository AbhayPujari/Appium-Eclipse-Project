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


public class DragAndDrop extends Emulator {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capability();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Drag and Drop\"))").click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//WebElement first = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
		//WebElement second = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_2"));
		//using classname & index (since classname is same for cancel and ok, we can use this way)
		WebElement first = driver.findElements(MobileBy.xpath("//android.view.View")).get(0);
		WebElement second = driver.findElements(MobileBy.xpath("//android.view.View")).get(1);
		TouchAction t = new TouchAction(driver);
		//t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(3))).moveTo(element(second)).release().perform();
		t.longPress(element(first)).moveTo(element(second)).release().perform();
		
		
	}

}
