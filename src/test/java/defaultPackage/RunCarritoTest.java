package defaultPackage;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Carrito.feature", glue = "steps")
public class RunCarritoTest extends AbstractTestNGCucumberTests {
}