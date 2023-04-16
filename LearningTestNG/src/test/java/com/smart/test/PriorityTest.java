package com.smart.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriorityTest {
	WebDriver driver;
	
	@Test 
	public void launchApplication(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test (priority=2)
	public void enterCredentials() {		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();		
	}
	
	@Test (priority=3)
	public void verifyLogin() {
		WebElement sectionTitle = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
		System.out.println(sectionTitle.isDisplayed());
		System.out.println(sectionTitle.getText());
		//driver.close();
	}
	
	@Test (priority=4, enabled=true)
	public void navigateToMyInfo() {
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
	}
	
	@Test (priority=5)
	public void verifyMyInfo() {
		
		System.out.println(driver.findElement(By.xpath("//h6[text()='PIM']")).isDisplayed());
		driver.close();
	}
	
	
	
	
	
	
	
	

}
