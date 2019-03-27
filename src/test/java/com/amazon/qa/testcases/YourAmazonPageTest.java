package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;


import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.pages.YourAmazonPage;



public class YourAmazonPageTest extends TestBase
{
	
	LoginPage loginPage;
	SignInPage signInPage;
	HomePage homePage;
	YourAmazonPage yourAmazonPage;
	
	
	public YourAmazonPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		signInPage = new SignInPage();
		homePage = new HomePage();
		signInPage = homePage.clickOnSignIn();
		loginPage=signInPage.EmailLogin(prop.getProperty("email"));
		yourAmazonPage= loginPage.enterPassword(prop.getProperty("password"));
		
		
	}
	
	@Test
	public void verifyUsernameLabelTest()
	{
		String usernameLabel= yourAmazonPage.validateUsernameLabel();
		Assert.assertEquals(usernameLabel, "Hello, Anusha");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
