package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class NewRegistrationPage extends TestBase
{

	@FindBy(id="ap_customer_name")
	WebElement RegName;
	
	@FindBy(id="ap_phone_number")
	WebElement RegNum;
	
	@FindBy(id="ap_email")
	WebElement RegEmail;
	
	@FindBy(id="ap_password")
	WebElement RegPwd;
	
	public NewRegistrationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void NewCustomerRegistration(String name,String num, String email, String pwd)
	{
		
		
		RegName.sendKeys(name);
		RegNum.sendKeys(num);
		RegEmail.sendKeys(email);
		RegPwd.sendKeys(pwd);
		
		
	}
}
