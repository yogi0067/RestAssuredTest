package examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseFunctionClass {
	static WebDriver driver =null;

	public static void login() throws IOException, InterruptedException {
		
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"D:\\Learning\\Java\\Automation\\selenium\\basicTests\\src\\examples\\data.properties");
		prop.load(fileInputStream);

		if(prop.getProperty("browser").contains("chrome")) {
		System.setProperty("webdriver.chrome.driver",
				"D://Learning//Java//Automation//selenium//basicTests//tools//chromedriver.exe");
		driver = new ChromeDriver();
		
		}
		else if (prop.getProperty("browser").contains("firefix")) {
			driver = new FirefoxDriver();
		}
		else
		{
			driver= new InternetExplorerDriver();
		}
		driver.get(prop.getProperty("url"));

	}
	public static void closeBrowser()
	{
		driver.close();
	}

}
///basicTests/src/examples/data.properties