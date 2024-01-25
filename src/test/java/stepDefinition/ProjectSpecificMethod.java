package stepDefinition;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

public class ProjectSpecificMethod extends AbstractTestNGCucumberTests {

//	public static ChromeDriver driver;
	public static WebDriverWait wait;
	public static ExtentReports extent;
	public String testCaseName, testDes, author, category;
//	public ExtentTest node1;
	
	private static final ThreadLocal<RemoteWebDriver> rt = new ThreadLocal<RemoteWebDriver>();

	public static final ThreadLocal<ExtentTest>  node  = new ThreadLocal<ExtentTest>();
	public static final ThreadLocal<ExtentTest>  test= new ThreadLocal<ExtentTest>();
	public static final ThreadLocal<String>  testName  = new ThreadLocal<String>();

// Click method -------------------------------------------------------------------------------------
	public   void click(WebElement ele) {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
			ele.click();
			
		} catch (Exception e) {
			getDriver().executeScript("arguments[0].click();", ele);
		}
		
	}
// Driver --------------------------------------------------------------------
	
	
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
	

// Report ------------------------------------------------------------------------------------------	
	
	@BeforeSuite
	public void startReport() {
		ExtentHtmlReporter reporter  = new ExtentHtmlReporter("./reports/result.html");
		extent = new ExtentReports();
		reporter.setAppendExisting(true);
		extent.attachReporter(reporter);
	}
	
	public void setTest() {
		ExtentTest parentTest = extent.createTest(testCaseName, testDes);
		parentTest.assignAuthor(author);
		parentTest.assignCategory(category);
		test.set(parentTest);
		testName.set(testCaseName);

	}
	
	public String getTestName() {
		return testName.get();
	}
	
	
	@BeforeClass
	public void setDetails() {
//		ExtentTest test = extent.createTest(testCaseName, testDes);
//		test.assignAuthor(author);
//		test.assignCategory(category);
		setTest();
//		ExtentTest node1 = test.createNode(testCaseName);
		node.set(test.get().createNode(getTestName()));
		
	}
	
	
	public void reportStep(String msg, String status) throws IOException {
		if(status.equalsIgnoreCase("pass")) {
		node.get().pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}else if(status.equalsIgnoreCase("fail")) {
			node.get().fail(msg, MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+takeSnap()+".png").build());
		}
	}
	
	public int takeSnap() throws IOException {
		int randomNum = (int) ((Math.random()*9999)+999);
		File src = getDriver().getScreenshotAs(OutputType.FILE);
		File des = new File("./snaps/img"+randomNum+".png");
		FileUtils.copyFile(src, des);
		return randomNum;
		
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	
}
