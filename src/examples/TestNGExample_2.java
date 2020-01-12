package examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample_2 {
	// Annotations
	@BeforeClass
	public void beforeclass() {
		System.out.println("TestNGExample_2 Before Class");
		
	}
	@BeforeTest
	public void beforetest() {
		System.out.println("TestNGExample_2 Before Test");
	}

	@Test
	public void test4() {
		System.out.println("TestNGExample_2 Test4");
	}

	@Test
	public void test5() {
		System.out.println("TestNGExample_2 Test5");

	}
	@Test(groups = {"Group"})
	public void group() {
		System.out.println("TestNGExample_2 Group");
	}

}
