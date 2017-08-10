package com.appium.sample;

import java.net.MalformedURLException; 
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TWCLogin {

	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Just Started");

		AndroidDriver<MobileElement> androidDriver;
		DesiredCapabilities capabilities = new DesiredCapabilities();

		System.out.println("Start mobile Testing");

		/*
		 * File classpathRoot = new File(System.getProperty("user.dir"));
		 * appDir = new File(classpathRoot, "../../../apps/ApiDemos/bin");
		 * app = new File(appDir, "ApiDemos-debug.apk");
		 * capabilities.setCapability("app", app.getAbsolutePath());
		 */
		capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "emulator-5554");
		capabilities.setCapability("platformName", "Android");

		System.out.println("Device identified");
		
		capabilities.setCapability("appPackage", "com.mytwc.common.resource");
		capabilities.setCapability("appActivity", "com.mportal.twcframework.ui.TWCLogin");

		System.out.println("Activity and package added");

		androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);

		System.out.println("Connected to Appium Server");

		MobileElement userName = (MobileElement) androidDriver.findElement(By.id("userNameTextBox"));
		MobileElement password = (MobileElement) androidDriver.findElement(By.id("paswordTextBox"));
		MobileElement signInText = (MobileElement) androidDriver.findElement(By.id("signin_text"));
		MobileElement remeberMe = (MobileElement) androidDriver.findElement(By.id("rememberMeTextBox"));

		if (!remeberMe.isSelected()) {
			System.out.println("Remeber me check box is not checked");
		} else {

			System.out.println("Remeber me check box is checked");
		}
		if (signInText.getText().equalsIgnoreCase("Sign In")) {
			System.out.println("Sign in title is correct");
		}

		/*userName.sendKeys("jaclyn.lipschitz@twcable.com");
		password.sendKeys("tester123");*/

		if (userName.getText().equalsIgnoreCase("jaclyn.lipschitz@twcable.comfd")) {
			androidDriver.findElement(By.id("signinButton")).click();
		} else {
			System.out.println("user name password is wrong");
		}

		System.out.println("typing test in Textbox");

		// Thread.sleep(10000);

		// driver.quit();

		System.out.println("TWC Main Screen");
	}
}
