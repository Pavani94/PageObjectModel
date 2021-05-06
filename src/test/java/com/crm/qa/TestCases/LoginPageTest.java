package com.crm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crn.qa.Pages.HomePage;
import com.crn.qa.Pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
		
	}

	@BeforeMethod
	public void setup() {
		intilization();
		loginpage=new LoginPage();		
	}
	
	@Test(priority=1)
	public void validateCRMTitleTest() {
		
		String title=loginpage.validateCRMTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void validateCRMLogoTest() {
		boolean flag=loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void validateLoginTest() {
		homepage=loginpage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
