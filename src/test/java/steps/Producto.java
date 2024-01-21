package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;


public class Producto {
    WebDriver driver;
    String usuario = "prueba@email.com";
    String passwd = "A12345678.";

    @Given("usuario loggeado")
    public void usuarioLoggeado()
    {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
        driver.findElement(By.id("email")).sendKeys(usuario);
        driver.findElement(By.id("pass")).sendKeys(passwd);
        driver.findElement(By.id("send2")).click();
    }


    @When("^usuario escoge (.*)")
    public void usuarioEscogeProducto(String producto)
    {
        driver.findElement(By.partialLinkText(producto)).click();
    }

    @And("usuario click reviews")
    public void usuarioClickReviews() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.id("tab-label-reviews")).click();
    }

    @And("usuario llena formulario review")
    public void usuarioLlenaFormularioReview() throws InterruptedException {
        Thread.sleep(300);

        driver.findElement(By.id("Rating_1_label")).click();
        Thread.sleep(300);

        driver.findElement(By.id("nickname_field")).sendKeys("Pepito");
        Thread.sleep(300);

        driver.findElement(By.id("summary_field")).sendKeys("reviewpruebaaa");
        Thread.sleep(300);

        driver.findElement(By.id("review_field")).sendKeys("Mi primera review a ver que tal");
        Thread.sleep(300);

    }

    @And("usuario submit review")
    public void usuarioSubmitReview()
    {
        driver.findElement(By.id("review-form")).submit();
    }

    @Then("review confirmada")
    public void reviewConfirmada()
    {
        int size = driver.findElements(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/div/div")).size();
        Assert.assertTrue(size>0);
        driver.quit();
    }


    @And("usuario add to wish list")
    public void usuarioAddToWishList() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.partialLinkText("ADD TO WISH LIST")).click();
    }

    @Then("^(.*) en wish list")
    public void productoEnWishList(String producto)
    {
        int size = driver.findElements(By.partialLinkText(producto)).size();
        Assert.assertTrue(size>0);
        driver.quit();

    }

    List<WebElement> wishList;
    int wishListSize;

    @Given("usuario tiene producto en la wish list")
    public void usuarioTieneProductoEnLaWishList() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.partialLinkText("Argus All-Weather Tank")).click();
        Thread.sleep(300);
        driver.findElement(By.partialLinkText("ADD TO WISH LIST")).click();
        Thread.sleep(300);
        wishList = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/ol")).findElements(By.tagName("li"));
        wishListSize = wishList.size();
    }

    @And("usuario elimina producto wish list")
    public void usuarioEliminaProductoWishList() throws InterruptedException {
        Thread.sleep(300);
        driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/ol/li[2]/div/div[2]/div[3]/a[2]")).click();

    }

    @Then("producto eliminado wish list")
    public void productoEliminadoWishList() throws InterruptedException {
        Thread.sleep(300);
        wishList = driver.findElement(By.xpath("/html/body/div[2]/main/div[2]/div[1]/form/div[1]/ol")).findElements(By.tagName("li"));
        int newSize = wishList.size();
        Assert.assertTrue(newSize<wishListSize);
        driver.quit();
    }
}
