package com.qa.amazonTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.amazonPageObjects.HomePageObjects;
import com.qa.amazonPages.HomePage;
import com.qa.amazonTestCases.StartStopDriver;

import Resources.base;

public class AmazonHomeTest extends base {
	HomePage homePage;
	HomePageObjects homePageObjects;
	WebDriver driver;
	
	@BeforeClass(alwaysRun=true)
	public void initializeHomePageObjects() throws IOException {
		this.driver = StartStopDriver.driver;
		homePage = new HomePage(driver);
		homePageObjects = new HomePageObjects(driver);
		driver.get(readProperty("URL"));
	}

	@Test(priority = 1, groups= {"smoke"})
	public void checkContentOnHomePage() throws IOException {
		Assert.assertTrue(!homePageObjects.amazonLogo.isDisplayed());
		Assert.assertEquals(homePageObjects.tryPrimeText.getText(), "Try Prime");
		Assert.assertTrue(homePageObjects.searchBox.isDisplayed());
		homePageObjects.returnhelloUser().getText().equals("Hello, Sign in");
		System.out.println("Home Page Test Case Passed");
	}

	@Test(priority = 3, groups = {"sanity"})
	public void checkLoginFunctionality() {
		homePage.clickOnSignInOnMainPage();
		if (driver.getCurrentUrl().contains("https://www.amazon.in/ap/signin")) {
			System.out.println("Login Test Case Passed");
		}
	}

	@Test(priority = 2)
	public void checkTextEnteredInSearchBox() {
		homePage.enterTextOnSearchBox("toothPaste");
		Assert.assertEquals(homePageObjects.searchBox.getAttribute("value"), "toothPaste");
		System.out.println("Search Test Box Test Case Passed");
	}
}
