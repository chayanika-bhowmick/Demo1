package ecommerce_automation.ecomm_automation.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce_automation.ecomm_automation.ResuableComponents.ReusableComponents;

public class CartPage extends ReusableComponents{
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		
		super(driver);
		
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".btn-custom .fa-shopping-cart")
	WebElement cart_btn;
	
	By cart_btnBy = By.cssSelector(".btn-custom .fa-shopping-cart");
	
	@FindBy(css=".totalRow .btn-primary")
	WebElement checkout_btn;
	
	public void redirect_To_Cart_Page() throws InterruptedException {
		
		Thread.sleep(5000);
		waitForElemnetToAppear(cart_btnBy);
		cart_btn.click();
	}
	
	public void redirectToCheckout() throws InterruptedException {
		
		Thread.sleep(3000);
		scroll_down();
		checkout_btn.click();
	}
	
	
	
	
	
}  
