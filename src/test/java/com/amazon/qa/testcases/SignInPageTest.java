package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SignInPage;

public class SignInPageTest extends TestBase
{
	SignInPage signInPage;
	HomePage homePage;

	public SignInPageTest()
	{
		super();
		
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		signInPage = new SignInPage();
		homePage = new HomePage();
		signInPage = homePage.clickOnSignIn();
		
		
		
	}
	
	
	
	@Test(priority=1)
	public void verifySignInPageTitle()
	{
		String title = signInPage.validateSignInPageTitle();
		String expected = "Amazon Sign In";
		Assert.assertEquals(title, expected);
		
	}
	
	@Test(priority=2)
	public void verifyLoginHeaderTest()
	{
		boolean flag = signInPage.validateLoginHeader();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyEmailLoginTest()
	{
		signInPage.EmailLogin(prop.getProperty("email"));
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
