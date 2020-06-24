package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OurProjects {

	public WebDriver driver = null;

	public OurProjects(WebDriver driver) {
		this.driver = driver;
	}

	By headTitle = By.xpath("//*[contains(text(),'OUR PROJECTS')]");

	public WebElement headTitle() {
		return driver.findElement(headTitle);
	}

}
