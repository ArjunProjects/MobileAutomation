package MobileTesting.Mobile;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest {
	
	@Test
	public void WiFiSettingsName () {
		/*to inspect the elements on mobile just download appium inspector from the following link
		https://github.com/appium/appium-inspector/releases*/
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String actual=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(actual, "WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("testwifi");
		//if there are more than one element has same locator then we can use findelements like below
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		
	} 
}


	
	
	


