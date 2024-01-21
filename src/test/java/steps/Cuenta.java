package steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Cuenta {
    WebDriver driver;
    String usuario = "prueba1@email.com";
    String contrasenya = "A12345678.";
    @Given("usuario inicia sesion")
    public void usuarioIniciaSesion()
    {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);


        driver = new ChromeDriver(options);

        driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        driver.findElement(By.id("email")).sendKeys(usuario);
        driver.findElement(By.id("pass")).sendKeys(contrasenya);
        driver.findElement(By.id("send2")).click();
    }

    @Given("^usuario inicia sesion con (.*)")
    public void usuarioIniciaSesionEmailLogin(String emailLoggin) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        Thread.sleep(200);
        driver.findElement(By.id("email")).sendKeys(emailLoggin);
        driver.findElement(By.id("pass")).sendKeys(contrasenya);
        driver.findElement(By.id("send2")).click();
    }


    @When("usuario abre menu")
    public void usuarioAbreMenu() {
        driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button")).click();
    }


    @And("usuario click my account")
    public void usuarioClickMyAccount()
    {
        driver.findElement(By.partialLinkText("My Account")).click();
    }


    @And("usuario click edit info")
    public void usuarioClickEditInfo()
    {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[4]/div[2]/div/div[2]/a[1]/span")).click();
    }


    @And("^usuario cambia nombre(.*)")
    public void usuarioCambiaNombre(String name) throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(By.id("firstname")).clear();
        Thread.sleep(200);
        driver.findElement(By.id("firstname")).sendKeys(name);
    }

    @And("^usuario cambia apellido (.*)")
    public void usuarioCambiaApellido(String surname) throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(By.id("lastname")).clear();
        Thread.sleep(200);
        driver.findElement(By.id("lastname")).sendKeys(surname);
        Thread.sleep(200);
    }


    @And("usuario click save")
    public void usuarioClickSave()
    {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div/div[1]/button")).click();
    }


    @Then("^nombre (.*) editado")
    public void nombreEditado(String name) throws InterruptedException {
        Thread.sleep(200);
        String nameCompleto = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[4]/"
                + "div[2]/div/div[1]/p")).getText();
        Assert.assertTrue(nameCompleto.contains(name));
    }

    @And("^apellido (.*) editado")
    public void elApellidoSurnameHaSidoEditado(String surname)
    {
        String nameCompleto = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[4]/"
                + "div[2]/div/div[1]/p")).getText();
        Assert.assertTrue(nameCompleto.contains(surname));
        driver.quit();
    }

    @And("usuario click edit mail")
    public void usuarioClickEditarMail()
    {
        driver.findElement(By.id("change-email")).click();

    }


    @And("^usuario edita email (.*)")
    public void usuarioEditaEmail(String email) throws InterruptedException {
        Thread.sleep(200);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(200);
        driver.findElement(By.id("email")).sendKeys(email);
        Thread.sleep(200);
    }


    @And("usuario introduce passwd")
    public void usuarioIntroducePasswd() throws InterruptedException {
        driver.findElement(By.id("current-password")).sendKeys(contrasenya);
        Thread.sleep(200);
    }

    @Then("^usuario entra nuevo mail (.*)")
    public void usuarioEntraNuevomail(String emailNuevo) throws InterruptedException {

        driver.findElement(By.id("email")).sendKeys(emailNuevo);
        driver.findElement(By.id("pass")).sendKeys(contrasenya);
        driver.findElement(By.id("send2")).click();
        Thread.sleep(200);
        String text = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[1]/h1")).getText();
        Assert.assertTrue(text.contains("My Account"));

        driver.quit();
    }


    @And("usuario click my orders")
    public void usuarioClickMyOrders() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(1500);
    }

    @And("usuario consulta pedido")
    public void usuarioConsultaPedido() {
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[4]/table/tbody/tr/td[6]/a[1]/span")).click();
    }

    @Then("aparece detalle pedido")
    public void apareceDetallePedido() throws InterruptedException {
        Thread.sleep(3000);
        String texto = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[3]/div[1]/strong")).getText();
        Assert.assertEquals(texto, "Items Ordered");

        driver.quit();
    }

    @And("usuario reordena pedido")
    public void usuarioReordenaPedido() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/div[1]/div[2]/div/a[1]/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/ul/li[1]/button/span")).click();
        Thread.sleep(3000);
        //radio button
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/input")).click();
        Thread.sleep(500);
        //Next button
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button")).click();
        Thread.sleep(3000);
        //Place Order button
        driver.findElement(By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button/span")).click();
    }

    @Then("pedido completado")
    public void pedidoCompletado() throws InterruptedException {
        Thread.sleep(6000);
        String msg = driver.findElement(By.xpath("/html/body/div[2]/main/div[1]/h1/span")).getText();
        Assert.assertEquals(msg, "Thank you for your purchase!");

        driver.quit();
    }
}
