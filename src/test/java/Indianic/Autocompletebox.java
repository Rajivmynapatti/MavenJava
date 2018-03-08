package Indianic;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Autocompletebox {
	
	WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		
		driver=Browserselection.browser("chrome", "http://jqueryui.com/autocomplete/");
		}
	
	@Test
	public void selectfromAutoComplete() throws InterruptedException {
		
		WebElement FrameLocator=driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(FrameLocator);
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tags")));
		
		WebElement TextBox=driver.findElement(By.id("tags"));
		
		TextBox.sendKeys("a");
		selectOptionWithText("Java");
		
		Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void teardown() {
		
		driver.quit();
		System.out.println("User logout successfully");
	}
	
	public void selectOptionWithText(String textToSelect) {
		try {
			WebElement autoOptions = driver.findElement(By.id("ui-id-1"));
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(autoOptions));

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("li"));
			for(WebElement option : optionsToSelect){
		        if(option.getText().equals(textToSelect)) {
		        	System.out.println("Trying to select: "+textToSelect);
		            option.click();
		            break;
		        }
		    }
			
		} catch (NoSuchElementException e) {
			System.out.println(e.getStackTrace());
		}
		catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

}
