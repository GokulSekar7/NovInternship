package org.harley.davidson.com;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Leads {

	public static void main(String[] args) {
		
		XmlSuite suite = new XmlSuite();
		suite.setName("Leads");
		XmlTest test = new XmlTest(suite);
		test.setName("Create Lead");
		List<XmlClass> classes = new ArrayList<XmlClass>();
		classes.add(new XmlClass("org.harley.davidson.com.CreateLead"));
		test.setXmlClasses(classes);
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(suite);
		TestNG tng = new TestNG();
		tng.setXmlSuites(suites);
		tng.run();
	}

}
