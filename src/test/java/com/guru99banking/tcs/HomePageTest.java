package com.guru99banking.tcs;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru99banking.base.com.Base;
import com.guru99banking.pages.DelAccount;
import com.guru99banking.pages.DelCustomer;
import com.guru99banking.pages.EditAccount;
import com.guru99banking.pages.EditCustomer;
import com.guru99banking.pages.HomePage;
import com.guru99banking.pages.LoginPage;
import com.guru99banking.pages.NewAccount;
import com.guru99banking.pages.NewCustomer;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class HomePageTest extends Base {
	HomePage homePage;
	NewCustomer newCustomerPage;
	EditCustomer editCustomer;
	DelCustomer delCustomer;
	NewAccount newAccount;
	EditAccount editAccount;
	DelAccount delAccount;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() {
		initialization();
		LoginPage loginPage = new LoginPage();
		homePage = loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1,groups = "Smoke Tests" )
	@Severity(SeverityLevel.BLOCKER)
	@Epic("login")
	
	public void doVerifyNewCustomerLink() {
		
		newCustomerPage = homePage.verifyNewCustomerLink();
		
		String newCustomerPageTitle = newCustomerPage.getNewCustomerPageTitle();
		Assert.assertEquals(newCustomerPageTitle, " Gtpl Bank New Customer Entry Page ");
	}
	
	@Test(priority=1,groups = "Smoke Tests")
	public void doVerifyEditCustomerLink() {
		editCustomer = homePage.verifyEditCustomerLink();
		String editCustomerPageTitle = editCustomer.getEditCustomerPageTitle();
		Assert.assertEquals(editCustomerPageTitle, " Gtpl Bank Edit Customer Page ");
	}
	@Test(priority=1,groups = "Smoke Tests",enabled = false)
	public void doVerifyDelCustomerLink() {
		delCustomer = homePage.verifyDelCustomerLink();
		String delCustomerPageTitle = delCustomer.getTitle();
		Assert.assertEquals(delCustomerPageTitle, " Gtpl Bank Delete Customer Page ");
	}
	@Test(priority = 1,groups = "Smoke Tests",enabled = false)
	public void doVerifyNewAccountLink() {
		newAccount = homePage.verifyNewAccountLink();
		String newAccountPageTitle = newAccount.getTitle();
		Assert.assertEquals(newAccountPageTitle, " Gtpl bank add new account ");
	}
	@Test(priority = 1,groups = "Smoke Tests",enabled = false)
	public void doVerifyEditAccountLink() {
		editAccount = homePage.verifyEditAccountLink();
		String editAccountPageTitle = editAccount.getTitle();
		Assert.assertEquals(editAccountPageTitle, " GTPL Edit Account Page ");
	}
	@Test(priority = 1,groups = "Smoke Tests",enabled = false)
	public void doVerifyDelAccountLink() {
		delAccount = homePage.verifyDelAccountLink();
		String delAccountPageTitle =  delAccount.getTitle();
		Assert.assertEquals(delAccountPageTitle, " GTPL Bank Delete Account Page ");
	}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}

}
