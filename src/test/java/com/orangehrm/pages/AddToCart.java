package com.orangehrm.pages;

import org.openqa.selenium.WebDriver;

import com.orangehrm.commands.Commands;
import com.orangehrm.extentmanager.ExtentManagerCls;
import com.orangehrm.objects.Web_Objects;

public class AddToCart extends Commands {
	
	ExtentManagerCls reportcls;

	public AddToCart(WebDriver driver) {
		super(driver);
		reportcls=new ExtentManagerCls();
		// TODO Auto-generated constructor stub
	}

	public void AddToCartWithQuantity2(String serachproduct, String product, String quantity) throws InterruptedException {
		Type(Web_Objects.searchbox, serachproduct);	
		reportcls.AddTestcaseSteps("Search for the product: "+product);
		Click(Web_Objects.serachicon);
		reportcls.AddTestcaseSteps("Clicked on Serach icon");
		Click(Web_Objects.ClickOnProduct(product)); //10 sec
		reportcls.AddTestcaseSteps("Clicked on product"+product);
		Type(Web_Objects.quantity, quantity);
		reportcls.AddTestcaseSteps("Entered the quantity: "+quantity);
		String prodname1=GetText(Web_Objects.GetTheProudctName(product));
		Click(Web_Objects.AddToCart);
		Click(Web_Objects.verifyAddToCartButton);
		String prodname2=GetText(Web_Objects.GetTheProductNameAfterAddingProductToTheCart);
		StringValidation(prodname1, prodname2);
		Click(Web_Objects.remove);
	}
	
	public void AddToCartWithQuantityZero(String serachproduct, String product, String quantity, String expected_emptycart_message) throws InterruptedException {
		Type(Web_Objects.searchbox, serachproduct);	
		reportcls.AddTestcaseSteps("Search for the product: "+product);
		Click(Web_Objects.serachicon);
		reportcls.AddTestcaseSteps("Clicked on Serach icon");
		Click(Web_Objects.ClickOnProduct(product)); //10 sec
		reportcls.AddTestcaseSteps("Clicked on product"+product);
		Type(Web_Objects.quantity, quantity);
		reportcls.AddTestcaseSteps("Entered the quantity: "+quantity);
		Click(Web_Objects.AddToCart);
		reportcls.AddTestcaseSteps("Clicked on Add To Cart");
		Click(Web_Objects.verifyAddToCartButton);
		reportcls.AddTestcaseSteps("Go to Add To Cart Window");
		String emptycartmessage= GetText(Web_Objects.EmptyCartMessage);
		reportcls.AddTestcaseSteps("Captured Cart Message when the cart is empty: "+" "+emptycartmessage);
		StringValidation(expected_emptycart_message,emptycartmessage);
		reportcls.AddTestcaseSteps("VALIDATION IS SUCCESSFULLY PASSED");
	}
}
