package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	
	LoginPage loginPage;
	HomePage homePage;
	
	public  LoginPageTest() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
	initilization();	
	loginPage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPagetitle();
		Assert.assertEquals(title, "Cogmento CRM","Page title is not valid");
	}
	
	
	@Test(priority=2)
	public HomePageTest validateLoginTest()
	{
	homePage=	loginPage.login(prop.getProperty("user"),prop.getProperty("password"));
	return new HomePageTest();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
