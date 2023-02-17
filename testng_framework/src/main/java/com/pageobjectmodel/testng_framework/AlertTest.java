package com.pageobjectmodel.testng_framework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
	
	@Test
	public void remove_duplicate() {
		
		String input = "Jibanika Bhowmick";
		String str = input.toLowerCase();
		String str1[] = str.split(" ");
		
		String final_str = str1[0].concat(str1[1]);
		//System.out.println(final_str);
		
		String[] arr = final_str.split("");
		
		ArrayList<String> arrL = new ArrayList<String>(Arrays.asList(arr));
		
		//System.out.println(arrL);
		
		HashSet hs = new HashSet();
		
		hs.addAll(arrL);
		
		System.out.println(hs);
	}
	

}
