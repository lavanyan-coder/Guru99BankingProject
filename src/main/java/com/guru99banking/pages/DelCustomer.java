package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;

public class DelCustomer extends Base{
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "AccSubmit")
	WebElement subBtn;
	
	@FindBy(name = "res")
	WebElement resBtn;
	
	public String getTitle() {
		String delCustomerTitle = driver.getTitle();
		return delCustomerTitle;
	}
	
	public HomePage verifyDelCustomer(String cusId) {
		customerId.sendKeys(cusId);
		subBtn.click();
		return new HomePage();
	}
	public DelCustomer() {
		PageFactory.initElements(driver, this);
	}
}
