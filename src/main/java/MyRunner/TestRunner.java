package MyRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="src/test/java/Features",
		glue="stepDefinitions",
		plugin= {"json:target/cucumber.json"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{

}