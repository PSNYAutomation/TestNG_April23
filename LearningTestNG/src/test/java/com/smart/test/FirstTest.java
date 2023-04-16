package com.smart.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	
	@Test
	public void testGoogle() throws Exception {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		driver.findElement(By.name("q")).sendKeys("ProSmart", Keys.ENTER);
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "ProSmart - Google Search";
		//assertEquals(actualTitle, expectedTitle, "Title mismatch");
		assertEquals(actualTitle, expectedTitle, "Test faliled!");
		
		driver.close();		
	}
	
	@Test
	public void testFacebook() throws Exception {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("email")).sendKeys("OrangeHRMTest", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.close();		
	}
	

}
