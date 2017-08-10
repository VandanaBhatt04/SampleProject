package com.appium.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidElement;

public class LoginTestCases {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Just Started");

		WebDriver driver;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		System.out.println("1 ");

		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("VERSION", "4.4.4");
		capabilities.setCapability("deviceName", "ZX1B344GNG");
		capabilities.setCapability("platformName", "Android");

		System.out.println("2 ");

		capabilities.setCapability("appPackage", "com.example.vbhatt.appiumloginsample");
		capabilities.setCapability("appActivity", "com.example.vbhatt.appiumloginsample.MainActivity");

		System.out.println("3 ");

		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);
		System.out.println("4 ");

	//	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		System.out.println("I have launch Login app");
	//	WebDriverWait wait = new WebDriverWait(driver, 5);

		WebElement button = driver.findElement(By.name("NEXT"));
	//	WebElement textView = driver.findElement(By.id("edt_username"));
		String text = "Vandana";
		
   //     driver.findElement(By.name("NEXT")).sendKeys("Test");
		
		System.out.println("typing test in Textbox");
		// driver.findElement(By.id("edt_username")).sendKeys("Test");
		 WebElement testt = driver.findElement(By.id("edt_username"));
		 testt.sendKeys("test");
		 System.out.println("Edit text value  :  " + testt.getText());
		 if(testt.getText().equalsIgnoreCase("test"))
				 {
			 button.click();
				 }
		 else
		 {
			 System.out.println("Edit text value  :" + testt.getText());
		 }
		 
		// WebElement text1 = driver.findElement(By.id("edt_username")).sendKeys("Test");
		 
		// System.out.println(textView.getText());

	/*	System.out.println("Getting edit text value");
		
		wait.until(ExpectedConditions.textToBePresentInElementValue(textView, text));
		
		System.out.println("Validate user name");*/
		
	//	button.click();

		System.out.println("Validate user name");
		// we are on second screen now
		// check if second screen contains TextView with text “Activity2”
	//	driver.findElement(By.name("Hello Appium Mobile Tester"));

		System.out.println("Home Screen with text");

	/*	HashMap<String, Integer> keycode = new HashMap<String, Integer>();

		keycode.put("keycode", 4);

		((JavascriptExecutor) driver).executeScript("mobile: keyevent", keycode);

		System.out.println("we are again in main activity");

		// we are again in main activity
		driver.findElement(By.name("NEXT"));*/
		
		

		Thread.sleep(10000);

		driver.quit();

		System.out.println("I have Finished");
	}
}
