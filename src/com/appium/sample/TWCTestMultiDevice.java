package com.appium.sample;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.URL;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TWCTestMultiDevice {
	
	AndroidDriver<MobileElement> androidDriver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@Parameters({ "deviceName_","UDID_","platformVersion_", "URL_"})
	@BeforeTest
	public void beforeMethod(String deviceName_,String UDID_,String platformVersion_,String URL_) throws MalformedURLException, InterruptedException {

		/*
		 * File classpathRoot = new File(System.getProperty("user.dir")); appDir
		 * = new File(classpathRoot, "../../../apps/ApiDemos/bin"); app = new
		 * File(appDir, "ApiDemos-debug.apk"); capabilities.setCapability("app",
		 * app.getAbsolutePath());
		 */
		capabilities.setCapability("deviceName", "deviceName_");
		capabilities.setCapability("udid", "UDID_");
		capabilities.setCapability("platformVersion", "platformVersion_");
		capabilities.setCapability("URL_", "URL_");
		System.out.println("Device identified");

		capabilities.setCapability("appPackage", "com.mytwc.common.resource");
		capabilities.setCapability("appActivity", "com.mportal.twcframework.ui.SplashActivity");

		System.out.println("Activity and package added");
		
		androidDriver = new AndroidDriver<MobileElement>(capabilities);


		// androidDriver = new AndroidDriver<MobileElement>(new
		// URL("http://127.0.0.1:4723/wd/hub/"), capabilities);

		System.out.println("Connected to Appium Server");

	}

	@Test
	public void test1() throws InterruptedException {
		System.out.println("Start mobile Testing");
		Thread.sleep(4000);
		androidDriver.findElement(By.id("termss")).click();
		Thread.sleep(4000);
		androidDriver.findElement(By.id("continueBtn")).click();
		System.out.println("Start mobile Testing");
	}

	@Test
	public void test2() throws InterruptedException {
		System.out.println("Login Start mobile Testing");
		/*
		 * MobileElement userName = (MobileElement)
		 * androidDriver.findElement(By.id("userNameTextBox")); MobileElement
		 * password = (MobileElement)
		 * androidDriver.findElement(By.id("paswordTextBox"));
		 */

		if (androidDriver.findElement(By.id("rememberMeTextBox")).isSelected()) {
			System.out.println("Remeber me check box is not checked");
		} else {

			System.out.println("Remeber me check box is checked");
		}
		if (androidDriver.findElement(By.id("signin_text")).getText().equalsIgnoreCase("Sign In")) {
			System.out.println("Sign in title is correct");
		}

		androidDriver.findElement(By.id("userNameTextBox")).sendKeys("jaclyn.lipschitz@twcable.com");
		androidDriver.findElement(By.id("paswordTextBox")).sendKeys("tester123");

		androidDriver.findElement(By.id("rememberMeTextBox")).click();
		androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		androidDriver.findElement(By.name("OK")).click();

		if (androidDriver.findElement(By.id("userNameTextBox")).getText()
				.equalsIgnoreCase("jaclyn.lipschitz@twcable.comm")) {
			androidDriver.findElement(By.id("signinButton")).click();
			androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} else {
			System.out.println("user name password is wrong");
		}

		System.out.println("typing test in Textbox");

		Thread.sleep(10000);

		System.out.println("TWC Main Screen");
		System.out.println("Login Start mobile Testing");
	}

	@Test
	public void test3() throws InterruptedException {
		System.out.println("Home Start mobile Testing");

		MobileElement helloText = (MobileElement) androidDriver.findElement(By.name("BILLING"));

		if (helloText.getText().equalsIgnoreCase("BILLING")) {
			System.out.println("Billing Module is present in home screen");
		} else {

			System.out.println("Billing Module is missing");
		}
		System.out.println("Home Start mobile Testing");

	}

	@AfterTest
	public void afterMethod() throws InterruptedException {
		/*
		 * Thread.sleep(50000);
		 * 
		 * androidDriver.quit();
		 */

	}

}



