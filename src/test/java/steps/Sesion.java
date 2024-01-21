package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sesion {

  WebDriver driver;
  String usuario = "prueba@email.com";
  String contrasenya = "A12345678.";


  //Iniciar Sesion
  @Given("usuario en portada principal")
  public void usuarioEnPortadaPrincipal() {
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("https://magento.softwaretestingboard.com/");
  }

  @When("usuario hace sign in")
  public void usuarioHaceSignIn() {
    driver.findElement(By.className("authorization-link")).click();
  }

  @And("usuario llena formulario sign in")
  public void usuarioLlenaFormularioSignIn() {
    driver.findElement(By.id("email")).sendKeys(usuario);
    driver.findElement(By.id("pass")).sendKeys(contrasenya);
  }

  @And("usuario clica boton sign in")
  public void usuarioClicaBotonSignIn() {
    driver.findElement(By.id("send2")).click();
  }

  @Then("usuario redirigido portada")
  public void usuarioRedirigidoPortada() {
    String url = driver.getCurrentUrl();
    System.out.println();
    Assert.assertTrue(url.contains("https://magento.softwaretestingboard.com/"));
  }

  //Cerrar Sesion
  @When("usuario clica sign out")
  public void usuarioClicaSignOut() {
    driver.findElement(By.className("customer-welcome")).click();
    driver.findElement(By.className("authorization-link")).click();
  }

  @Then("usuario cierra sesion")
  public void usuarioCierraSesion() {
    String h1Title = driver.findElement(By.className("base")).getText();
    Assert.assertTrue(h1Title.contains("You are signed out"));
  }

  @When("espera cinco segundos")
  public void esperaCincoSegundos() throws InterruptedException {
    Thread.sleep(5100);
  }


  @Then("usuario redirigido portada again")
  public void usuarioRedirigidoPortadaAgain() {
    String url = driver.getCurrentUrl();
    System.out.println();
    Assert.assertTrue(url.contains("https://magento.softwaretestingboard.com/"));
    driver.quit();
  }
}
