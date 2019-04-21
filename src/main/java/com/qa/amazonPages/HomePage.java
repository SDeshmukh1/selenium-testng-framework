package com.qa.amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.amazonPageObjects.HomePageObjects;

public class HomePage {

	public WebDriver driver;
	HomePageObjects hp;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		hp = new HomePageObjects(driver);
	}

	public void clickOnSignInOnMainPage() {
		hp.SignIn.click();
	}

	public void enterTextOnSearchBox(String text) {
		hp.searchBox.sendKeys(text);
	}
	
}
