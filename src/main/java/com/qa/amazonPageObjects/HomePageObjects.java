package com.qa.amazonPageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class HomePageObjects {

	public WebDriver driver;
	String helloUser = "//span[text()='%s']";

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Hello, Sign in']")
	public WebElement SignIn;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement searchBox;

	@FindBy(xpath = "//*[@id=\"nav-logo\"]")
	public WebElement amazonLogo;

	@FindBy(xpath = "//a[contains(text(),'Try Prime')]")
	public WebElement tryPrimeText;

	public WebElement returnhelloUser() throws IOException {
		String userName = "Hello, " + new base().readProperty("userName");
		return driver.findElement(By.xpath(String.format(helloUser, "Hello, Sign in")));
	}
}
