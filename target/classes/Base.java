package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public WebDriver driver = null;

	private static Logger log = LogManager.getLogger(Base.class.getName());

	public WebDriver initializeDriver() throws IOException {
		log.debug("Hello this is a debug message");
		log.info("Hello this is an info message");
		log.error(" error");
		String dpPath = "\\src\\main\\java\\resources\\data.properties";
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + dpPath);
		Properties prop = new Properties();
		prop.load(fis);

		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browser.contains("chrome")) {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}
}
