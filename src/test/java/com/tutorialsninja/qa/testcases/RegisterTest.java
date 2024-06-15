package com.tutorialsninja.qa.testcases;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.Base;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.Registerpage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends Base{
	
	public WebDriver driver;
	Registerpage register;
	
	
	@DataProvider(name="getTestDataFromExcel")
	public Object[][] getTestData() {
		Object[][] data = Utilities.getTestDataFromExcel("Register");
		return data;
	}
	
	@BeforeMethod
	public void setUp() {
		loadPropertiesFile();
		driver = initializeBrowserAndLaunchApp(prop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		register = homepage.navigateToRegistrationPage();
	}
	
	@Test(dataProvider="getTestDataFromExcel")
	public void verifyRegisteringAnAccountWithMandatoryFields(String firstName, String lastName, String telephone, String password, String confirmPassword) {
		System.out.println(firstName +""+lastName +""+telephone+ ""+password+ ""+confirmPassword);
		register.getFirstName(firstName);
		register.getLastName(lastName);
		register.getEmailAddress(Utilities.getGenerateEmailDateTimeStamp());
		register.getTelephoneNumber(telephone);
		register.getPassword(password);
		register.getConfirmPassword(confirmPassword);
		register.selectAgreeCheckBox();
		register.clickContinueButton();
		String expectedAccountSuccessMessage = dataProp.getProperty("acctCreated");
		Assert.assertEquals(expectedAccountSuccessMessage, register.verifyAccountSuccessMessage(), "Account success message is not displayed");
		
	}
	
	@Test(dataProvider="getTestDataFromExcel")
	public void verifyRegisteringAnAcccountByProvidingAllFields(String firstName, String lastName, String telephone, String password, String confirmPassword) {
		register.getFirstName(firstName);
		register.getLastName(lastName);
		register.getEmailAddress(Utilities.getGenerateEmailDateTimeStamp());
		register.getTelephoneNumber(telephone);
		register.getPassword(password);
		register.getConfirmPassword(confirmPassword);
		register.selectNewsLetterSubscription();
		register.selectAgreeCheckBox();
		register.clickContinueButton();
		String expectedAccountSuccessMessage = dataProp.getProperty("acctCreated");
		Assert.assertEquals(expectedAccountSuccessMessage, register.verifyAccountSuccessMessage(), "Account success message is not displayed");
		
	}
	
	@Test
	public void verifyErrorMessagesForMandatoryFields() {
		register.clickContinueButton();
		String warningMessage = register.verifyErrorWarningMessage();
		Assert.assertEquals(dataProp.getProperty("acctCreationErrMsg"), warningMessage);	
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
