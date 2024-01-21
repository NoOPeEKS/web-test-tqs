package defaultPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/features/Register.feature", glue = "steps")

public class RunRegisterTest extends AbstractTestNGCucumberTests {
}

//comentario
