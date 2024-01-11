package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDefinition.ProjectSpecificMethod;


@CucumberOptions(features = { "src/test/java/feature/CreateContact.feature"},
					glue = "stepDefinition",
					monochrome = true,
					publish = true)
					
public class SampleRunner extends ProjectSpecificMethod {

}
