package defaultPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/CompraSinCuenta.feature", glue = "steps")
public class CompraSinCuentaTest extends AbstractTestNGCucumberTests {
}