package Kairos.Hunters.TestCases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import Kairos.Hunters.BaseClass.BaseClass;
import Kairos.Hunters.POMclasses.HomePagePOM;
import Kairos.Hunters.POMclasses.LoginPOM;
import junit.framework.Assert;

public class TestCase1 extends BaseClass{
	@Test
	public void login() {
		log.info("Login Start.");
	    LoginPOM login=new LoginPOM(driver);
	    HomePagePOM home=new HomePagePOM(driver);
	    login.signIN(data.fetchProperty("username"), data.fetchProperty("password"));
	    String currentTitle1=browser.presentTitle();
		String expectedTitle1="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		Assert.assertEquals(currentTitle1, expectedTitle1);
		Reporter.log("Title validation Successful",true);
		log.info("Login Successful.");	
		home.clickHamburgerSign();
		Reporter.log("Login Validation Displayed message:- "+home.getUsername(), true);
		log.info("Message displayed- "+home.getUsername());
		login.signOut();
		String currentTitle2=browser.presentTitle();
		String expectedTitle2="Amazon Sign In";
		Assert.assertEquals(currentTitle2, expectedTitle2);
		Reporter.log("Title validation Successful",true);
		Reporter.log("LogOut Successful",true);
		log.info("Logout successful");

	}

}
