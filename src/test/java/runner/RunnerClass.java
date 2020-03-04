package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = {"src/test/resources/features"},
        format = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
        glue={"steps"},
        tags = "@bmiCalculator"
        )
public class RunnerClass extends AbstractTestNGCucumberTests {}
