package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;


import com.amazon.qa.base.TestBase;

public class YourAmazonPage extends TestBase
{

	@FindBy(xpath="//a[@id='nav-link-accountList']/descendant::span[@class='nav-line-1']")
	WebElement UsernameLabel;
	
	public YourAmazonPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateUsernameLabel()
	{
		return UsernameLabel.getText();
	}
}
