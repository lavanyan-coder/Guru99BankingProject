package com.guru99banking.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.guru99banking.base.com.Base;

public class LoginPage extends Base {
	@FindBy (name = "uid")
	WebElement userId;
	
	@FindBy(name = "password")
	WebElement pwd ;
	
	@FindBy(name = "btnLogin")
	WebElement loginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage verifyLogin(String us, String pass) {
		userId.sendKeys(us);
		pwd.sendKeys(pass);
		loginBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage();
		
	}
			
}
