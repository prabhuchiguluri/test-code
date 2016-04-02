package com.ebasetek.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ebasetek.selenium.utils.TestUtils;

public class YahooAutosPage extends YahooBasePage {
	private WebDriver driver;

	public YahooAutosPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public YahooAutosExoticsPage openExoticCars() {
		if(TestUtils.isElementPresent(driver, By.partialLinkText("Exotics"))){
			WebElement link = driver.findElement(By.partialLinkText("Exotics"));
			link.click();
			return new YahooAutosExoticsPage(driver);
		}else{
			return null;
		}
		
	}
}
