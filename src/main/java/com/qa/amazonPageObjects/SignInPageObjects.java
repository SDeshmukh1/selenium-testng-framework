package com.qa.amazonPageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Resources.base;

public class SignInPageObjects {

	public WebDriver driver;
	public final String helloUser = "//*[contains(text(),'%s')]";

	public SignInPageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[text()='Login']")
	public WebElement loginHeader;

	@FindBy(xpath = "//input[@name='email']")
	public WebElement email_inputBox;

	@FindBy(xpath = "//input[@id='continue']")
	public WebElement continueBtn;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	public WebElement loginBtn;

}
