package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import pages.Login;

public class BaseClass extends AbstractTestNGCucumberTests{
	
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public ExtentReports extent;
	public String testcaseName, testcaseDesc, authorName, categoryName;
	public static ExtentTest node;
	
	@BeforeMethod
	public void preCondition() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
	}
	
	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
	
	
	
	//Report Configuration
	
	@BeforeSuite
	public void startReport() {
		
		//Locate the path of our report file
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File("./reports/result.html"));
		
		//Create obj for report
		extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
	}
	
	
	@BeforeClass
	public void setReportDetails() {
		ExtentTest test = extent.createTest(testcaseName, testcaseDesc);
		test.assignAuthor(authorName);
		test.assignCategory(categoryName);
		node = test.createNode(testcaseName);
		
	}
	
	
	public int takeSnap() {
		
		int random = (int) ((Math.random())*999999);
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+random+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return random;
		
	}
	
	
	public void reportStep(String status, String desc) {
		
		if(status.equalsIgnoreCase("pass")) {
			try {
				node.pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			} catch (IOException e) {
				
			}
		}else if (status.equalsIgnoreCase("fail")) {
			try {
				node.fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			} catch (IOException e) {
				
		}
		
	}

}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
}

