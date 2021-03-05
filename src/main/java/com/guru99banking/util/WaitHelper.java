package com.guru99banking.util;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.guru99banking.base.com.Base;

public class WaitHelper extends Base {
	public static void clickOn( WebElement locator, int timeout) {
		new WebDriverWait(driver,timeout).ignoring(StaleElementReferenceException.class).    //available with WebDriverWait with some ExpectedConditions
		until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		
	}

}
