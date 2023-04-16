package com.smart.listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ItestListenerClass.class)
public class TestClass1 {

	@Test(priority = 1)
	public void testMethod1() {
		System.out.println("TestClass1 >> testMethod1 ");
	}

	@Test(priority = 2)
	public void testMethod2() {
		System.out.println("TestClass1 >> testMethod2 ");
	}

	@Test( timeOut = 1000, priority = 3)
	public void testMethod3() throws Exception {
		Thread.sleep(2000);
		System.out.println("TestClass1 >> testMethod3 ");
	}

	@Test(dependsOnMethods = "testMethod3", priority = 4)
	public void testMethod4() {
		System.out.println("TestClass1 >> testMethod4 ");
	}

	@Test(priority = 5)
	public void testMethod5() {
		System.out.println("TestClass1 >> testMethod5 ");
	}

	@Test(priority = 6)
	public void testMethod6() {
		System.out.println("TestClass1 >> testMethod6 ");
		Assert.fail();
	}

	@Test(priority = 7)
	public void testMethod7() {
		System.out.println("TestClass1 >> testMethod7 ");
	}

}
