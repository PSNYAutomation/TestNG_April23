package com.smart.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	@Test(dataProvider = "getData")
	public void testData_Provider(String uName, String uPass) {
		System.out.println("User name is > " + uName + " password is >> " + uPass);
	}

	@DataProvider(name = "getData")
	public Object[][] testData() {
		return new Object[][] { 
			{ "userName1", "password1" }, 
			{ "userName2", "password2" },
			{ "userName3", "password3" } 
		};
	}
}
