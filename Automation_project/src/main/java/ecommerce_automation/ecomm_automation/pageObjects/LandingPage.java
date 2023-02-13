package ecommerce_automation.ecomm_automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce_automation.ecomm_automation.ResuableComponents.ReusableComponents;

public class LandingPage extends ReusableComponents{
	
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="userEmail")
	WebElement user;
	
	@FindBy(id="userPassword")
	WebElement paswd;
	
	@FindBy(id="login")
	WebElement login_btn;
	
	public void login_application(String email,String password) {
		
		user.sendKeys(email);
		paswd.sendKeys(password);
		login_btn.click();
	}
	
	public void goto_landpage() {
		driver.get("https://rahulshettyacademy.com/client");
		
	}	
	
}  
