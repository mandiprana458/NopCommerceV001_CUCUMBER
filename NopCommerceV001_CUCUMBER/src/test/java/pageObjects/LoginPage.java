package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver Idriver;
	public LoginPage(WebDriver rdriver)
	{
		Idriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id ="Email")
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(id ="Password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath ="//button[@class='button-1 login-button']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath ="//a[@class='nav-link' and @href='/logout']")
	@CacheLookup
	WebElement lnkLogout;
	public void setUserName(String uname)
	   {
		txtPassword.clear();
		txtPassword.sendKeys(uname);
	   }
	
	public void setPassword(String pwd)
	   {
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		
		}
	public void clickLogin()
	{
		btnLogin.click();
	}
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	

}
