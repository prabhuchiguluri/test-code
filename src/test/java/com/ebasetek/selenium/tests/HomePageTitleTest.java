package com.ebasetek.selenium.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ebasetek.selenium.pojo.TestDataRow;
import com.ebasetek.selenium.utils.TestUtils;

public class HomePageTitleTest {

	private WebDriver driver;
	private String baseUrl;
	private List<TestDataRow> testData;

	final static Logger logger = Logger.getLogger(HomePageTitleTest.class);
	
	@BeforeTest
	public void setUp() throws ParseException, IOException {
		logger.info("@Before - setUp");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		testData = TestUtils.loadTestData("testdata.json");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
		logger.info("@After - tearDown");
	}

	@Test
	public void testHomePageTitle() {
		for (Iterator<TestDataRow> iterator = testData.iterator(); iterator.hasNext();) {
			TestDataRow testDataRow = (TestDataRow) iterator.next();
			baseUrl = testDataRow.getUrl();
			driver.get(baseUrl);
			logger.info("Page title is: " + driver.getTitle());
			Assert.assertEquals(testDataRow.getValue(), driver.getTitle());
			logger.info("@Test - testPageTitle");
		}	
	}
	
}
