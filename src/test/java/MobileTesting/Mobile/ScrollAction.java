package MobileTesting.Mobile;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class ScrollAction extends BaseTest {
	
	@Test
	public void scrollActionTest() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		scrollToText("WebView");
		Thread.sleep(3000);
		
	}

}
