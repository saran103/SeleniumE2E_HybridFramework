package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Registerpage {
	
	WebDriver driver;
	
	@FindBy(name="firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddress;
	
	@FindBy(name="telephone")
	private WebElement telephoneNumber;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name="agree")
	WebElement agree;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement accountSSuccessMessage;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	WebElement newsletterSubscription;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement errorWarningMessage;
	
	public Registerpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void getFirstName(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void getLastName(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void getEmailAddress(String email) {
		emailAddress.sendKeys(email);
	}
	
	public void getTelephoneNumber(String telephone) {
		telephoneNumber.sendKeys(telephone);
	}
	
	public void getPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void getConfirmPassword(String confirmPwd) {
		confirmPassword.sendKeys(confirmPwd);
	}
	
	public void selectAgreeCheckBox() {
		agree.click();
	}
	
	public void clickContinueButton() {
		continueButton.click();
	}
	
	public String verifyAccountSuccessMessage() {
		return accountSSuccessMessage.getText();
	}
	
	public void selectNewsLetterSubscription() {
		newsletterSubscription.click();
	}
	
	public String verifyErrorWarningMessage() {
		return errorWarningMessage.getText();
	}
}
