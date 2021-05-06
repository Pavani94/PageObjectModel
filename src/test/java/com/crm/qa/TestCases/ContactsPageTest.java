package com.crm.qa.TestCases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.Util.TestUtil;
import com.crn.qa.Pages.ContactsPage;
import com.crn.qa.Pages.HomePage;
import com.crn.qa.Pages.LoginPage;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="Sheet1";
	
	public ContactsPageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void setup() {
		intilization();
		loginPage=new LoginPage();
		homePage=new HomePage();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactsPage=homePage.ContactsLinkPage();
		
		
	}
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		
		Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts Label is missing");
	}
	
	@Test(priority=2)
	public void selectcontactTest() {
		contactsPage.SelectContact("Alex Peter");
		contactsPage.SelectContact("CHAN S");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws InvalidFormatException  {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=3,dataProvider="getCRMTestData")
	public void createNewContactTest(String title,String fname,String lname,String company) throws InterruptedException {
		homePage.newContactsLink();
		//contactsPage.createNewContact("Miss", "Bindu", "Vamsee", "TCS");
		contactsPage.createNewContact(title, fname, lname, company);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
