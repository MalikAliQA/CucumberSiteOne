package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cuke/DemoSiteOne.feature", monochrome = true, glue = {"stepdef"})


public class testRunner {

}
