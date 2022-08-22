package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/Features",
        glue={"stepdefinitions", "hooks"},
        //tags= "@NightlyBuildTest and @RegularTest", //If you use 'or',
        // it runs if the feature has one of the tags
        // if you use and, feature has to have both tags
        // or use "not" to run every feature without the tag
        //tags = "@ListofMaps",
        tags = "@ScenarioOutlineExample",
        plugin = {"pretty",
                "html:target/SystemTestReports/html",
                "json:target/SystemTestReports/json/report.json",
                "junit:target/SystemTestReports/junit/report.xml",

        }, dryRun = false,
        monochrome = true
)
public class MenuManagementTest {
}
