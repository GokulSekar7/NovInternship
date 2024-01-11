package com.learn.reflection.api;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnReflectionApi {

	public static void main(String[] args) {
		
		try {
			
			Class chromeDriver = Class.forName("org.openqa.selenium.chrome.ChromeDriver");
			
			Constructor[] chromeDriverConst = chromeDriver.getDeclaredConstructors();
			System.out.println("======constructor=======");
			for (Constructor constructor : chromeDriverConst) {
				System.out.println(constructor);
			}
			
			Field[] chromeDriverFields = chromeDriver.getDeclaredFields();
			System.out.println("======field========");
			for (Field field : chromeDriverFields) {
				System.out.println(field);
			}
			Method[] chromeDriverMethods = chromeDriver.getDeclaredMethods();
			System.out.println("=====method====");
			for (Method method : chromeDriverMethods) {
				System.out.println(method);
			}
			
			System.out.println("======================");
			ChromeDriver driver = (ChromeDriver) chromeDriverConst[4].newInstance();
			driver.get("http://leaftaps.com/opentaps/");
			
		} catch (Exception e) {
			
		}
		
		
	}

}
