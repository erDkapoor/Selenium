package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver = null;

	public WebDriver initializeDriver() throws IOException {

		String dpPath = "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + dpPath);
		Properties prop = new Properties();
		prop.load(fis);

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.contains("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}
