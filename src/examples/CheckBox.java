package examples;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox extends BaseFunctionClass {

	public static void main(String[] args) throws InterruptedException, IOException {
		login();
		//WebElement Checkbox1 = driver.findElement(By.id("checkBoxOption1"));
//		Checkbox1.click();
//		Thread.sleep(3000);
//		boolean flag = Checkbox1.isSelected();
//		if (flag) {
//			System.out.print("CheckBox 1 is checked ");
//		} else
//			System.out.print("CheckBox 1 is Unchecked");
//		Checkbox1.click();
		Thread.sleep(3000);
//		flag = Checkbox1.isSelected();
//		if (flag) {
//			System.out.print("CheckBox 1 is checked ");
//		} else
//			System.out.print("CheckBox 1 is Unchecked");
//
//		int checkboxcount = driver.findElements(By.xpath("//input[@type='checkbox']")).size();
//		System.out.print(checkboxcount);
		
		closeBrowser();
	}

}
