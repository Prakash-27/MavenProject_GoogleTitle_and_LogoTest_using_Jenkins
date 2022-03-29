package com.Google;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTitleAndLogoTest {
	
    WebDriver driver;
	
    @Parameters("Browser")
	@BeforeMethod
	public void setUp(String browserName) {
		System.out.println("Parameter value is " + browserName);
		
		if(browserName.contains("Chrome")) {
			//we can also use WebdriverManager to set up Chrome driver -> WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\JenkinsGooglePagelaunch\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.contains("Firefox")) {
			//we can also use WebdriverManager to set up Firefox driver -> WebDriverManager.Firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prakash\\eclipse-workspace\\JenkinsGooglePagelaunch\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		 
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
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
