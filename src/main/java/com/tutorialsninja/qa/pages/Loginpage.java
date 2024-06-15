package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	WebDriver driver;
	//Objects
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement invalidLoginWarningMessage;
	
	//Constructors
	public Loginpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void login(String email, String password) {
		emailAddress.sendKeys(email);
		passwordField.sendKeys(password);
		loginButton.click();
		
	}
	
	public String verifyInvalidLoginWarningMessage() {
		return invalidLoginWarningMessage.getText();
	}
}
