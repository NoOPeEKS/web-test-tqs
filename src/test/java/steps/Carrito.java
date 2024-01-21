package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class Carrito {

  ChromeDriver driver;
  String cantidadaux = null;

  @Given("usuario en main page")
  public void usuarioEnMainPage() {
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    System.setProperty("webdriver.http.factory", "jdk-http-client");
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.navigate().to("https://magento.softwaretestingboard.com");
  }

  @When("usuario click gear y bags")
  public void usuarioClickGearBags() throws InterruptedException {
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[4]")).click();
    driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/dd/ol/li[1]/a")).click();
    System.out.println();

  }

  @And("usuario click producto")
  public void usuarioClickProducto() {
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[2]/div/a")).click();
  }

  @And("^usuario elige (.*) y click boton add")
  public void usuarioEligeCantidadClickAdd(String cantidad) {
    cantidadaux = cantidad;
    driver.findElement(By.id("qty")).clear();
    driver.findElement(By.id("qty")).sendKeys(cantidad);
    driver.findElement(By.id("product-addtocart-button")).click();
  }

  @Then("carrito actualizado")
  public void carritoActualizado() throws InterruptedException {
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
    String cantidadEnCarrito = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]"))
            .getText();
    Assert.assertEquals(cantidadEnCarrito, cantidadaux);

    driver.quit();
  }

  @Then("carrito actualizado y error")
  public void carritoActualizadoError() throws InterruptedException {
    Thread.sleep(3000);
    String error = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
    Assert.assertEquals("The requested qty is not available", error);

    driver.quit();
  }
}
