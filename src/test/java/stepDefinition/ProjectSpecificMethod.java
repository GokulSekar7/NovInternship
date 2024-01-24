package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.testng.AbstractTestNGCucumberTests;

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests {

//	public static ChromeDriver driver;
	public static WebDriverWait wait;
	
	
	private static final ThreadLocal<RemoteWebDriver> rt = new ThreadLocal<RemoteWebDriver>();
	
	public   void click(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch (Exception e) {
			getDriver().executeScript("arguments[0].click();", ele);
		}
		
	}
	
	public  void setDriver() {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
//		ChromeDriver driver = new ChromeDriver(option);
		rt.set(new ChromeDriver(option));
		
		
	}
	
	public   RemoteWebDriver getDriver() {
		return rt.get();
	}
	@BeforeMethod
	public void preCondition() {
//		driver = new ChromeDriver();
		setDriver();
		System.out.println("GetDriver method in before method  : " + getDriver());
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
	}
	
	
	@AfterMethod
	public void postCondition() {
		getDriver().close();
	}
	
	
	
}
