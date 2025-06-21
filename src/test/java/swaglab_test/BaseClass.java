package swaglab_test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		
		String BrowserName =System.getProperty("Browser");
		
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		
		else {
			driver= new ChromeDriver();
			
		}
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}