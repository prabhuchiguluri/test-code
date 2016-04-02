package com.ebasetek.selenium.pojo;

public class TestDataRow {
	String testId;
	String url;
	String value;
	public TestDataRow(String id, String url2, String value2) {
		testId = id;
		url = url2;
		value = value2;
	}
	public String getTestId() {
		return testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
