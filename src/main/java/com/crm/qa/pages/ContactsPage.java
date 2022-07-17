package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase  {

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactLabel;
	
	@FindBy(xpath="//span[text()='Contacts']//parent::a//following-sibling::button")
	WebElement addContactButton;
	
	@FindBy(xpath="//i[@class='users icon']")
	WebElement contactmenu;
	

	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	

	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	 
	
	
	@FindBy(xpath="//label[text()='Social Channels']//parent::div//descendant::i[@class='dropdown icon']")
	WebElement socialChannelDropDownBtn;

	public boolean verifyContactsLabel()
	{
		return contactLabel.isDisplayed();
	}
	
	public void selectContactByName(String name)
	{
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//div")).click();;
	}
	
	public void clickOnAddNewContact()
	{
		Actions action=new Actions(driver);
		action.moveToElement(contactmenu).build().perform();
		addContactButton.click();
		action.moveToElement(firstName).build().perform();
	}
	
	public void validateAddNewContact(String fName,String lName,String mail,String socialChannel)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(mail);
		socialChannelDropDownBtn.click();
		driver.findElement(By.xpath("//span[text()='"+socialChannel+"']")).click();
		
		saveButton.click();
		
		
	}
}


















