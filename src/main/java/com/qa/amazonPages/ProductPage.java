package com.qa.amazonPages;

import org.openqa.selenium.WebDriver;

import com.qa.amazonPageObjects.ProductPageObjects;

public class ProductPage {
	public WebDriver driver;
	ProductPageObjects pp;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		pp = new ProductPageObjects(driver);
	}

}
