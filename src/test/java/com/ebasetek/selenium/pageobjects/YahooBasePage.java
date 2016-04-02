package com.ebasetek.selenium.pageobjects;

import org.openqa.selenium.WebDriver;

public class YahooBasePage {
	private WebDriver driver;

	public YahooBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return this.driver.getTitle();
	}
}
