package com.crn.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement UserName;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(linkText="New Contact")
	WebElement link;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String HomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean UserName() {
		return UserName.isDisplayed();
	}

	public ContactsPage ContactsLinkPage() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public void newContactsLink() throws InterruptedException {
		Actions action=new Actions(driver);
		
		action.moveToElement(contactsLink).perform();
		
			
			boolean flag=newContactLink.isDisplayed();
			System.out.println(flag);
		
			newContactLink.click();
			
	}
}
