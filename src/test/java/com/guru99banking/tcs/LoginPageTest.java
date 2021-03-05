package com.guru99banking.tcs;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.AssertJUnit;

import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import com.guru99banking.AllureReportListener.TestAllureListener;
import com.guru99banking.RetryAnalyzerListener.MyTransformer;
import com.guru99banking.RetryAnalyzerListener.RetryAnalyzer;
import com.guru99banking.base.com.Base;
import com.guru99banking.pages.HomePage;
import com.guru99banking.pages.LoginPage;
import com.guru99banking.util.GetExcelData;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Listeners({TestAllureListener.class })

public class LoginPageTest extends Base{
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	@Test(priority = 1)//, retryAnalyzer = RetryAnalyzer.class)
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test Case to Verify Login Positive Case")
	@Epic("Login Page")
	@Story("Login Page Test for valid credentials")
	public void doVerifyLogin() {
		logger.info("entering doVerifyLogin Test");
		homePage = loginPage.verifyLogin(prop.getProperty("username"), prop.getProperty("password"));
		logger.info("obtaing homepage object");
		String welcome_Text = homePage.welcomeText();
		Assert.assertEquals(welcome_Text, "Welcome To Manager's Page of GTPL Bank");
		
	}
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = GetExcelData.getDataFromExcel();
	Iterator<Object[]>	it = testData.iterator();
		return it;
	}
	@Test(priority = 2,dataProvider = "getTestData",enabled = false)
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Case to Verify Login Negative Case")
	@Epic("Login Page")
	@Story("Login Page Test for Invalid credentials")
	
	public void doVerifyLoginNegative(String username, String password ) {
		logger.info("entering doVerifyLogin Test");
		loginPage.verifyLogin(username, password);
		logger.info("getting alert message");
		Alert alert = driver.switchTo().alert();
		String alertMessage = alert.getText();
		alert.accept();
		Assert.assertEquals(alertMessage, "User or Password is not valid");
		
		
	}
	
	@AfterMethod
	
	public void tearDown() {
		logger.info("closing browser");
		driver.close();
	}
	

}
