package com.smart.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParametersTesting {
	WebDriver driver;
	
	
	@Parameters("browserName")
	@BeforeTest
	public void initializeBrowser(String browserName) {
		
		switch (browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("This browser is not supported !");
			break;
		}
		driver.manage().window().maximize();		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
	}
	
	@Parameters("url")
	@Test
	public void launchApplication (String url) {
		driver.get(url);
	}
	
	@Parameters ({"userName", "password"})	
	@Test
	public void verifyLogin(String userName, String password) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement sectionTitle = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		System.out.println(sectionTitle.isDisplayed());
		System.out.println(sectionTitle.getText());
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
