package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FreeAccountPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	FreeAccountPage freeAccount;
	ContactsPage contacts;
	
	public HomePageTest() {
		// TODO Auto-generated constructor stub
	super();
	}
	@BeforeMethod
	public void setup()
	{
	initilization();	
//	homePage = new HomePage();
	loginPage = new LoginPage();
	homePage=loginPage.login(prop.getProperty("user"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void validateHomePageTitle()
	{
	String title=homePage.verifyHomePageTitle();
	Assert.assertEquals(title,"Cogmento CRM");
	}
	@Test(priority=2)
	public void validateUserName()
	{
		String userLabel=homePage.verifyUserName();
		Assert.assertEquals(userLabel, "rohit nagar");
	}
	
	
	/*
	@Test(priority=3)
	public void validateFreeAccountLink()
	{
	freeAccount=homePage.clickOnFreeAccountlink();
	}
	*/
	@Test(priority=3)
	public ContactsPageTest validateContacts()
	{
		contacts=homePage.MouseHoverOnContacts();
		return new ContactsPageTest();
	}
	@Test
	public void homeGitTest()
	{
		System.out.println("Home Git Test");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
