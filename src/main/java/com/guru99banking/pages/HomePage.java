package com.guru99banking.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.guru99banking.base.com.Base;
import com.guru99banking.util.WaitHelper;

public class HomePage extends Base{
	
	String welcomeText ;
	//Actions action = new Actions(driver);
	@FindBy(className = "heading3" )
	WebElement welcomeMessage;
	
	@FindBy(xpath =  "//a[text()='New Customer']")
	WebElement newCustomer;
	
	@FindBy(xpath = "//a[text()='Edit Customer']")
	WebElement editCustomer;
	
	@FindBy(xpath = "//a[text()='Delete Customer']']")
	WebElement delCustomer;
	@FindBy(xpath = "//a[text()='New Account']")
	WebElement newAccount;
	@FindBy(xpath = "//a[text()='Edit Account']]")
	WebElement editAccount;
	@FindBy(xpath = "//a[text()='Delete Account']")
	WebElement delAccount;
	
	@FindBy(id = "transparentInner")
	WebElement popUp;
	@FindBy(id = "closeBtn")
	WebElement closeBtn;
	
	 public String getHomePageTitle() {
		 System.out.println("Entering getHomePageTitle method ");
		String homePageTitle = driver.getTitle();
		System.out.println("The title is :"+homePageTitle);
		return homePageTitle;
		 
	 }
	 
	 public void closeAjaxAd() throws InterruptedException {
		 Thread.sleep(5000);
		driver.switchTo().frame("flow_close_btn_iframe");
		
		action.moveToElement(closeBtn).build().perform();
	
		clickElement(closeBtn);
		 System.out.println("Ajax call closed");
		 driver.switchTo().activeElement();
		
	 }
	 public String welcomeText() {
		welcomeText = welcomeMessage.getText();
		 return welcomeText;
	 }
	 public NewCustomer verifyNewCustomerLink() {
		 try {
		 closeAjaxAd();
		 Thread.sleep(3000);
		action.moveToElement(newCustomer).build().perform();
			//logger.info("link enabled");
			
			//WaitHelper.clickOn(newCustomer,30);
		 clickElement(newCustomer);
				}catch(Exception e) 
			{
			
		e.printStackTrace();
			}
			 return new NewCustomer();
		
		
	 }
	 public EditCustomer verifyEditCustomerLink() {
		 try {
			closeAjaxAd();
			action.moveToElement(editCustomer).build().perform();
			clickElement(editCustomer);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		 return new EditCustomer();
	 }
	 public DelCustomer verifyDelCustomerLink() {
		 delCustomer.click();
		 return new DelCustomer();
	 }
	 public NewAccount verifyNewAccountLink() {
		 newAccount.click();
		 return new NewAccount();
	 }
	 public EditAccount verifyEditAccountLink() {
		 editAccount.click();
		 return new EditAccount();
	 }
	 public DelAccount verifyDelAccountLink() {
		 delAccount.click();
		 return new DelAccount();
	 }
	 
	 public HomePage() {
		 PageFactory.initElements(driver, this);
	 }
}
