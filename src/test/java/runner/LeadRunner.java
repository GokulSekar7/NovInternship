package runner;

import base.BaseClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import stepDefinition.ProjectSpecificMethod;


@CucumberOptions(features = { "src/test/java/feature/CreateContact.feature"},
					glue = "pages",
					monochrome = true,
					publish = true)
					
public class LeadRunner extends BaseClass{

}
