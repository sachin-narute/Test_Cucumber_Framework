package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

//import org.junit.runner.RunWith;
//@RunWith(Cucumber.class)

@CucumberOptions(
		//features="E:\\Automation\\Automation Workspace\\WS_finsys\\Cucumber_Framework\\Features",
		features="E:\\Automation\\Automation Workspace\\WS_finsys\\Cucumber_Framework\\Features\\login.feature",
		//features="E:\\Automation\\Automation Workspace\\WS_finsys\\Cucumber_Framework\\Features\\customer.feature",
		glue="stepDefinations",
		plugin= {"pretty",
				"html:target/cucumber.html",
				"json:target/cucumber.json"
				//"com.cucumber.listner.ExtentCucumberFormatter:output/report.html"
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumber:output/report.html"
		},
		dryRun = false,
		monochrome=true
		)

public class MainRunner extends AbstractTestNGCucumberTests{

	
}
