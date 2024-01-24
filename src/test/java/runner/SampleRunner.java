package runner;

import base.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDefinition.ProjectSpecificMethod;


@CucumberOptions(features = { "src/test/java/feature"},
					glue = "stepDefinition",
					monochrome = true,
					publish = true,
					tags = "@Smoke and @Negative or @Positive and @Contacts" )
					
public class SampleRunner extends ProjectSpecificMethod{

}
