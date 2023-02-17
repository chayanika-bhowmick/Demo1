package com.pageobjectmodel.testng_framework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Base {
	
	public WebDriver driver;
	
	/*@BeforeMethod
	public void launch_browser() throws IllegalStateException {
		
		System.setProperty("webdriver.chrome.driver","E:\\Chromedriver_108\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		
	}*/
	
	/*@Test(enabled=false)
	//@Parameters({"a","b"})
	public void Search_Item() throws Exception {
		
		driver.findElement(By.xpath("//*[@class='desktop-searchBar']")).sendKeys("shirts");
		// Implement Implicit Wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Shirts For Women']")).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		List<WebElement> l1 = driver.findElements(By.xpath("//*[@class='sort-label ']"));
		for(int i=0;i<l1.size();i++) {
			String s = l1.get(i).getText();
			System.out.println(s);}
	}*/
	
	// Implement DataProvider
	
	@DataProvider(name = "sum values",parallel=true)
	
	public Object[][] data_provider_method(){
		
		Object[] arr1 = new Object[] {2,3};
		Object[] arr2 = new Object[] {5,8};
		
		Object[][] final_arr = {arr1,arr2};
		
		return final_arr;
		//return new Object[][] {{2,3},{5,8}};
	}
	//@Test(threadPoolSize=2,invocationCount = 2)
	@Test (dataProvider = "sum values")
	public void sort_by(int a,int b) throws Exception{
		
		/*List<WebElement> l1 = driver.findElements(By.xpath("//*[@class='sort-label ']"));
		for(int i=0;i<l1.size();i++) {
			String s = l1.get(i).getText();
			System.out.println(s);
		}*/
		
	// printing thread Id
		
		System.out.println("Thread Id for 1st test method : "+Thread.currentThread().getId());
		int s;
		///s = a+b;
		//System.out.println("Sum : "+s);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Explicit wait
		
		
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
		
	
	}
	
	
	
	@Test(dataProvider = "sum values")
	public void multiply(int c,int d) {
		
		// printing thread Id
		System.out.println("Thread Id for 2nd test method : "+Thread.currentThread().getId());
		int m = c*d;
		System.out.println("Mul : "+m);
		
	}
	
	
	
	
	
	@AfterMethod
	public void close_browser() throws Exception {
		
		//driver.close();
	}
	

}
