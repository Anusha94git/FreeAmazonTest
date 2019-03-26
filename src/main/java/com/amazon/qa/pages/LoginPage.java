package com.amazon.qa.pages;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage  extends TestBase
{
	// contains(text(),indurthi76@gmail.com)
	@FindBy(xpath="//div[@class='a-row a-spacing-base']")
	WebElement usernameLabel;
	
	@FindBy(id="ap_password")
	WebElement passwordField;
	
	@FindBy(id="signInSubmit")
	WebElement Loginbutton;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateUsernameLabel()
	{
		return usernameLabel.isDisplayed();
	}
	
	public YourAmazonPage enterPassword(String pwd)
	{
		passwordField.sendKeys(pwd);
		Loginbutton.click();
		return new YourAmazonPage();
		
	}
	
		
	
}
