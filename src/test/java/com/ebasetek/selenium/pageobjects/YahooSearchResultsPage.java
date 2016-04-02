package com.ebasetek.selenium.pageobjects;

import org.openqa.selenium.WebDriver;

public class YahooSearchResultsPage extends YahooBasePage {
	private WebDriver driver;
	public YahooSearchResultsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}	

}
