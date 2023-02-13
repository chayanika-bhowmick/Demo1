package ecommerce_automation.ecomm_automation;

import org.testng.annotations.Test;

public class Summation {

	@Test(groups= {"Sum test"})
	public void sum(int a, int b) {
		
		int s= a+b;
		System.out.println(s);
	}
}
