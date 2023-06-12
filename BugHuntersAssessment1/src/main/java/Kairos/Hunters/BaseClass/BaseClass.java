package Kairos.Hunters.BaseClass;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Kairos.Hunters.Library.DataUtility;
import Kairos.Hunters.Library.HuntersBrowser;
import Kairos.Hunters.Library.LoggerClass;
import Kairos.Hunters.POMclasses.LoginPOM;

@Listeners(Kairos.Hunters.Library.ListenerUtility.class)
public class BaseClass {
	public static WebDriver driver;
	public HuntersBrowser browser = new HuntersBrowser(driver);
	protected LoggerClass log = new LoggerClass();
	protected DataUtility data=new DataUtility();
	
	
	@BeforeTest
	public void openBrowser() {
		driver=browser.openBrowser("edge");
		log.info("Browser is opened.");

	}
	@BeforeClass
	public void openAmazon() {
	browser.openURL(data.fetchProperty("BaseURL"));
	log.info("URL is opened.");

	browser.maximiseWindow(driver);
	browser.waitForElementsToLoadInDOM(driver);
	
	}
	@BeforeMethod
	public void logIn() {
		
	}
	
	@AfterMethod
	public void logOut() {
		log.info("Logout");	
	}
	@AfterClass
	public void closeBrowser() {
		browser.terminate();
		log.info("Browser is Closed.");

	}
}













