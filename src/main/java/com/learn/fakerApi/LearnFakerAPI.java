package com.learn.fakerApi;

import java.util.Locale;

import com.github.javafaker.Faker;

public class LearnFakerAPI {

	public static void main(String[] args) {
		
		Faker faker = new Faker();
		String firstName = faker.name().firstName();
		String fn = faker.name().firstName();
		System.out.println(firstName);
		System.out.println(fn);
		
		String countryCode = faker.address().countryCode();
		System.out.println(countryCode);
		String cname = faker.company().name();
				System.out.println(cname);
				
				
		
	}

}
