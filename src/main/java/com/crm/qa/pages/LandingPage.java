package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {

	//Initilizating the Page Object
	public  LandingPage() {
	PageFactory.initElements(driver, this);
	}

	//PageFactory - OR
	@FindBy(xpath="//a[text()='Login']//parent::li//parent::ul[@class='nav navbar-nav navbar-right']")
	WebElement loginLink;
	
	
	@FindBy(xpath="//img[@class='img-responsive']//parent::a[@class='navbar-brand']")
	WebElement logo;
	
	//Action
	public String validateLandingPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return logo.isDisplayed();
	}
	
	public LoginPage clickOnlink()
	{
		loginLink.click();
		return new LoginPage();
	}
}
