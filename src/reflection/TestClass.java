package reflection;

import java.util.Date;

public class TestClass {

	public int getTestInteger() {
		return testInteger;
	}
	public void setTestInteger(int testInteger) {
		this.testInteger = testInteger;
	}
	public float getTestFloat() {
		return testFloat;
	}
	public void setTestFloat(float testFloat) {
		this.testFloat = testFloat;
	}
	public String getTestString() {
		return testString;
	}
	public void setTestString(String testString) {
		this.testString = testString;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	int testInteger;
	float testFloat;
	String testString;
	Date testDate;
	
}
