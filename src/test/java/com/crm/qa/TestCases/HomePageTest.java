package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Util.TestUtil;
import com.crn.qa.Pages.ContactsPage;
import com.crn.qa.Pages.HomePage;
import com.crn.qa.Pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		testUtil=new TestUtil();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@Test(priority=1)
	public void HomePageTitleTst() {
		String HomePageTitle=homePage.HomePageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO","title not matched");
	}
	
	@Test(priority=2)
	public void UserNameTest() {
		testUtil.switchToFrame();
		boolean flag=homePage.UserName();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void ContactsLinkTest() {
		contactsPage=homePage.ContactsLinkPage();
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
