package com.ebasetek.selenium.utils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ebasetek.selenium.pojo.TestDataRow;


public class TestUtils {
	public static boolean isElementPresent(WebDriver webDriver, By by) {
		try {
			webDriver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Loads a JSON file and returns back the JSON testData as a List
	 * @param fileName
	 *            File present in the classpath that contains the JSON content
	 * @return a List of testData read from the file
	 * @throws ParseException
	 * @throws IOException
	 */
	public static List<TestDataRow> loadTestData(String fileName)
			throws ParseException, IOException {
		JSONParser parser = new JSONParser();

		URL url = ClassLoader.getSystemResource(fileName);
		if (url != null) {
			FileReader fileReader = new FileReader(url.getFile());
			Object obj = parser.parse(fileReader);
			JSONArray jsonArray = (JSONArray) obj;
			List<TestDataRow> testData = new ArrayList<TestDataRow>();
			TestDataRow tmp = null;
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = (JSONObject) jsonArray.get(i);
				String id = (String) jsonObject.get("id");
				String url2 = (String) jsonObject.get("url");
				String value = (String) jsonObject.get("value");
				tmp = new TestDataRow(id, url2, value);
				testData.add(tmp);
			}

			return testData;
		}else{
			throw new FileNotFoundException("Unable to load file: " + fileName);
		}
	}
}
