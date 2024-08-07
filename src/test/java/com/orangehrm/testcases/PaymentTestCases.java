package com.orangehrm.testcases;

import org.testng.annotations.Test;

public class PaymentTestCases {

	@Test(groups= {"regression"})
	public void Payment1() {
		System.out.println("Payment1");
	}
	
	@Test(groups = {"smoke"} )
	public void Payment2() {
		System.out.println("Payment2");
	}
	
	@Test(groups= {"sanity"})
	public void Payment3() {
		System.out.println("Payment3");
	}
	
	@Test(groups = {"regression"})
	public void Payment4() {
		System.out.println("Payment4");
	}
	
}
