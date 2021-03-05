package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;

public class NewCustomer extends Base {
	String newCustomerTitle ;
	
	@FindBy(name = "name")
	WebElement custName;
	
	@FindBy(xpath = "//input[@name='rad1'][1]")
	WebElement genMale;
	
	@FindBy(xpath = "//input[@name='rad1'][2]")
	WebElement genFemale;
	
	@FindBy(id = "dob")
	WebElement dofBirth;
	
	@FindBy(name = "addr")
	WebElement addressText;
	
	@FindBy(name = "city")
	WebElement cityText;
	
	
	@FindBy(name = "state")
	WebElement stateText;
	
	@FindBy(name = "pinno")
	WebElement pinText;
	
	@FindBy(name = "emailid")
	WebElement emailIdText;
	
	@FindBy(name = "telephoneno")
	WebElement telephoneNum;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitBtn;
	
	@FindBy(xpath = "///input[@type='reset']")
	WebElement resetBtn;
	
	public NewCustomer() {
		PageFactory.initElements(driver, this);
	}
	
	public String getNewCustomerPageTitle() {
		System.out.println("Entering getNewCustomerPageTitle Method");
		newCustomerTitle = driver.getTitle();
		System.out.println("The title is :"+newCustomerTitle);
		return newCustomerTitle;
		
	}
	
	public HomePage addNewCustomer(String cus_name,String cus_gen,String 
			cus_dob,String cus_address,String cus_city,String cus_state,
			String cus_tel_num, String cus_pincode,String cus_emailid ) {
		
		custName.sendKeys(cus_name);
		if(cus_gen=="Male") {
			genMale.click();
		}
		else {
			genFemale.click();
		}
		dofBirth.sendKeys(cus_dob);
		addressText.sendKeys(cus_address);
		cityText.sendKeys(cus_city);
		stateText.sendKeys(cus_state);
		pinText.sendKeys(cus_pincode);
		telephoneNum.sendKeys(cus_tel_num);
		emailIdText.sendKeys(cus_emailid);
		
		submitBtn.click();
		
		
		return new HomePage();
	}

}
