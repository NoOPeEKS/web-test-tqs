package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Compra {
  WebDriver driver;
  String usuario = "prueba1@email.com";
  String passwd = "A12345678.";
  String cantidadaux = null;


  double min = 0;
  double max = 100;

  //Compra Sin Cuenta

  @Given("usuario sin cuenta main page")
  public void usuarioSinCuentaEnMainPage() {
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("https://magento.softwaretestingboard.com/");
  }

  @When("usuario click oferta")
  public void usuarioClickOferta() throws InterruptedException{
    Thread.sleep(100);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/div/a[1]")).click();
  }

  @And("usuario click producto oferta")
  public void usuarioClickProductoOferta() throws InterruptedException{
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[4]/ol/li[1]/div/a")).click();
  }


  @And("^usuario añade producto y cantidad (.*)")
  public void usuarioAnadeProductoYCantidad(String cantidad) throws InterruptedException {
    cantidadaux = cantidad;
    Thread.sleep(1500);
    driver.findElement(By.id("qty")).clear();
    driver.findElement(By.id("qty")).sendKeys(cantidad);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/"
            + "div[4]/form/div[1]/div/div/div[1]/div/div[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/"
            + "form/div[1]/div/div/div[2]/div/div[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("product-addtocart-button")).click();
  }

  @And("usuario click carrito y checkout")
  public void usuarioClickCarritoYCheckout() throws InterruptedException {
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/"
            + "div/div/div/div[2]/div[3]/div/button")).click();
    Thread.sleep(2500);
  }

  @And("usuario llena formulario correcto")
  public void usuarioLlenaFormularioCorrecto() throws InterruptedException {
    //Email
    Thread.sleep(4000);
    double num = Math.random()*(max-min+1)+min;
    String n = Double.toString(num);
    String email = "Prueba" + n + "@email.com";
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/"
            + "li[1]/div[2]/form[1]/fieldset/div/div/input")).sendKeys(email);
    Thread.sleep(4000);
    //1st name
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input")).sendKeys("Prueba");
    Thread.sleep(3000);
    //Last name
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[2]/div/input")).sendKeys("Uno");
    Thread.sleep(500);
    //Company
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[3]/div/input")).sendKeys("Company S.A");
    Thread.sleep(500);
    //Street Adress
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input")).sendKeys("AA");
    Thread.sleep(500);
    //City
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[4]/div/input")).sendKeys("City");
    Thread.sleep(500);
    //State/Province
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/"
            + "div[4]/ol/li[1]/div[2]/form[2]/div/div[5]/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[5]/div/select/option[5]")).click();
    Thread.sleep(500);
    //Postal Code
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[7]/div/input")).sendKeys("00000");
    Thread.sleep(500);
    //Phone number
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[9]/div/input")).sendKeys("000000000");
    Thread.sleep(500);
    //Shipping Method
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")).click();
    Thread.sleep(500);
    //button
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[2]/div/div[3]/form/div[3]/div/button")).click();
    Thread.sleep(3000);
  }

  @And("usuario click place order")
  public void usuarioClickPlaceOrder() throws InterruptedException {
    Thread.sleep(6000);
    //button
    driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[4]/ol/li[3]/"
            + "div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button")).click();
  }

  @Then("compra realizada")
  public void compraRealizada() throws InterruptedException {
    Thread.sleep(3500);
    String title = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span")).getText();
    Assert.assertEquals(title, "Thank you for your purchase!");

    driver.quit();
  }

  //CrearCuentaDespuesDeCompra
  @Then("compra realizada correctamente")
  public void compraRealizadaCorrectamente() throws InterruptedException {
    Thread.sleep(3500);
    String title = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span")).getText();
    Assert.assertEquals(title, "Thank you for your purchase!");
  }

  @And("usuario crea cuenta despues de comprar")
  public void usuarioCreaCuentaDespuesDeComprar() throws InterruptedException {
    Thread.sleep(5000);
    //boton
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[4]/div[2]/a")).click();
    Thread.sleep(2500);
    //rellenar datos
    driver.findElement(By.id("password")).sendKeys(passwd);
    Thread.sleep(200);
    driver.findElement(By.id("password-confirmation")).sendKeys(passwd);
    Thread.sleep(200);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/form/div/div[1]/button")).click();
  }

  @Then("aparece confirmacion creacion cuenta")
  public void apareceConfirmacionCreacionCuenta() throws InterruptedException {
    Thread.sleep(2500);
    String msg = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).getText();
    Assert.assertEquals(msg, "Thank you for registering with Main Website Store.");

    driver.quit();
  }


  //CompraConEmailErroneo
  @And("usuario llena formulario email erroneo")
  public void usuarioLlenaFormularioEmailErroneo() throws InterruptedException {
    //Email
    Thread.sleep(4000);
    double num = Math.random()*(max-min+1)+min;
    String n = Double.toString(num);
    String email = "prueba.email.com";
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/"
            + "li[1]/div[2]/form[1]/fieldset/div/div/input")).sendKeys(email);
    Thread.sleep(4000);
    //1st name
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input")).sendKeys("Prueba");
    Thread.sleep(3000);
    //Last name
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[2]/div/input")).sendKeys("Uno");
    Thread.sleep(500);
    //Company
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[3]/div/input")).sendKeys("Company S.A");
    Thread.sleep(500);
    //Street Adress
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input")).sendKeys("AA");
    Thread.sleep(500);
    //City
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[4]/div/input")).sendKeys("City");
    Thread.sleep(500);
    //State/Province
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/"
            + "div[4]/ol/li[1]/div[2]/form[2]/div/div[5]/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[5]/div/select/option[5]")).click();
    Thread.sleep(500);
    //Postal Code
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[7]/div/input")).sendKeys("00000");
    Thread.sleep(500);
    //Phone number
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[9]/div/input")).sendKeys("000000000");
    Thread.sleep(500);
    //Shipping Method
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")).click();
    Thread.sleep(500);
  }

  @Then("recibir error email")
  public void recibirErrorEmail() throws InterruptedException {
    Thread.sleep(1000);
    String msg = driver.findElement(By.id("customer-email-error")).getText();
    Assert.assertEquals(msg, "Please enter a valid email address (Ex: johndoe@domain.com).");
    driver.quit();
  }

  //CompraConCodigoPostalErroneo
  @And("usuario llena formulario codigo postal erroneo")
  public void usuarioLlenaFormularioCodigoPostalErroneo() throws InterruptedException {
    //Email
    Thread.sleep(4000);
    double num = Math.random()*(max-min+1)+min;
    String n = Double.toString(num);
    String email = "Prueba" + n + "@email.com";
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/"
            + "li[1]/div[2]/form[1]/fieldset/div/div/input")).sendKeys(email);
    Thread.sleep(4000);
    //1st name
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input")).sendKeys("Prueba");
    Thread.sleep(3000);
    //Last name
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[2]/div/input")).sendKeys("Uno");
    Thread.sleep(500);
    //Company
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[3]/div/input")).sendKeys("Company S.A");
    Thread.sleep(500);
    //Street Adress
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input")).sendKeys("AA");
    Thread.sleep(500);
    //City
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[4]/div/input")).sendKeys("City");
    Thread.sleep(500);
    //State/Province
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/"
            + "div[4]/ol/li[1]/div[2]/form[2]/div/div[5]/div")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[5]/div/select/option[5]")).click();
    Thread.sleep(500);
    //Postal Code
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[7]/div/input")).sendKeys("0000000000");
    Thread.sleep(500);
    //Phone number
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[1]/div[2]/form[2]/div/div[9]/div/input")).sendKeys("000000000");
    Thread.sleep(500);
    //Shipping Method
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]"
            + "/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")).click();
    Thread.sleep(500);
  }

  @Then("recibir error nuevo")
  public void recibirErrorNuevo() throws InterruptedException {
    Thread.sleep(4000);
    String msg = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form[2]/div/div[7]/div/div/span")).getText();

    Assert.assertEquals(msg, "Provided Zip/Postal Code seems to be invalid. Example: 12345-6789; 12345. " +
        "If you believe it is the right one you can ignore this notice.");
    driver.quit();
  }


  //Compra normal con cuenta
  @Given("el usuario inicia sesion")
  public void elUsuarioIniciaSesion() {
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    driver.navigate().to("https://magento.softwaretestingboard.com/");
    driver.findElement(By.className("authorization-link")).click();
    driver.findElement(By.id("email")).sendKeys(usuario);
    driver.findElement(By.id("pass")).sendKeys(passwd);
    driver.findElement(By.id("send2")).click();
  }

  @When("el usuario hace click en men, tops, climate y cold")
  public void elUsuarioHaceClickEnMenTopsClimateYCold() throws InterruptedException {
    Thread.sleep(2000);
    driver.navigate().to("https://magento.softwaretestingboard.com/");
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[2]/nav/ul/li[3]/a")).click();
    //tops
    driver.findElement(By.xpath("/html/body/div[2]/main/div[4]/div[2]/div[1]/div[2]/dl/" +
        "dd/ol/li[1]/a")).click();
    //climate
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/" +
        "div[13]/div[1]")).click();
    //cold
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[2]/div/div[2]/div/" +
        "div[13]/div[2]/ol/li[2]/a")).click();
  }

  @And("el usuario hace click en el primer producto de esta categoria")
  public void elUsuarioHaceClickEnElPrimerProductoDeEstaCategoria() throws InterruptedException {
    Thread.sleep(2000);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div[1]/div[3]/ol/li[1]/div/a")).click();
  }

  @And("patata")
  public void patata() throws InterruptedException {
    Thread.sleep(2000);
    //Company
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/div[3]/div/input")).sendKeys("Company S.A");

    Thread.sleep(100);
    //Street Adress
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/fieldset/div/div[1]/div/input")).sendKeys("Calle Maria n9, 8 A");
    Thread.sleep(100);
    //City
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/div[4]/div/input")).sendKeys("City");
    Thread.sleep(100);
    //State/Province
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/div[5]/div/select")).click();
    Thread.sleep(100);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/div[5]/div/select/option[3]")).click();
    Thread.sleep(100);
    //Postal Code
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/div[7]/div/input")).sendKeys("00000");
    Thread.sleep(100);
    //Phone number
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[1]/div[2]/form/div/div[9]/div/input")).sendKeys("000000000");
    Thread.sleep(100);
    //Shipping Method
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")).click();
    Thread.sleep(100);
    //button
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/"
            + "ol/li[2]/div/div[3]/form/div[3]/div/button")).click();
  }

  @And("el usuario selecciona el Shipping Method")
  public void elUsuarioSeleccionaElShippingMethod() throws InterruptedException {
    Thread.sleep(1500);
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/div[3]/" +
        "form/div[1]/table/tbody/tr[1]/td[1]/input")).click();
    driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[2]/div[4]/ol/li[2]/div/" +
        "div[3]/form/div[3]/div/button")).click();
  }

}
