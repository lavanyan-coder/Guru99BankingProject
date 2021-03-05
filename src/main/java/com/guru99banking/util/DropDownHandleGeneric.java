package com.guru99banking.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.guru99banking.base.com.Base;

public  class DropDownHandleGeneric extends Base {

	//effective generic method that uses enums
	public static void doDropDownHandle(WebElement locator,DropDown selectType, String value) {
		Select select = new Select(locator);
		switch (selectType) {
		case INDEX:
			select.selectByIndex(Integer.parseInt(value));
			
			break;
		case VALUE:
			select.selectByValue(value);
			
			break;
		case VISIBLETEXT:
			select.selectByVisibleText(value);
			
			break;
		default:
			System.out.println("Invalid select type given");
			break;
		}
	}
}
