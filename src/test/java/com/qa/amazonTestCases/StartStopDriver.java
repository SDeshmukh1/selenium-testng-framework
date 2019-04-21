package com.qa.amazonTestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import Resources.base;

public class StartStopDriver extends base{

	public static WebDriver driver;

    @BeforeSuite(alwaysRun=true)
    public void Setup() throws IOException {
    driver = initializeDriver();
    }
    
    @AfterSuite(alwaysRun=true)
	public void TearDown() {
		driver.close();
	}
}
