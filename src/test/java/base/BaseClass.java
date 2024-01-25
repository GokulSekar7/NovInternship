package base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import pages.AppLauncherPage;
import pages.HomePage;
import pages.Login;
import pages.WelcomePage;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	
	
	@BeforeMethod
	public Login preCondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return new Login(driver);
		
	}
	
	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
	

}
