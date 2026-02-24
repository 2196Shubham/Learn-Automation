package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"page.steps"},
    plugin = {"com.aventstack.chaintest.plugins.ChainTestCucumberListener:"},
    monochrome = true,
    tags = "@SmokeTestLogin"
)

public class Execution extends AbstractTestNGCucumberTests {


}