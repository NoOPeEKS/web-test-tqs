package defaultPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Sesion.feature", glue = "steps")
public class RunSesionTest extends AbstractTestNGCucumberTests {
}