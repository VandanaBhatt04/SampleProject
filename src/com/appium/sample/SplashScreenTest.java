package com.appium.sample;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class SplashScreenTest {

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
		capabilities.setCapability("VERSION", "6.0");
		capabilities.setCapability("deviceName", "HT5AWBE03550");
		capabilities.setCapability("platformName", "Android");

		System.out.println("Device identified");

		capabilities.setCapability("appPackage", "com.mytwc.common.resource");
		capabilities.setCapability("appActivity", "com.mportal.twcframework.ui.SplashActivity");
		System.out.println("Activity and package added");

		androidDriver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub/"), capabilities);

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
	public void test2() throws InterruptedException {
		System.out.println("Start Login screen Testing");
		if (androidDriver.findElement(By.id("signin_text")).getText().equalsIgnoreCase("Sign In")) {
			System.out.println("Sign in title is correct");
		}

		androidDriver.findElement(By.id("userNameTextBox")).sendKeys("jaclyn.lipschitz@twcable.com");
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
			androidDriver.findElement(By.id("signinButton")).click();
			Thread.sleep(5000);
			capabilities.setCapability("appWaitPackage", "com.google.android.packageinstaller");
			capabilities.setCapability("appWaitActivity", "com.android.packageinstaller.permission.ui.GrantPermissionsActivity");
			System.out.println("Permission checks");
			Thread.sleep(5000);
			androidDriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
					
		} else {
			System.out.println("user name is wrong");
		}

		System.out.println("Validating Username");

		Thread.sleep(10000);
		System.out.println("End of Login Screen Testing");

	}

	@Test
	public void test3() throws InterruptedException {
		System.out.println("Start Home Screen Testing");

		MobileElement helloText = (MobileElement) androidDriver.findElement(By.name("TROUBLESHOOTING"));

		if (helloText.getText().equalsIgnoreCase("BILLING")) {
			System.out.println("Billing Module is present in home screen");
		} else {
			System.out.println("Billing Module is missing");
		}

		Thread.sleep(4000);
		System.out.println("Click on Make Payment button in Billing Module");
		androidDriver.findElement(By.id("com.mytwc.common.resource:id/make_payment_button")).click();
		System.out.println("Loading Data : Please wait...");
		Thread.sleep(30000);
		System.out.println("Showing pop up");
		androidDriver.findElement(By.id("com.mytwc.common.resource:id/button_frm_ok")).click();
		System.out.println("Loading Data : Please wait...");
		Thread.sleep(5000);
		androidDriver.findElement(By.id("com.mytwc.common.resource:id/my_ac_select_payment_spinner")).click();
		Thread.sleep(10000);
		List<MobileElement> list = androidDriver.findElements(
				By.xpath("//android.widget.TextView[@resource-id='com.mytwc.common.resource:id/spinner_child_item']"));
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		Thread.sleep(2000);
		/*
		 * String listItem = list.get(1).getText(); System.out.println(
		 * "1 List item value :  " + listItem); list.get(1).click();
		 */
		Thread.sleep(2000);
		androidDriver.findElement(By.id("com.mytwc.common.resource:id/my_ac_oth_amt")).sendKeys("1");
		Thread.sleep(4000);
		androidDriver.navigate().back();
		if (androidDriver.findElement(By.id("com.mytwc.common.resource:id/spinner_title_item")).getText()
				.equalsIgnoreCase("New Credit Card or Debit Card")) {
			androidDriver.findElement(By.id("com.mytwc.common.resource:id/my_ac_name_on_card_edittext"))
					.sendKeys("test");
			Thread.sleep(4000);
			try {
				androidDriver.hideKeyboard();
			} catch (Exception e) {
			}
			Thread.sleep(4000);
			androidDriver.findElement(By.id("com.mytwc.common.resource:id/my_ac_credit_card_no_edittext"))
					.sendKeys("4111111111111111");
			try {
				androidDriver.hideKeyboard();
			} catch (Exception e) {
			}
			Thread.sleep(4000);
			androidDriver.findElement(By.id("com.mytwc.common.resource:id/my_ac_credit_exp_month_edittext")).click();
			Thread.sleep(4000);
			/*Dimension size = androidDriver.findElement(By.xpath(("//android.widget.TextView[@index='1']"))).getSize();
			System.out.println("Dimension of picker" + size);
			int star_x = (int) (size.width * 0.70);
			int end_x = (int) (size.width * 0.09);
			int star_y = size.height / 2;
			System.out.println("star_x = " + star_x + " ,end_x = " + end_x + " , star_y = " + star_y);
			System.out.println("Looping for swipe mode");

			Thread.sleep(5000);

			androidDriver.swipe(star_x, star_y, end_x, star_y, 500);
*/
			androidDriver.findElement(By.id("com.mytwc.common.resource:id/dateSliderOkButton")).click();
			/*
			 * androidDriver.findElement(By.xpath((
			 * "//android.widget.TextView[@index='1']"))).getSize();
			 * System.out.println("Size of picker is :" +
			 * androidDriver.findElement(By.xpath((
			 * "//android.widget.TextView[@index='1']"))).getSize()); Dimension
			 * size = androidDriver.findElement(By.xpath((
			 * "//android.widget.TextView[@index='1']"))).getSize(); int star_x
			 * = (int) (size.width * 0.90); int end_x = (int) (size.width *
			 * 0.09); int star_y = size.height / 2; System.out.println(
			 * "star_x = " + star_x + " ,end_x = " + end_x + " , star_y = " +
			 * star_y);
			 */
			Thread.sleep(5000);
			/*
			 * androidDriver .findElement(By .xpath(
			 * "//android.widget.EditText[@resource-id='com.mytwc.common.resource:id/my_ac_credit_exp_month_edittext']"
			 * )) .sendKeys("April"); androidDriver .findElement(By .xpath(
			 * "//android.widget.EditText[@resource-id='com.mytwc.common.resource:id/my_ac_credit_exp_year_edittext']"
			 * )) .sendKeys("2018"); Thread.sleep(5000);
			 */

			androidDriver.findElement(By.id("com.mytwc.common.resource:id/my_ac_credit_continue_btn")).click();
			Thread.sleep(4000);
			androidDriver.findElement(By.id("com.mytwc.common.resource:id/button_frm_ok")).click();
			System.out.println("Done");
		}

		if (androidDriver.findElement(By.id("com.mytwc.common.resource:id/header_textView")).getText()
				.equalsIgnoreCase("Talk to TWC")) {
			System.out.println("Hey It is Talk to TWC Screen");
		} else {
			System.out.println("Oopsss wrong Screen");
		}
	}

	// Troubleshoot Screen

	/*
	 * if (helloText.getText().equalsIgnoreCase("TROUBLESHOOTING")) {
	 * System.out.println("TROUBLESHOOTING Module is present in home screen"); }
	 * else { System.out.println("TROUBLESHOOTING Module is missing"); }
	 * Thread.sleep(4000); System.out.println(
	 * "Click on Check equipment button in Billing Module");
	 * androidDriver.findElement(By.id(
	 * "com.mytwc.common.resource:id/equiment_check_button")).click();
	 * System.out.println("Loading Data : Please wait..."); Thread.sleep(20000);
	 * androidDriver.findElement(By.id(
	 * "com.mytwc.common.resource:id/newEquipment")).click();
	 * Thread.sleep(10000); List<MobileElement>
	 * list=androidDriver.findElements(By.xpath(
	 * "//android.widget.ExpandableListView[@resource-id='com.mytwc.common.resource:id/equipmentList']"
	 * )); Thread.sleep(2000); //list.get(0).click();
	 * //androidDriver.findElement(By.id(
	 * "com.mytwc.common.resource:id/serviceName")).click(); Thread.sleep(5000);
	 * Dimension size = androidDriver.manage().window().getSize(); int star_x
	 * =(int) (size.width * 0.90); int end_x = (int) (size.width * 0.09); int
	 * star_y = size.height / 2; System.out.println("star_x = " + star_x +
	 * " ,end_x = " + end_x + " , star_y = " + star_y); Thread.sleep(5000);
	 * 
	 * System.out.println("Looping for swipe mode");
	 * 
	 * androidDriver.swipe(star_x, star_y, end_x, star_y,500);
	 * 
	 * }
	 */

	@AfterTest
	public void afterMethod() throws InterruptedException {
		/*
		 * Thread.sleep(50000);
		 * 
		 * androidDriver.quit();
		 */

	}

}
