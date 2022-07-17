package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LandingPageTest extends TestBase {
	
	LandingPage landingPage;
	LoginPage loginPage;
	
	public LandingPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
	initilization();	
	landingPage=new LandingPage();	
	}

	@Test
	public void landingPageTitleTest()
	{
		String title=landingPage.validateLandingPageTitle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.","Page title is not valid");
	}
	
	@Test
	public void validateLogo()
	{
		boolean flag=landingPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test
	public void validateLoginLink() throws InterruptedException
	{
		Thread.sleep(2000);
	 loginPage = landingPage.clickOnlink();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}












