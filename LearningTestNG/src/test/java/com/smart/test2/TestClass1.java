package com.smart.test2;

import org.testng.annotations.Test;

public class TestClass1 {

	@Test(groups = { "Smoke", "Regression", "E2E" })
	public void testMethod1() {
		System.out.println("TestClass1 >> testMethod1 ");
	}

	@Test(groups = { "Regression" })
	public void testMethod2() {
		System.out.println("TestClass1 >> testMethod2 ");
	}

	@Test(groups = { "Smoke", "Regression" })
	public void testMethod3() {
		System.out.println("TestClass1 >> testMethod3 ");
	}

	@Test(groups = { "Regression" })
	public void testMethod4() {
		System.out.println("TestClass1 >> testMethod4 ");
	}

	@Test(groups = { "Smoke", "Regression" })
	public void testMethod5() {
		System.out.println("TestClass1 >> testMethod5 ");
	}

	@Test(groups = { "Regression" })
	public void testMethod6() {
		System.out.println("TestClass1 >> testMethod6 ");
	}

	@Test(groups = { "Smoke", "Regression", "E2E" })
	public void testMethod7() {
		System.out.println("TestClass1 >> testMethod7 ");
	}

}
