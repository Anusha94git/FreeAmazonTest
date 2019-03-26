package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;
import com.amazon.qa.pages.SignInPage;
import com.amazon.qa.pages.YourAmazonPage;

public class LoginPageTest extends TestBase
{

	LoginPage loginPage;
	SignInPage signInPage;
	HomePage homePage;
	
	
	public LoginPageTest()
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
		
	}
	
	
	@Test(priority=1)
	public void validateUsernameLabelTest()
	{
		boolean flag = loginPage.validateUsernameLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void validateLoginTest()
	{
		loginPage.enterPassword(prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
