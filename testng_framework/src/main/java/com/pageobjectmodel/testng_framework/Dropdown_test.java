package com.pageobjectmodel.testng_framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Dropdown_test {
	@Test
	public void dropdown() throws Exception{
		
		System.setProperty("webdriver.chrome.driver","E:\\Chromedriver_108\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
		
		List<WebElement> l1 = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
		
		System.out.println("List size :"+l1.size());
		
		
		for(int i=1;i<l1.size();i++) {
			
			String val = l1.get(i).getText();
			
			System.out.println("list value"+val);
		}
		// Implement Dropdown
		
		Select drpdwn = new Select(driver.findElement(By.name("country")));
		drpdwn.selectByVisibleText("BANGLADESH");
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
		//Select drp = new Select(driver.findElement(By.id("id")));
		//drp.selectByVisibleText("India");
		
}
}
	
