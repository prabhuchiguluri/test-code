package com.ebasetek.selenium.tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebasetek.selenium.pageobjects.YahooAutosPage;
import com.ebasetek.selenium.pageobjects.YahooHomePage;
import com.ebasetek.selenium.pageobjects.YahooSearchResultsPage;

public class YahooTest {

	private WebDriver driver;
	private String baseUrl;

	final static Logger logger = Logger.getLogger(YahooTest.class);
	
	@BeforeTest
	public void setUp() {
		logger.info("@Before - setUp");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		baseUrl = "http://www.yahoo.com";
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("@After - tearDown");
	}

	
	@Test
	public void testHomePageTitleWithPageObjects() {
		YahooHomePage homePage = new YahooHomePage(driver);
		homePage.open(baseUrl);
		logger.info("Page title is: " + homePage.getTitle());
		Assert.assertEquals("Yahoo", homePage.getTitle());
		logger.info("@Test - testHomePageTitleWithPageObjects");
	}

	@Test
	public void testSearchResultsPageTitleWithPageObjects() {
		YahooHomePage homePage = new YahooHomePage(driver);
		homePage.open(baseUrl);
		YahooSearchResultsPage searchResultsPage = homePage.search("Selenium");
		logger.info(searchResultsPage.getTitle());
		Assert.assertEquals("Selenium - Yahoo Search Results", searchResultsPage.getTitle());
		logger.info("@Test - testSearchResultsPageTitleWithPageObjects");
	}
	
	@Test
	public void testAutosPageTitleWithPageObjects() {
		YahooHomePage homePage = new YahooHomePage(driver);
		homePage.open(baseUrl);
		YahooAutosPage autosPage = homePage.openAutosSection();
		logger.info(autosPage.getTitle());
		Assert.assertEquals("Yahoo Autos", autosPage.getTitle());
		logger.info("@Test - testHoroscopePageTitleWithPageObjects");
	}
	
}
