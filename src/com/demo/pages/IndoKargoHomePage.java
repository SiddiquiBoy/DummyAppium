package com.demo.pages;

import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class IndoKargoHomePage {
	
	@FindAll({
		@FindBy(id = "com.in.indokargo:id/button_login"),
	})
	private AndroidElement login_btn;
	@FindAll({
		@FindBy(id = "com.android.permissioncontroller:id/permission_deny_button"),
	})
	private AndroidElement deny_Accesslocationpoup;
	
	public IndoKargoHomePage(AndroidDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// Action Method
	public void clickLoginButton()
	{
		login_btn.click();
	}
	public void denyLocationAccess() 
	{
		deny_Accesslocationpoup.click();
	}
	
	
	
}
