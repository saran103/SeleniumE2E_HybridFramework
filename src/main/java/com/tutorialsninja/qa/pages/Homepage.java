package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	WebElement registerOption;
	
	//Constructor
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	//Actions	
	public Loginpage navigateToLoginPage() {
		myAccountDropMenu.click();
		loginOption.click();
		return new Loginpage(driver);
	}
	
	public Registerpage navigateToRegistrationPage() {
		myAccountDropMenu.click();
		registerOption.click();
		return new Registerpage(driver);
	}

}
