package com.qa.amazonTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.amazonPageObjects.HomePageObjects;
import com.qa.amazonPageObjects.SignInPageObjects;
import com.qa.amazonPages.SignInPage;

import Resources.base;

public class AmazonSignInTest extends base {

	public WebDriver driver;
	SignInPageObjects signInPageObjects;
	SignInPage signInPage;
	HomePageObjects homePageObjects;

	@BeforeClass
	public void initiliazeObjectsInSignInPage() throws IOException {
		driver = initializeDriver();
		signInPage = new SignInPage(driver);
		signInPageObjects = new SignInPageObjects(driver);
		homePageObjects = new HomePageObjects(driver);
		driver.get(readProperty("URL"));
	}

	@Test(priority = 1)
	public void checkSignInFunctionality() throws IOException {
		homePageObjects.SignIn.click();
		signInPage.signInWithCredentials(readProperty("email"), readProperty("password"));
	}

}
