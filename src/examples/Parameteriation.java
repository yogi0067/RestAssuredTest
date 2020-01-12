package examples;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameteriation {

	@DataProvider
	public Object[][] returndata()
	{
		Object[][] data = new Object[2][2];
		data[0][0] = "Name1";
		data[0][1] = "Pass1";
		data[1][0] = "Name2";
		data[1][1] = "Pass2";
		return data;
		
	}
	
	
	@Test(dataProvider = "returndata")
	public void getdata(String name, String password)
	{
		System.out.println(name);
		System.out.println(password);
	}
	@Parameters({"Name","Pass"})
	@Test
	public void xmlparemeter(String name, String password)
	{
		System.out.println(name);
		System.out.println(password);
	}
	@Test
	public void TestFailure()
	{
		System.out.println("Test is Failed");
		Assert.assertTrue(false);
	}
}
