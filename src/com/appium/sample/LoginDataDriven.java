package com.appium.sample;

import java.net.MalformedURLException; 
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LoginDataDriven {
	AndroidDriver<MobileElement> androidDriver;
	DesiredCapabilities capabilities = new DesiredCapabilities();

	@BeforeTest
	public void beforeMethod() throws MalformedURLException, InterruptedException {

		/*
		 * File classpathRoot = new File(System.getProperty("user.dir")); appDir
		 * = new File(classpathRoot, "../../../apps/ApiDemos/bin"); app = new
		 * File(appDir, "ApiDemos-debug.apk"); capabilities.setCapability("app",
		 * app.getAbsolutePath());
		 */
		capabilities.setCapability("VERSION", Constants.VERSION_);
		capabilities.setCapability("deviceName", Constants.deviceName_);
		capabilities.setCapability("platformName", Constants.platformName_);

		System.out.println("Device identified");

		capabilities.setCapability("appPackage", Constants.appPackage_);
		capabilities.setCapability("appActivity", Constants.appActivity_);

		System.out.println("Activity and package added");

		androidDriver = new AndroidDriver<MobileElement>(new URL(Constants.URL_), capabilities);

		System.out.println("Connected to Appium Server");

	}

	@Test
	public void test1() throws InterruptedException {
		System.out.println("Start mobile Testing for terms and conditions");
		androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		androidDriver.findElement(By.id("termss")).click();
		androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		androidDriver.findElement(By.id("continueBtn")).click();
		androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("End of terms and conditions page");
	}
	
	@Test
	public void test2() throws Exception
	{
	System.out.println("Start Login screen Testing");
	
	//data driven 
	 ExcelUtilitiesPOI excel = new ExcelUtilitiesPOI();
	 
	String sUserName = ExcelUtilitiesPOI.getCellData(1, 2);
	System.out.println("User name " + sUserName);
	if (androidDriver.findElement(By.id("signin_text")).getText().equalsIgnoreCase("Sign In")) {
		System.out.println("Sign in title is correct");
	}
	
	androidDriver.findElement(By.id("userNameTextBox")).sendKeys(sUserName);
	  
	androidDriver.findElement(By.id("paswordTextBox")).sendKeys("tester123");

	androidDriver.findElement(By.id("rememberMeTextBox")).click();
	Thread.sleep(5000);
	androidDriver.findElement(By.name("OK")).click();

	if (androidDriver.findElement(By.id("rememberMeTextBox")).isSelected()) {
		System.out.println("Remeber me check box is checked");
	} else {

		System.out.println("Remeber me check box is not checked");
	}

	if (androidDriver.findElement(By.id("userNameTextBox")).getText()
			.equalsIgnoreCase("jaclyn.lipschitz@twcable.com")) {
		// androidDriver.findElement(By.id("signinButton")).click();
		Thread.sleep(5000);
		ExcelUtilitiesPOI.setCellData("Pass",1, 9);
		System.out.println("Status" );
		
	} else {
		System.out.println("user name is wrong");
	}

	System.out.println("Validating Username");

	Thread.sleep(10000);
	System.out.println("End of Login Screen Testing");
}

}
