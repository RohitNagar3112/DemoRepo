package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase  {

	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="email")
	WebElement userName;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginButton;
	
	

	@FindBy(xpath="//*[text()='Sign Up']")
	WebElement signUpButton;
	
	public String validateLoginPagetitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String user,String pwd)
	{
		userName.sendKeys(user);
		password.sendKeys(pwd);
		loginButton.click();
		return new HomePage();
	}
	
	
}
