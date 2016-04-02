package com.ebasetek.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ebasetek.selenium.utils.TestUtils;

public class YahooHomePage extends YahooBasePage {
	private WebDriver driver;
	
	public YahooHomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public boolean open(String url){
		this.driver.get(url);
		return true;
	}
	
	public String getTitle(){
		return this.driver.getTitle();
	}
	
	public YahooSearchResultsPage search(String searchText){
		if(TestUtils.isElementPresent(driver, By.name("p"))){
			WebElement textBox = driver.findElement(By.name("p"));
			textBox.sendKeys(searchText);
			textBox.submit();
			return new YahooSearchResultsPage(driver);
		}else{
			return null;
		}
	}

	public YahooAutosPage openAutosSection() {
		if(TestUtils.isElementPresent(driver, By.partialLinkText("Autos"))){
			WebElement link = driver.findElement(By.partialLinkText("Autos"));
			link.click();
			return new YahooAutosPage(driver);
		}else{
			return null;
		}
		
	}
	
}
