package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accountpage {
	
	WebDriver driver;
	
	@FindBy(linkText="Edit your account information")
	WebElement editYourAccountInformation;
	
	public Accountpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyEditAcctInformationIsDisplayed() {
		return editYourAccountInformation.isDisplayed();
	}

}
