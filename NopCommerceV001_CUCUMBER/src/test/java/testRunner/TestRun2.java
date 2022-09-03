
package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
       (
		features=".//Features/Customers.feature",
		glue="stepDefinations",
		dryRun=false,         //It will cross check weather every steps have corresponding method or not. 
	    monochrome=true,
		plugin= {"pretty",
				"html:target/test-output"}
		
		
		)

public class TestRun2 {

}
