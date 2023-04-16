package com.smart.listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ITestListenerClass2.class)
public class FirstTest extends BaseClass {

	@Test
	public void testGoogle() {
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("ProSmart", Keys.ENTER);
		String actualTitle = driver.getTitle();
		String expectedTitle = "ProSmart - Google Search";
		// assertEquals(actualTitle, expectedTitle, "Title mismatch");
		assertEquals(actualTitle, expectedTitle, "Test faliled!");
	}

	@Test
	public void testFacebook() {
		driver.get("https://www.facebook.com");
		driver.findElement(By.name("email")).sendKeys("OrangeHRMTest", Keys.ENTER);
		System.out.println(driver.getTitle());
	}

	@Test
	public void testOrangeHRMLogin() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement sectionTitle = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		assertTrue(sectionTitle.isDisplayed());
		
	}
}
