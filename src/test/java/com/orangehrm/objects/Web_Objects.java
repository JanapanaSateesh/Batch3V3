package com.orangehrm.objects;

import org.openqa.selenium.By;

public class Web_Objects {

	//-------------Login Page Objects-------------
	public static By username=By.id("input-email");
	public static By password=By.id("input-password");
	public static By loginbutton=By.xpath("//input[@value='Login']");
	
	//--------Search Product-------------
	public static By searchbox=By.name("search");
	public static By serachicon=By.xpath("//div[@id='search']//span");
	public static By ClickOnProduct(String product) {
		 return By.xpath("//a[text()='"+product+"']");
	}
	public static By quantity=By.name("quantity");
	public static By AddToCart=By.id("button-cart");
	public static By verifyAddToCartButton=By.xpath("//span[@id='cart-total']/..");
	public static By remove=By.xpath("//button[@title='Remove']");
	
	//--------------Add To Cart----------------
	public static By GetTheProudctName(String product) {
		return By.xpath("//h1[text()='"+product+"']");
		
	}
	
	public static By GetTheProductNameAfterAddingProductToTheCart=By.xpath("(//table[@class='table table-striped']//a)[2]");
	public static By EmptyCartMessage=By.xpath("//div[@id='cart']//ul//p");
	
}
