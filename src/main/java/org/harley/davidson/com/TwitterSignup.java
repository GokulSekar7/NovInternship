package org.harley.davidson.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TwitterSignup {

	@Test
	public static void main1() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://twitter.com/");
		driver.findElement(By.xpath("//a[@data-testid='signupButton']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Gokul");
		
	}

}
