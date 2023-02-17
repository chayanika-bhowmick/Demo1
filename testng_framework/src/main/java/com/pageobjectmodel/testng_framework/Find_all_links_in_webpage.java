package com.pageobjectmodel.testng_framework;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Find_all_links_in_webpage {

		@Test
		public void open_chrome() throws InterruptedException{	
		System.setProperty("webdriver.chrome.driver","E:\\Chromedriver_108\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// To find all the links links in amazon webpage
		
		int total_links = driver.findElements(By.tagName("a")).size();
		System.out.println("Total webpage links:"+total_links);
		
		// to find all the links in footer section - limiting webdriver scope, creation of footer driver
		
		WebElement footer_driver = driver.findElement(By.xpath("//div[@id='navFooter']"));
		int footer_links = footer_driver.findElements(By.tagName("a")).size();
		
		System.out.println("Footer links:"+footer_links);
		
		// To find all the links from the 1st column in footer section - Dynamic xpath examples/interview questions
		
		WebElement column_driver = footer_driver.findElement(By.xpath(("(//div[@class='navFooterLinkCol navAccessibility'])[1]")));
		
		int column_links = column_driver.findElements(By.tagName("a")).size();
		
		System.out.println("1st column links:"+column_links);
		
		// Print the column names of 1st column
		
		List<WebElement> l1 = column_driver.findElements(By.tagName("a"));
		
		for(int i=0;i<column_links;i++) {
			
			System.out.println("list value:"+l1.get(i).getText());
		}
		
		
		
		driver.quit();
		
		
		
		// Finding mobiles in searchbar
		
		/*WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		searchbox.sendKeys("mobiles");
		searchbox.sendKeys(Keys.ENTER);
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		List<WebElement> l1 = driver.findElements(By.xpath("//*[text()='Limited time deal']"));
		Iterator<WebElement> i = l1.iterator();
		//while(i.hasNext()) {
			i.next();
			System.out.println(l1.size());
			System.out.println("2nd value : "+l1.get(1));
			l1.get(1).click();
			
		//}
			
			//driver.navigate().forward();
			driver.navigate().back();*/
		}
		
	}


