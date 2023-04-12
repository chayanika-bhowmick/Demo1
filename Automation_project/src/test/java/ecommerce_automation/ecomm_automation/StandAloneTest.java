package ecommerce_automation.ecomm_automation;

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

import ecommerce_automation.ecomm_automation.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StandAloneTest {
	
	public static void main(String[] args) throws InterruptedException {
		
		String product1 = "iphone 13 pro";
		
		// added one line for test
		// 2nd line testing
		// 3rd line testing
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		// login page locators
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement user = driver.findElement(By.id("userEmail"));
		WebElement paswd = driver.findElement(By.id("userPassword"));
		
		//LandingPage lp = new LandingPage(driver);
		StandAloneTest ob1 = new StandAloneTest();
		ob1.sign_in(user,paswd,driver);
		
		// Add items in cart
		
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		
		System.out.println(products.size());
		
		ArrayList<String> cart_products = new ArrayList();
		
		int j=0;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		for(int i=0;i<products.size();i++) {
			
			String txt = products.get(i).findElement(By.tagName("b")).getText();
			
			if(txt.equalsIgnoreCase("iphone 13 pro")) {
				products.get(i).findElement(By.cssSelector(".card-body button:last-of-type")).click();
				
				//Verify if product is successfully added to cart--> finding toast container
				
				wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#toast-container"))));
				
			}
			
		}
		
		// Go to Cart page ->Implemented Explicit wait
		
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable((By.cssSelector(".btn-custom .fa-shopping-cart")))).click();
		
		//Validate items in cart page
		
		List<WebElement> cart_items = driver.findElements(By.cssSelector(".cartSection h3"));
		System.out.println("No. of items in cart : "+cart_items.size());
		
		for(int i=0;i<cart_items.size();i++) {
			
			String item = cart_items.get(i).getText();
			
			if(item.equalsIgnoreCase(product1)) {
				System.out.println(item);
			}
			
		}
		
		// Checkout -->
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		Thread.sleep(3000);
		WebElement checkout_btn = driver.findElement(By.cssSelector(".totalRow .btn-primary"));
		checkout_btn.click();
		
		// Provide payment details in checkout page
		
		/*WebElement personal_info = driver.findElement(By.cssSelector(".form__cc"));
		
		// Credit card number validation
		
		WebElement credit_card = personal_info.findElement(By.cssSelector(".text-validated"));
		//credit_card.sendKeys("4542 9931 9292 2293");
		
		//cvv
		
		wait.until(ExpectedConditions.elementToBeClickable(personal_info.findElement(By.cssSelector(".field .numberCircle")))).sendKeys("123");
		
		//Select Expiry Date 
		
		Select month = new Select(personal_info.findElement(By.cssSelector(".field .ddl")));
		month.selectByValue("12");
		
		Select year = new Select(personal_info.findElement(By.cssSelector(".field .ddl-last-of-type")));
		year.selectByVisibleText("23");*/
		
		//Select Country
		
		driver.findElement(By.cssSelector(".details__user .user__address .text-validated")).sendKeys("India");
		
		//Click place order button
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		Thread.sleep(3000);
		
		
		js.executeScript("window.scrollBy(0,350)","");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit"))).click();
		
		// Thank you page
		
		String text = driver.findElement(By.cssSelector(".hero-primary")).getText();
		
		System.out.println(text);
		
		Assert.assertTrue((text.equalsIgnoreCase("THANKYOU FOR THE ORDER.")));
		
	}
	
	// Sign in function
	
	public void sign_in(WebElement user,WebElement paswd,WebDriver driver) {
		user.sendKeys("chayanikabhowmick2597@gmail.com");
		paswd.sendKeys("Chaya@123");
		
		WebElement login_btn = driver.findElement(By.id("login"));
		login_btn.submit();
		System.out.println(driver.getTitle());
		
	}

}
