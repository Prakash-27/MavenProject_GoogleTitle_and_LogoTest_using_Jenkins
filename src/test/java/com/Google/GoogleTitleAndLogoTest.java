package com.Google;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleAndLogoTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\JenkinsGooglePagelaunch\\chromedriver.exe"); 
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://www.google.com");
	}
	
	
	@Test
	public void googleTitleTest() {
		
		String title = driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Google", "title is not matched");
	}
	
	@Test
	public void googleLogoTest() {
		
		boolean logoname = driver.findElement(By.xpath("//*[@class='k1zIA rSk4se']")).isDisplayed();
		System.out.println(logoname);
		Assert.assertTrue(logoname);
		Assert.assertEquals(logoname, true);
				
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	

}
