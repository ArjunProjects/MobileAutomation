package MobileTesting.Mobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException {
		service=new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\sakep\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723)
				.build();
		service.start();
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Pixel 5  Android");
		options.setApp("D:\\Appium\\Mobile\\src\\test\\java\\resources\\ApiDemos-debug.apk");

		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//longpress
	public void longPressAction(WebElement ele) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
						"duration",2000));
	}

	
	//scrolling to text
	
	public void scrollToText(String textToScroll) {
		
		String s=textToScroll.replace(textToScroll, "\""+textToScroll+"\"");
		String textAfterTrim="new UiScrollable(new UiSelector()).scrollIntoView(text("+s+"))";
		driver.findElement(AppiumBy.androidUIAutomator(textAfterTrim));
	}
	
	//another way of scrolling-scroll to end
	public void scrollToEndAction() {
		boolean scrollMore;
		do {
			scrollMore= (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
			
			//we can check that our element is visible here or not. write ur condition here
			
		}while(scrollMore);
	}
	
	//Swipe
	
	public void swipeAction(WebElement ele, String direction) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}

}
