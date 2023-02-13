package ecommerce_automation.ecomm_automation.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import ecommerce_automation.ecomm_automation.ResuableComponents.ReusableComponents;

public class OrderHistoryPage extends ReusableComponents {

	public OrderHistoryPage(WebDriver driver) {
		
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='myorders']")
	public WebElement orders_btn;

	By findBy_orders_btn = By.cssSelector("[routerlink*='myorders']");
	
	@FindBy(css="tr td")
	public List<WebElement> table_records;
	
	By findBy_table_records = By.cssSelector("tr td");
	
	@FindBy(css="#toast-container")
	public WebElement toast_container;
	
	By findBy_toast_container = By.cssSelector("#toast-container");
	
public void click_orders_btn() {
	
	//waitForElemnetToAppear(findBy_toast_container);
	
	//waitForElemnetToDisappear(findBy_toast_container);
	
	scroll_up();
	
	waitForElemnetToAppear(findBy_orders_btn);
	
	orders_btn.click();
}

public String find_order(String product_name) {
	
	waitForElemnetToAppear(findBy_table_records);
	int flag =0;
	String product="";
	for(int i=0;i<table_records.size();i++) {
		
	if(table_records.get(i).getText().equalsIgnoreCase(product_name)) {
		flag=1;
	 product =  table_records.get(i).getText();
	// System.out.println(product);
	
	}
	
	}
	
	if(flag==1)
		return product;
	else
		return null;
	
}
}
