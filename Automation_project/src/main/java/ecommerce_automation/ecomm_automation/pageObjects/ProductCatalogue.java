package ecommerce_automation.ecomm_automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ecommerce_automation.ecomm_automation.ResuableComponents.ReusableComponents;

public class ProductCatalogue extends ReusableComponents {
	
	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
		
	By productsBy = By.cssSelector(".mb-3");
	
	By add_to_cart = By.cssSelector(".card-body button:last-of-type");
	
	By toast_container = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElemnetToAppear(productsBy);
		return products;
		
	}
	
	public void addProductToCart(String prod_name) {
		
		for(int i=0;i<products.size();i++) {
			
			String txt = products.get(i).findElement(By.tagName("b")).getText();
			
			if(txt.equalsIgnoreCase(prod_name)) {
				products.get(i).findElement(add_to_cart).click();
				waitForElemnetToAppear(toast_container);
	}
		}
	}
}  
