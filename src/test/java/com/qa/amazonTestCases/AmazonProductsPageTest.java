package com.qa.amazonTestCases;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.amazonPageObjects.HomePageObjects;
import com.qa.amazonPageObjects.ProductPageObjects;
import com.qa.amazonPages.HomePage;

import Resources.base;

public class AmazonProductsPageTest extends base {
	HomePage hp;
	HomePageObjects homePageObjects;
	ProductPageObjects productPageObjects;
	WebDriver driver;

	@BeforeClass(alwaysRun=true)
	public void inializeAmazonProductsPageTest() throws IOException {
		driver = StartStopDriver.driver;
		homePageObjects = new HomePageObjects(driver);
		productPageObjects = new ProductPageObjects(driver);
		hp = new HomePage(driver);
		driver.get(readProperty("URL"));
	}

	@Test(groups = { "smoke" }, dataProvider = "getData")
	public void checkProductSearchFuntionality(String productName) throws IOException {
		hp.enterTextOnSearchBox(productName);
		Actions actions = new Actions(driver);
		for (int i = 0; i < 10; i++) {
			if (!homePageObjects.searchBox.getAttribute("value").equals(productName)) {
				actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			} else {
				actions.sendKeys(Keys.ENTER).build().perform();
			}
		}
		Assert.assertEquals(productPageObjects.productName.getText(), "\"" + productName + "\"");
		driver.get(readProperty("URL"));
	}

	@DataProvider
	public Object[] getData() {
		Object[] data = new Object[3];
		data[0] = "redmi 7 pro phone mobile";
		data[1] = "colgate total";
		data[2] = "motorola g5s plus";
		return data;
	}
}
