package com.qa.amazonPages;

import org.openqa.selenium.WebDriver;

import com.qa.amazonPageObjects.SignInPageObjects;

public class SignInPage {
	public WebDriver driver;
	SignInPageObjects sp;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		sp = new SignInPageObjects(driver);
	}

	public void enterEmailnSignInPage(String email) {
		sp.email_inputBox.sendKeys("email");
	}

	public void clickOnContinueInSignInPage() {
		sp.continueBtn.click();
	}

	public void enterPassInSignInPage(String password) {
		sp.password.sendKeys(password);
	}

	public void clickOLoginButtonInSignInPage() {
		sp.loginBtn.click();
	}

	public void signInWithCredentials(String email, String password) {
		sp.email_inputBox.sendKeys(email);
		sp.continueBtn.click();
		sp.password.sendKeys("Rosy@123");
		sp.loginBtn.click();
	}
}
