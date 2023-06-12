package Kairos.Hunters.POMclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	WebDriver d;
	public LoginPOM(WebDriver driver) {
		d=driver;
		PageFactory.initElements(driver,this);
	}

	
	@FindBy(xpath = "(//a[@class='a-button-text'])[1]")
	private WebElement helloSignIN;
	@FindBy(xpath = "//input[@type='email']")
	private WebElement email_phone;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement continueButton;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//input[@id='signInSubmit']")
	private WebElement signInButton;
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	
	public void clickHelloSignIN() {
	   helloSignIN.click();
	}


	public void setEmail_phone(String email_phone) {
		this.email_phone.sendKeys(email_phone);
	}


	public void clickContinueButton() {
		this.continueButton.click();
	}


	public void setPassword(String password) {
		this.password.sendKeys(password);;
	}


	public void clickSignInButton() {
		this.signInButton.click();
	}


	public void signIN(String emailOrPhn,String password) {
		clickHelloSignIN();
		setEmail_phone(emailOrPhn);
		clickContinueButton();
		setPassword(password);
		clickSignInButton();
		
	}
	public void signOut() {
		
		signOut.click();
	}
	
	

}
