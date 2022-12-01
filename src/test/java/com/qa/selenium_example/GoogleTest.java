package com.qa.selenium_example;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class GoogleTest {

	WebDriver driver;
	
	@BeforeEach
	void setup() {
		// If driver is not on path, can be manually set this way
//		System.setProperty("webdriver.edge.driver", "/src/test/resources/edgedriver.exe");
		driver = new EdgeDriver();
		// gives every element 3 seconds to appear before throwing an ElementNotFoundException
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	@AfterEach
	void teardown() {
		// release resources after each test
		driver.quit();
	}
	
	@Test
	void searchForCatsTest() throws InterruptedException {
		// use .get() method on the driver to navigate to a link
		driver.get("https://www.google.com");
		
		// WebElement's can be found using findElement() on the driver
		WebElement agreeToCookiesBtn = driver.findElement(By.cssSelector("#L2AGLb")); // or By.id("L2AGLb")
		// We can then use the retrieved element to interact with it
		agreeToCookiesBtn.click();
		
		// Retrieve the search input field by its form input name
		WebElement searchBar = driver.findElement(By.name("q"));
		// use sendKeys() on a web element to type keys
		searchBar.sendKeys("Cats");
		searchBar.submit(); // essentially pressing the enter key on the search input field
		
		String expectedResult = "Cats - Google Search";
		String actualResult = driver.getTitle();
		Assertions.assertEquals(expectedResult, actualResult);
	}
}
