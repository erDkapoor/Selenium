package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver driver;

	public loginPage(WebDriver driver) {
		this.driver = driver;
	}

	By practiseProjects = By.partialLinkText("Practice Projects");
	By yourName = By.name("name");
	By email = By.name("email");
	By agreeterms = By.name("agreeTerms");

	public WebElement practiseProjects() {
		driver.findElement(practiseProjects).click();
		return driver.findElement(practiseProjects);
	}

	public WebElement yourName() {
		return driver.findElement(yourName);
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement agreeTerms() {
		 driver.findElement(agreeterms).click();
		 driver.findElement(agreeterms).submit();
		 ourProjects op=new ourProjects(driver);
		 return op.headTitle();
	}
}
