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
  @Given("el usuario esta en la portada principal")
  public void elUsuarioEstaEnLaPortadaPrincipal() {
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("https://magento.softwaretestingboard.com/");
  }

  @When("el usuario hace click en Sign in")
  public void elUsuarioHaceClickEnSignIn() {
    driver.findElement(By.className("authorization-link")).click();
  }

  @And("el usuario rellena la informacion del inicio de sesion")
  public void elUsuarioRellenaLaInformacionDelInicioDeSesion() {
    driver.findElement(By.id("email")).sendKeys(usuario);
    driver.findElement(By.id("pass")).sendKeys(contrasenya);
  }

  @And("el usuario le da click al boton de Sign In")
  public void elUsuarioLeDaClickAlBotonDeSignIn() {
    driver.findElement(By.id("send2")).click();
  }

  @Then("el usuario es redirigido a la portada")
  public void elUsuarioEsRedirigidoALaPortada() {
    String url = driver.getCurrentUrl();
    System.out.println();
    Assert.assertTrue(url.contains("https://magento.softwaretestingboard.com/"));
  }

  //Cerrar Sesion
  @When("el usuario hace click en su nombre y en Sign Out")
  public void elUsuarioHaceClickEnSuNombreYEnSignOut() {
    driver.findElement(By.className("customer-welcome")).click();
    driver.findElement(By.className("authorization-link")).click();
  }

  @Then("el usuario cierra la sesion")
  public void elUsuarioCierraLaSesion() {
    String h1Title = driver.findElement(By.className("base")).getText();
    Assert.assertTrue(h1Title.contains("You are signed out"));
  }

  @When("pasan cinco segundos")
  public void pasanCincoSegundos() throws InterruptedException {
    Thread.sleep(5100);
  }


  @Then("el usuario es redirigido a la portada otra vez")
  public void elUsuarioEsRedirigidoALaPortadaOtraVez() {
    String url = driver.getCurrentUrl();
    System.out.println();
    Assert.assertTrue(url.contains("https://magento.softwaretestingboard.com/"));
    driver.quit();
  }
}
