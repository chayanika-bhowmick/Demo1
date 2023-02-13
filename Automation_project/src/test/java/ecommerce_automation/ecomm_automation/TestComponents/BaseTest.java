package ecommerce_automation.ecomm_automation.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import ecommerce_automation.ecomm_automation.pageObjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;
	//@BeforeMethod
	public WebDriver initializeDriver() throws IOException {
		
		// Properties file
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\ecommerce_automation\\ecomm_automation\\resources\\globalDataConfig.properties");
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
		return driver;
	}
	
	public void launchApplication() throws IOException {
		
		driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
	}
}
