package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;

public class DelAccount extends Base {
	@FindBy(name = "accountno")
	WebElement accountNumber;
	
	@FindBy(name = "AccSubmit")
	WebElement subBtn;
	
	public DelAccount() {
		PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		String delAccountTitle = driver.getTitle();
		return delAccountTitle;
	}
	public HomePage verifyDelAccount(int accountNum)
	{
		accountNumber.sendKeys(""+accountNum);
		subBtn.click();
		return new HomePage();
	}
}
