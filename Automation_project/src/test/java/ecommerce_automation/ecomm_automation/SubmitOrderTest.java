package ecommerce_automation.ecomm_automation;



import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ecommerce_automation.ecomm_automation.TestComponents.BaseTest;
import ecommerce_automation.ecomm_automation.pageObjects.CartPage;
import ecommerce_automation.ecomm_automation.pageObjects.CheckOutPage;
import ecommerce_automation.ecomm_automation.pageObjects.LandingPage;
import ecommerce_automation.ecomm_automation.pageObjects.OrderHistoryPage;
import ecommerce_automation.ecomm_automation.pageObjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	
	public WebDriver driver;
	public String product1;
	@Test
	public void submitOrder() throws InterruptedException, IOException {
		
		product1 = "iphone 13 pro";
		String country = "India";
		//String product2 = "zara coat 3";
	
		
		driver = initializeDriver();

		LandingPage lp = new LandingPage(driver);
		
		lp.goto_landpage();
		
		lp.login_application("chayanikabhowmick2597@gmail.com", "Chaya@123");
		
		// Add items in cart
		
		ProductCatalogue pc = new ProductCatalogue(driver);
		pc.getProductList();
		pc.addProductToCart(product1);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Go to Cart page ->Implemented Explicit wait
		CartPage cp = new CartPage(driver);
		cp.redirect_To_Cart_Page();
		
		//Validate items in cart page
		
		/*List<WebElement> cart_items = driver.findElements(By.cssSelector(".cartSection h3"));
		System.out.println("No. of items in cart : "+cart_items.size());
		
		for(int i=0;i<cart_items.size();i++) {
			
			String item = cart_items.get(i).getText();
			
			if(item.equalsIgnoreCase(product1)) {
				System.out.println(item);
			}
			
		}*/
		
		// Checkout -->
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		cp.redirect_To_Cart_Page();
		
		//Select Country
		
		CheckOutPage chp = new CheckOutPage(driver);
		cp.redirectToCheckout();
		chp.select_country_from_drpdwn(country);
		
		
		//Click place order button

		chp.place_order_button();
		
		// Thank you page
		
		String text = chp.order_creation_validation();
		
		Assert.assertTrue((text.equalsIgnoreCase("THANKYOU FOR THE ORDER.")));
		
	}
	
	// Dependency test in testNG
	
	@Test(dependsOnMethods= {"submitOrder"})
	public void OrderHistory() {
		
		OrderHistoryPage op = new OrderHistoryPage(driver);
		op.click_orders_btn();
		
		String prod = op.find_order(product1);
		
		
		System.out.println(prod);
		
		//Assert.assertEquals(prod,product1);
		
	}

}

