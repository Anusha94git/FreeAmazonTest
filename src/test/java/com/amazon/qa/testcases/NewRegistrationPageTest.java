package com.amazon.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.amazon.qa.TestUtility.TestUtil;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.NewRegistrationPage;


public class NewRegistrationPageTest extends TestBase
{

	HomePage homePage;
	NewRegistrationPage newRegistrationPage;
	TestUtil testUtil;
	
	String SheetName = "Sheet1";
	
	public NewRegistrationPageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		homePage = new HomePage();
		testUtil = new TestUtil();
		newRegistrationPage = homePage.NewCustomerRegistration();
		
		
	}
	
	@DataProvider
	public Object[][] getAmazonTestData() throws IOException
	{
		Object data[][] = TestUtil.getTestData(SheetName);
		return data;
	}
	
	@Test(dataProvider="getAmazonTestData")
	public void NewRegistrationTest(String YourName, String MobileNumber, String Email, String Password)
	{
		//newRegistrationPage.NewCustomerRegistration("hello", "9876789876", "yuijhg");
		newRegistrationPage.NewCustomerRegistration(YourName, MobileNumber, Email, Password);
	}
	
	@AfterMethod
	public void tearDown()
	{
		//driver.close();
	}
}
