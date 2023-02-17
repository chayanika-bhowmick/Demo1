package com.pageobjectmodel.testng_framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertTest {

	@Test
		public void alertTest() {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Basic Auth")).click();
		
		//System.out.println(driver.switchTo().alert().getText());
		
		//driver.switchTo().alert().accept();
		
		String text = driver.findElement(By.tagName("p")).getText();
		
		System.out.println(text);
		
		Assert.assertEquals(text,"Congratulations! You must have the proper credentials.");
		
		
		
		

	}

}
