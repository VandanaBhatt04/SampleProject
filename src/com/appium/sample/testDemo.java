package com.appium.sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class testDemo 
{
	@Test
	public void Test2()
	{
		System.out.println("I m in test2");
	}

	@Test
	public void Test1()
	{
		System.out.println("I m in test1");
	}
	
	@BeforeTest
	public void BeforeTest()
	{
		System.out.println("I m in @BeforeTest");
	}

	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("I m in @AfterTest");
	}


}
