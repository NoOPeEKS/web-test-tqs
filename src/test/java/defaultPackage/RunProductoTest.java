package defaultPackage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/Producto.feature", glue = "steps")
public class RunProductoTest extends AbstractTestNGCucumberTests{

}
