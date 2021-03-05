package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;

public class EditAccount extends Base{
	
	@FindBy(name = "accountno")
	WebElement acctNumber;
	
	@FindBy(name = "AccSubmit")
	WebElement subBtn;
	
	public String getTitle() {
		String editAccountTitle = driver.getTitle();
		return editAccountTitle;
	}
	
	public HomePage verifyEditAccount(int accountNumber) {
		acctNumber.sendKeys(""+accountNumber);
		subBtn.click();
		return new HomePage();
	}
	public EditAccount() {
		PageFactory.initElements(driver, this);
	}

}
