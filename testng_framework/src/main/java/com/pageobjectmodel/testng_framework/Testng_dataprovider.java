package com.pageobjectmodel.testng_framework;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testng_dataprovider {

	
	
		@DataProvider(name= "inputs", parallel=true)
		public Object[][] inputProvider(){
			
			Object arr1[] = {3,5,6};
			Object arr2[] = {1,2,4};
			
			//int arr[] = new int[] {1,2,3,4};
			Object final_arr[][] = {arr1,arr2};
			
			return final_arr;
		}
		
		@Test(dataProvider="inputs")
		public void multiply(int a, int b, int c) {
			
			int mul = a*b*c;
			System.out.println("Multiplication answer : "+mul);
		}
		

}
