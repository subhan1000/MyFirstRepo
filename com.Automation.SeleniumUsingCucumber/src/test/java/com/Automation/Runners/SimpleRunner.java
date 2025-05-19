package com.Automation.Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/feature/login.feature",
				"src/test/resources/feature/UsermenuDropdown.feature"
				},
		glue = {"com.Automation.StepDefinations"},
		dryRun =  false,
		monochrome = true
		/*plugin = {"pretty",
				"json:target/cucumber-report/cucumber.json",
				"html:target/cucumber-report/cucumberreport.html"}*/
		
		)

//

public class SimpleRunner extends AbstractTestNGCucumberTests{

	
}
