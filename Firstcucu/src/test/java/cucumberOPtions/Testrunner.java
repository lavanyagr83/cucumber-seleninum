package cucumberOPtions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/features",
		glue="stepDefinition",stepNotifications=true)
public class Testrunner {

}
//junit test runner/TestNG test runner/java
