package com.orangehrm.testcases;

import org.testng.annotations.Test;

import com.orangehrm.pages.AddToCart;
import com.orangehrm.utilities.TestDataProvider;

public class AddToCartTestCases extends Base {
	
	@Test(priority = 1,enabled = true,dataProvider = "AddToCartWithQuantityZeroTC01_TestData", dataProviderClass = TestDataProvider.class,groups= {"smoke","regression"})
	public void AddToCartWithQuantityZero_TC01(String searchproduct, String product, String quantity, String validationmessage) throws InterruptedException {

		//This is my TC01 comment from Github internet1

		reportclass.CreateTestCaseNameOnTheReport("AddToCartWithQuantityZero_TC01");
		AddToCart addtocart=new AddToCart(driver);
		addtocart.AddToCartWithQuantityZero(searchproduct, product, quantity, validationmessage);
		
	}

	@Test(priority = 2,enabled = true,groups = {"smoke"})
	public void AddToCartWithQuantity2_TC02() throws InterruptedException {
		reportclass.CreateTestCaseNameOnTheReport("AddToCartWithQuantity2_TC02");
		AddToCart addtocart=new AddToCart(driver);
		addtocart.AddToCartWithQuantity2("mac", "iMac", "2");
	}
	

}
