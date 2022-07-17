package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.qa.util.TestUtils;

public class ContactsPageTest extends TestBase{
	
	ContactsPage contactPage;
	LoginPage loginPage;
	HomePage homePage;
	String sheetName="contact";
	
	public ContactsPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initilization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		contactPage= new ContactsPage();
		homePage= loginPage.login(prop.getProperty("user"),prop.getProperty("password"));
		contactPage=homePage.MouseHoverOnContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest()
	{
		boolean flag=contactPage.verifyContactsLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void verifySingleSelectNameTest() throws InterruptedException
	{
		contactPage.selectContactByName("rohit nagar");
	}
	
	@Test(priority=3)
	public void verifyMultipleSelectNameTest()
	{
		contactPage.selectContactByName("rohit nagar");
		contactPage.selectContactByName("Riddhi Nagar");
	}
	
	@Test(priority=4 ,dataProvider="getCRMTestData")
	public void verifyToClickOnAddNewContacts(String firstname,String lastname,String email,String socialchannel)
	{
		contactPage.clickOnAddNewContact();
		contactPage.validateAddNewContact(firstname,lastname ,email,socialchannel);
	}
	/*
	@Test(priority=2)
	public void verifyAddNewContact()
	{
		contactPage.clickOnAddNewContact();
		contactPage.validateAddNewContact("yash", "sharma", "yashsharma@tcs.com","LinkedIn");
		
	}
	*/
	

	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtils.getData(sheetName);
		return data;
		
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}

