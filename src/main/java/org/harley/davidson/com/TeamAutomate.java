package org.harley.davidson.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TeamAutomate {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://teams.microsoft.com/");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("jeyagokul.sekar@testleaf.com");
		driver.findElement(By.xpath("//input[@value='Next']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Sign in']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@value='No']")).click();

	}

}
