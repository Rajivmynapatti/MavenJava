package Indianic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest extends Browserselection{

	
	WebDriver driver;
	@Test
	public void Logintest() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver2.20\\chromedriver.exe");
		
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		
	LoginPages login=PageFactory.initElements(driver, LoginPages.class);
	
	login.ValidLogin("admin", "demo123");
		
	System.out.println("User has been logged in successfully");
	
	Thread.sleep(3000);
		}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
		
		System.out.println("Browser terminated successfully");
	}
	
}
