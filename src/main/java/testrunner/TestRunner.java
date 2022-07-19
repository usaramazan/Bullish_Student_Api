package testrunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/features",
        glue={"stepdef"},
        dryRun = false,
		tags = "@EditingStudent or @AddStudent or @Smoke or @Regression",
        plugin = {"json:target/jsonReports/cucumber-report.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        publish = true
)
public class TestRunner{


}
