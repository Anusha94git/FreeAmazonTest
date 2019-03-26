package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.NewRegistrationPage;
import com.amazon.qa.pages.SignInPage;


public class HomePageTest extends TestBase
{
	HomePage homePage;
	SignInPage signInPage;
	NewRegistrationPage newRegistrationPage;

	public HomePageTest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		homePage = new HomePage();
		signInPage = new SignInPage();
		
	}
	
	
	@Test(priority=1)
	public void verifyAmazonTitleTest()
	{
		String title = homePage.validateAmazonTitle();
		String expected = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
		Assert.assertEquals(title, expected);
	}
	
	@Test(priority=2)
	public void verifyAmazonLogoTest()
	{
		boolean flag = homePage.validateAmazonLogo();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=3)
	public void verifyclickOnSignInTest()
	{
			signInPage = homePage.clickOnSignIn();
	}
	
	@Test(priority=4)
	public void verifyNewCustomerRegistrationTest()
	{
		newRegistrationPage = homePage.NewCustomerRegistration();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
