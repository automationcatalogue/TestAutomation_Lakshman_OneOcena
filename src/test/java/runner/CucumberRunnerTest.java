package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@AmazonShoppingCartValidation",
        features = "src/main/resources/features/AmazonShoppingCartValidation.feature",
        glue = {"stepDefinitions"}
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
