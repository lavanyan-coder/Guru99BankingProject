package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;

public class EditCustomer extends Base{

	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "AccSubmit")
	WebElement subBtn;
	
	@FindBy(name = "res")
	WebElement resBtn;
	
	public HomePage verifyEditCustomer(String cusId) {
		customerId.sendKeys(cusId);
		subBtn.click();
		return new HomePage();
	}
	
	 public String getEditCustomerPageTitle() {
		 System.out.println("entering getEditCustomerPageTitle method");
			String editCustomerPageTitle = driver.getTitle();
			System.out.println("The title is : "+editCustomerPageTitle);
			return editCustomerPageTitle;
			 
		 }
	public EditCustomer() {
		PageFactory.initElements(driver, this);
	}
}
