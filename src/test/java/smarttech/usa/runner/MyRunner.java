package smarttech.usa.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		plugin= {"pretty","json:CucumberReport/cucumber.json" }, 
		features = {".//Features/" },
		glue = {"smarttech.usa.stepdefinitions", "smarttech.usa.hooks" }, 
		//dryRun = false, 
		//monochrome = true, 
		tags = "@Functional")
public class MyRunner extends AbstractTestNGCucumberTests {

}