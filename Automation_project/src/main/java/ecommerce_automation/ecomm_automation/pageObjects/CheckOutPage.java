package ecommerce_automation.ecomm_automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce_automation.ecomm_automation.ResuableComponents.ReusableComponents;


public class CheckOutPage extends ReusableComponents{
	
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".details__user .user__address .text-validated")
	WebElement select_country_option;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement select_country_from_drpdwn;
	
	By thankyou_text = By.cssSelector(".hero-primary");
	
	By place_order_findBy = By.cssSelector(".action__submit");
	
	public void select_country_from_drpdwn(String country) throws InterruptedException {
		
		Thread.sleep(3000);
		select_country_option.sendKeys(country);
		
		Thread.sleep(3000);
		select_country_from_drpdwn.click();
		
	}
	
	public void place_order_button() {
		
		scroll_down();
		waitForElemnetToAppear(place_order_findBy);
		driver.findElement(place_order_findBy).click();
	}
	
	public String order_creation_validation() {
		waitForElemnetToAppear(thankyou_text);
		String text = driver.findElement(thankyou_text).getText();
		System.out.println(text);
		return text;
	}
	
	
	
	
	
}  
