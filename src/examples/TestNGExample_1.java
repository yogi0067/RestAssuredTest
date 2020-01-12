package examples;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGExample_1 {
	@BeforeClass
	public void beforeclass() {
		System.out.println("TestNGExample_1 Before Class");
	}
	@BeforeTest
	public void beforetest() {
		System.out.println("TestNGExample_1 Before Test");
	}

	@Test(description="This is testcase1",dependsOnMethods= {"test3"})
	public void test1() {
		System.out.println("TestNGExample_1 Test1");
	}

	@Test
	public void test2() {
		System.out.println("TestNGExample_1 Test2");
	}
	@Test(groups = {"Group"})
	public void group() {
		System.out.println("TestNGExample_1 Group");
	}

	@Test
	public void test3() {
		System.out.println("TestNGExample_1 Test3");
	}

}
