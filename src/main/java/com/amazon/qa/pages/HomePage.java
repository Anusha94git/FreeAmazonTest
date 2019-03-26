package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase
{

	
	@FindBy(className = "nav-logo-link")
	WebElement amazonlogo;
	
	@FindBy(id = "nav-your-amazon")
	WebElement amazonSignIn;
	
	@FindBy(id="nav-link-accountList")
	WebElement YourOrders;
	
	@FindBy(id="nav-link-yourAccount")
	WebElement YourOrders1;
	
	@FindBy(linkText="Start here.")	
	WebElement StartHere;
	
	
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateAmazonTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateAmazonLogo()
	{
		return amazonlogo.isDisplayed();
	}
	
	public SignInPage clickOnSignIn()
	{
		amazonSignIn.click();
		return new SignInPage();
	}
	
	public NewRegistrationPage NewCustomerRegistration()
	{
		try
		{
			if(YourOrders.isDisplayed())
			{
				Actions act = new Actions(driver);
				act.moveToElement(YourOrders).build().perform();
		
			}
		}
		catch(Exception e)
		{
		 	if(YourOrders1.isDisplayed())
		 	{
		 		Actions act = new Actions(driver);
		 		act.moveToElement(YourOrders1).build().perform();
			
		 	}
		}
		StartHere.click();
		return new NewRegistrationPage();
	}
}
