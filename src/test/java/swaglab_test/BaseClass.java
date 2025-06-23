package swaglab_test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {

		String BrowserName = System.getProperty("Browser");
		DesiredCapabilities cap = new DesiredCapabilities();

		if (BrowserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (BrowserName.equalsIgnoreCase("firefox_grid")) {

			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.WIN11);
			URL Huburl = new URL("http://localhost:4444");
			driver = new RemoteWebDriver(Huburl, cap);

		}

		else if (BrowserName.equalsIgnoreCase("chrome_grid")) {
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.WIN11);
			URL Huburl = new URL("http://localhost:4444");
			driver = new RemoteWebDriver(Huburl, cap);
		}

		else {
			driver = new ChromeDriver();

		}
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}