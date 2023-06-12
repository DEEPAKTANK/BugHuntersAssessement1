package Kairos.Hunters.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePOM {
	
	WebDriver d;
	public HomePagePOM(WebDriver driver) {
		d=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//i[@class='hm-icon nav-sprite']")
	private WebElement hamburgerSign;
	@FindBy(xpath = "//div[@id='hmenu-customer-name']//b[1]")
	private WebElement username;
	
	public void clickHamburgerSign() {
		this.hamburgerSign.click();
	}
	public String getUsername() {
		return username.getText();
		
	}

}
