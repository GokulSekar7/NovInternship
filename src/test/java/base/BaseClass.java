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
	
//	public RemoteWebDriver driver;
//	public WebDriverWait wait;
	public static ExtentReports extent;
	public String testcaseName, testcaseDesc, authorName, categoryName;
//	public static ExtentTest node;
	
	private static ThreadLocal<RemoteWebDriver > rt = new ThreadLocal<RemoteWebDriver>();
	
	private static ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();
	
	private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
	
	private static ThreadLocal<ExtentTest> node = new ThreadLocal<ExtentTest>();
	
	private static ThreadLocal<String> testName = new ThreadLocal<String>();
	
	
	public void setDriver() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
//		driver = new ChromeDriver(option);
		rt.set(new ChromeDriver(option));
	}
	
	public RemoteWebDriver getDriver() {
		return rt.get();
	}
	
	
	public void setWait() {
		wait.set(new WebDriverWait(getDriver(), Duration.ofSeconds(10)));
	}
	
	public WebDriverWait getWait() {
		return wait.get();
	}
	
	
	@BeforeMethod
	public void preCondition() {
		setDriver();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		setWait();
		
	}
	
	@AfterMethod
	public void postCondition() {
		getDriver().quit();
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
	
	
	public void setTestName() {
		testName.set(testcaseName);
	}
	
	public String getTestName() {
		return testName.get();
	}
	
	public void setNode() {
		
		node.set(parentTest.get().createNode(getTestName()));
	}
	
	public ExtentTest getNode() {
		return node.get();
	}
	
	
	@BeforeClass
	public void setReportDetails() {
		ExtentTest childTest = extent.createTest(testcaseName, testcaseDesc);
		childTest.assignAuthor(authorName);
		childTest.assignCategory(categoryName);
		parentTest.set(childTest);
		setTestName();
//		node = childTest.createNode(testcaseName);
		setNode();
		
	}
	
	
	public int takeSnap() {
		
		int random = (int) ((Math.random())*999999);
		
		File src = getDriver().getScreenshotAs(OutputType.FILE);
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
				getNode().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			} catch (IOException e) {
				
			}
		}else if (status.equalsIgnoreCase("fail")) {
			try {
				getNode().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
			} catch (IOException e) {
				
		}
		
	}

}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
}

