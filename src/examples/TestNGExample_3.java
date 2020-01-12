package examples;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Test;

public class TestNGExample_3 {
	@BeforeSuite
	public void beforeclass() {
		System.out.println("TestNGExample_3 Before Suite");

	}

	@BeforeMethod
	public void beforetest() {
		System.out.println("TestNGExample_3 Before Method");
	}

	@Test(groups = {"Group"})
	public void group() {
		System.out.println("TestNGExample_3 Group");
	}
	@Test
	public void test6() {
		System.out.println("TestNGExample_3 Test6");

	}
	@AfterMethod
	public void aftermethod() {
		System.out.println("TestNGExample_3 After Method");

	}

}
