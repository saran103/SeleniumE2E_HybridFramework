package com.tutorialsninja.qa.testcases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Searchpage;

public class SearchTest extends Base{
	
	public WebDriver driver;
	Searchpage searchpage;
	
	
	@BeforeMethod
	public void setUp() {
		loadPropertiesFile();
		driver = initializeBrowserAndLaunchApp(prop.getProperty("browser"));
		searchpage = new Searchpage(driver);
	}
	
	@Test(priority=1)
	public void verifySearchWithValidProduct() { 
		searchpage.enterSearchText("HP");
		searchpage.clickSearchIcon();
		Assert.assertTrue(searchpage.verifyResultedProduct(), "Valid product HP is not displayed in the search results.");
	}
	
	@Test(priority=2)
	public void verifySearchWithInValidProduct() {
		Searchpage searchpage = new Searchpage(driver);
		searchpage.enterSearchText("Honda");
		searchpage.clickSearchIcon();
		String actualSearchMessage = searchpage.getSearchMessage();
		Assert.assertEquals(actualSearchMessage, dataProp.getProperty("noProductFoundMessage"), "No product in search results.");
	
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
