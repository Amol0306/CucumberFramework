package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;

	public WebDriver webDriverManager() throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if (driver == null) {
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver(); // driver gets life	
			}
			if (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//src//test//resources//geckodriver.exe");
				driver = new FirefoxDriver(); // driver gets life
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(url);
		}
		return driver;
	}

}
