package com.Google;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageOpen {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prakash\\eclipse-workspace\\JenkinsGooglePagelaunch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://www.google.com");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		boolean logoname = driver.findElement(By.xpath("//*[@class='k1zIA rSk4se']")).isDisplayed();
		System.out.println(logoname);
		
		driver.quit();

	}
}