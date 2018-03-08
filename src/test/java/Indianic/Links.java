package Indianic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Links {
	
	WebDriver driver;
	@Test
	public void test() {
		
		driver= Browserselection.browser("chrome", "https://www.amazon.com/");
		
		List<WebElement>Links=driver.findElements(By.tagName("a"));
		
		System.out.println(Links.size()); 
	
	}

}
