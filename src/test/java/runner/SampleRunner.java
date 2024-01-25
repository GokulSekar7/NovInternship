package runner;

import org.testng.annotations.BeforeTest;

import io.cucumber.testng.CucumberOptions;
import stepDefinition.ProjectSpecificMethod;


@CucumberOptions(features = { "src/test/java/feature/SampleLogin.feature"},
					glue = "stepDefinition",
					monochrome = true,
					publish = true,
					tags = "@Positive and @Login" )
					
public class SampleRunner extends ProjectSpecificMethod{

	@BeforeTest
	public void setData() {
		testCaseName = "Login TC_001";
		testDes = "Login test case with positive scenario";
		author = "Gokul";
		category = "functional";
	}
	
	
}
