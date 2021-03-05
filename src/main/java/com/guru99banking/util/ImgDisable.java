package com.guru99banking.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.guru99banking.base.com.Base;

public class ImgDisable extends Base {
	@SuppressWarnings("deprecation")
	public static void ffCapabilities() {
		DesiredCapabilities  capabilities = new DesiredCapabilities(); 
		disableFireFoxImages(capabilities);
		  driver = new FirefoxDriver(capabilities);
	}
	
	
	
public static void disableFireFoxImages(DesiredCapabilities capabilities) {
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("permissions.default.image", 2);
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		
	}

}
