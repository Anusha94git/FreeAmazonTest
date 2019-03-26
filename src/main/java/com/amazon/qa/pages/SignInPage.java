package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SignInPage extends TestBase
{

	@FindBy(xpath="//h1[contains(text(),'Login')]")
	WebElement loginHeader;
	
	@FindBy(id="ap_email")
	WebElement emailUsername;
	
	@FindBy(id="continue")
	WebElement continueButton;
	
	
	public SignInPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateSignInPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateLoginHeader()
	{
		return loginHeader.isDisplayed();
	}
	
	public LoginPage EmailLogin(String un)
	{
		emailUsername.sendKeys(un);
		continueButton.click();
		return new LoginPage();
		
	}
	
}
