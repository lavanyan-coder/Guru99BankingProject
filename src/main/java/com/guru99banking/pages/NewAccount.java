package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;
import com.guru99banking.util.DropDown;
import com.guru99banking.util.DropDownHandleGeneric;

public class NewAccount extends Base {
	@FindBy(name = "cusid")
	WebElement customerId;
	
	@FindBy(name = "selaccount")
	WebElement selAccType;
	
	@FindBy(name = "inideposit")
	WebElement initialDep;
	
	@FindBy(name = "button2")
	WebElement subBtn;
	
	public String getTitle() {
		String newAccountTitle = driver.getTitle();
		return newAccountTitle;
	}
	
	public HomePage verifyAddNewAccount(String cusId,String acntType, int iniAmt) {
		
		customerId.sendKeys(cusId);
		DropDownHandleGeneric.doDropDownHandle(selAccType,  DropDown.VISIBLETEXT,  acntType);
		initialDep.sendKeys(""+iniAmt);
		subBtn.click();
		return new HomePage();
	}
	public NewAccount() {
		PageFactory.initElements(driver, this);
	}
}
