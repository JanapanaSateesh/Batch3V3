package com.orangehrm.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

	@DataProvider
	public String[][] AddToCartWithQuantityZeroTC01_TestData() throws IOException {
		ReadExcleCls2 readdata=new ReadExcleCls2();
		return readdata.getData("./TestData/AddToCartWithQuantityZeroTC01_TestData.xlsx");
	}
}
