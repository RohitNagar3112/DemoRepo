package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@class='user-display1']")
	WebElement userNameLabel;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contacts;

	@FindBy(xpath="//div[@id='top-header-menu']//a[text()='Free account']")
	WebElement freeAccount;
	
	@FindBy(xpath="	//*[text()='Address']")
	WebElement address;
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String verifyUserName()
	{
		return userNameLabel.getText();
	}
	
	public FreeAccountPage clickOnFreeAccountlink()
	{
		freeAccount.clear();
		return new FreeAccountPage();
	}
	
	public ContactsPage MouseHoverOnContacts()
	{
		contacts.click();
		Actions action=new Actions(driver);
		action.moveToElement(address).build().perform();
		return new ContactsPage();
	}
	
	
}

