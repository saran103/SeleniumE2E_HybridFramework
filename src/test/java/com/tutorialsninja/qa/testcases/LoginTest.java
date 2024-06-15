package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Accountpage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Loginpage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends Base{
	
	public WebDriver driver;
	Loginpage loginpage;
	
	@DataProvider(name="getTestDataFromExcel")
	public Object[][] getTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Login");
		return data;
	}
	
	@BeforeMethod
	public void setUp() {
		loadPropertiesFile();
		driver = initializeBrowserAndLaunchApp(prop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		loginpage = homepage.navigateToLoginPage();
	}
	
	@Test(priority=1, dataProvider="getTestDataFromExcel")
	public void verifyLoginWithValidCredentials(String email, String password) {
		System.out.println(email + " " + password);
		loginpage.login(prop.getProperty("validEmail"), prop.getProperty("validPassword"));
		Accountpage accountpage = new Accountpage(driver);
		Assert.assertTrue(accountpage.verifyEditAcctInformationIsDisplayed(), "Edit your information is not displayed.");	
	
	}
	
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials() {
		loginpage.login(Utilities.getGenerateEmailDateTimeStamp(), dataProp.getProperty("invalidPassword"));
		String warningMessage = loginpage.verifyInvalidLoginWarningMessage();
		Assert.assertEquals(dataProp.getProperty("invalidPasswordWarningMessage"), warningMessage);	
	
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
}
