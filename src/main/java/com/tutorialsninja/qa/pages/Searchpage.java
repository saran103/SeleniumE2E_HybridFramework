package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Searchpage {
	
	WebDriver driver;
	
	@FindBy(name="search")
	WebElement searchText;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	WebElement searchIcon;
	
	@FindBy(linkText="HP LP3065")
	WebElement searchedProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	WebElement searchMessage;
	
	public Searchpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterSearchText(String product) {
	 searchText.sendKeys(product);
	}
	
	public void clickSearchIcon() {
		searchIcon.click();
		}
	
	public boolean verifyResultedProduct() {
		return searchedProduct.isDisplayed();
	}

	
	public String getSearchMessage() {
		return searchMessage.getText();
	}
}
