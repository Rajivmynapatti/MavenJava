package Indianic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HandleAlert {
	
	WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		
		driver= Browserselection.browser("chrome", "http://tizag.com/javascriptT/javascriptalert.php");
	}
		@Test
		public void AlertButton() throws InterruptedException {
	
			WebElement button=driver.findElement(By.cssSelector("[type='button']"));
			button.click();
			Thread.sleep(3000);
				Alert al=driver.switchTo().alert();
				System.out.println(al.getText());

				al.accept();
	}

		@AfterTest
		public void teardown() {
	
				driver.quit();
}

}
