package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Objects;

public class Register {
    double min = 0;
    double max = 100;

    WebDriver driver;

    //Sin Errores
    @Given("usuario en portada")
    public void usuarioEnPortada(){
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/");
    }

    @When("usuario click Create an Account")
    public void usuarioClickCreateAccount(){
        driver.findElement(By.partialLinkText("Create an Account")).click();
    }

    @When("usuario llena formulario email nuevo")
    public void usuarioLlenaFormularioMailNuevo(){
        driver.findElement(By.id("firstname")).sendKeys("ABC");
        driver.findElement(By.id("lastname")).sendKeys("DEF");
        double num = Math.random()*(max-min+1)+min;
        String n = Double.toString(num);
        String email = "Prueba" + n + "@email.com";
        driver.findElement(By.id("email_address")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys("A12345678.");
        driver.findElement(By.id("password-confirmation")).sendKeys("A12345678.");
    }

    @When("usuario click boton create an account")
    public void usuarioClickBotonCreateAccount(){
        driver.findElement(By.className("primary")).click();
    }

    @Then("usuario redirigido My Account")
    public void usuarioRedirigidoMyAccount(){
        List<WebElement> elements = driver.findElement(By.className("page-title")).findElements(By.tagName("span"));
        String title = elements.get(0).getText();
        System.out.println();
        Assert.assertTrue(title.contains("My Account"));
        driver.quit();
    }


    //Error email existente
    @When("usuario llena formulario email repetido")
    public void usuarioLlenaFormularioMailRepetido(){
        driver.findElement(By.id("firstname")).sendKeys("ABC");
        driver.findElement(By.id("lastname")).sendKeys("DEF");
        driver.findElement(By.id("email_address")).sendKeys("prueba@email.com");
        driver.findElement(By.id("password")).sendKeys("A12345678.");
        driver.findElement(By.id("password-confirmation")).sendKeys("A12345678.");
    }

    @Then("error mail existente")
    public void errorMailExistente(){
        String title = driver.getCurrentUrl();
        System.out.println();
        Assert.assertTrue(title.contains("https://magento.softwaretestingboard.com/customer/account/create/"));
        driver.quit();
    }

    //Error password
    @When("^usuario añade (.*)")
    public void usuarioAñadePasswd(String passwd){
        driver.findElement(By.id("password")).sendKeys(passwd);
    }

    @Then("^mensaje error (.*)")
    public void apareceMensajeError(String error)
    {
        List<WebElement> elements = driver.findElements(By.id("password-error"));
        String title = elements.get(0).getText();

        if(Objects.equals(error, "no_error"))
        {
            Assert.assertTrue(Objects.equals(title, ""));
        }
        else{
            Assert.assertTrue(title.contains(error));
        }

        driver.quit();
    }



    //Strength password
    @When("usuario llena formulario sin passwd")
    public void usuarioLlenaFormularioSinPasswd()
    {
        driver.findElement(By.id("firstname")).sendKeys("ABC");
        driver.findElement(By.id("lastname")).sendKeys("DEF");
        double num = Math.random()*(max-min+1)+min;
        String n = Double.toString(num);
        String email = "Prueba" + n + "@email.com";
        driver.findElement(By.id("email_address")).sendKeys(email);
    }


    @When("^usuario confirma (.*)")
    public void usuarioConfirmaPasswd(String passwdConfirm)
    {
        driver.findElement(By.id("password-confirmation")).sendKeys(passwdConfirm);
    }


    @Then("^mostrar mensaje (.*)")
    public void mostrarMensajeError(String error)
    {

        if(Objects.equals(error, "no"))
        {
            Assert.assertEquals(driver.findElements(By.id("password-confirmation-error")).size(), 0);
        }
        else
        {
            String mensaje = driver.findElement(By.id("password-confirmation-error")).getText();
            Assert.assertEquals(mensaje, "Please enter the same value again.");
            if(Objects.equals(error, "required"))
            {
                String mensaje_required = driver.findElement(By.id("password-error")).getText();
                Assert.assertTrue(mensaje_required.contains("required"));
            }
        }

        driver.quit();
    }
}
