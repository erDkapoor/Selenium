package automation;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class NewTest extends Base {
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
		LoginPage lp=new LoginPage(driver);
		lp.practiseProjects();
	}

	@Test
	public void login() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.yourName().sendKeys("Deepak Kapoor");
		lp.email().sendKeys("er.deepak.kapoor@outlook.com");
		lp.agreeTerms();
		Thread.sleep(1000);
		Assert.assertEquals(lp.agreeTerms().getText(),"OUR PROJECTS");
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
