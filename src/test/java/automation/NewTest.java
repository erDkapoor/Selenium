package automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.loginPage;
import resources.base;

public class NewTest extends base {
	public WebDriver driver = null;
	

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();

	}

	@Test
	public void ValidateTitle() throws InterruptedException {

		String title = "Rahul Shetty Academy";
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), title);
		loginPage lp=new loginPage(driver);
		lp.practiseProjects();
	}

	@Test
	public void login() throws InterruptedException
	{
		loginPage lp=new loginPage(driver);
		lp.yourName().sendKeys("Deepak Kapoor");
		lp.email().sendKeys("er.deepak.kapoor@outlook.com");
		lp.agreeTerms();
		Assert.assertEquals(lp.agreeTerms().getText(),"OUR PROJECTS");
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
