package com.smart.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookTest {

	
	@Test
	public void testFacebook() throws Exception {		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("email")).sendKeys("OrangeHRMTest", Keys.ENTER);
		
		SoftAssert  softAssert = new SoftAssert();
		
		//title assertion
		String actualTitle = driver.getTitle();
		String expectedTitle = "Facebook - log in or sign up";
		softAssert.assertEquals(actualTitle, expectedTitle, "Title mismathch !");
		
		//url assertion
		String actualurl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com";
		softAssert.assertNotEquals(actualurl, expectedUrl, "Url mismatch"); //fail 
		
		//input text assertion 
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "_";
		softAssert.assertEquals(actualText, expectedText, "Text mismatch");  
		
		
		//border assertion 
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(240, 40, 73)";
		softAssert.assertEquals(actualBorder, expectedBorder, "Border mismatch");  
		
		
		//error message assertion
		String actualErrorMessage = driver.findElement(By.xpath("//div[contains(text(),'The email or mobile number ')]")).getText();
		String expectedErrorMessage = "The email or mobile number you entered isn’t connected to an account. Find your account and log in."; 
		softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch");  
		
		
		System.out.println(driver.getTitle());
		Thread.sleep(2000);
		driver.close();	
		
		
		System.out.println("Browser closed and assertion learning is over.");
		softAssert.assertAll();
	}
	
	
}
