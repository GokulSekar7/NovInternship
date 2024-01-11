package org.harley.davidson.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearch {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriverFiles\\115\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--incognito");
//		option.
//		option.setBinary("C:/ChromeDriverFiles/115/chromedriver-win64/chromedriver.exe");
//		option.setBrowserVersion("122");
		ChromeDriver driver =  new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions action = new Actions(driver);
		driver.get("https://www.google.com/");
		String browserVersion = driver.getCapabilities().getBrowserVersion();
		System.out.println("browserVersion ---> "+browserVersion);
		driver.findElement(By.name("q")).sendKeys("Leaftaps",Keys.ENTER);
		WebElement leaftapsLink = driver.findElement(By.xpath("//h3[text()='Leaftaps - TestLeaf Automation Platform']/.."));
		action.contextClick(leaftapsLink).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ARROW_DOWN).keyUp(Keys.ARROW_DOWN).keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();

	}

}
