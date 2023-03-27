package com.demo.testcase;
import org.testng.annotations.Test;
import com.demo.pages.IndoKargoHomePage;
public class AppDemo extends BaseClass {

	@Test(priority = 1)
	public void verifyLoginUI() throws InterruptedException
	{   
		IndoKargoHomePage homepage=new IndoKargoHomePage(driver);
		homepage.clickLoginButton();
		homepage.denyLocationAccess();
	}
	
	
}
