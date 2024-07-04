package com.nttdata.stepsdefinitions;

import com.nttdata.page.StorePePage;
import com.nttdata.steps.MercadoLibreStep;
import com.nttdata.steps.StorePeSteps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StorePeStepDef {

    private StorePeSteps storePeSteps;
    private WebDriver driver;
    private Scenario scenario;

    @Before(order = 0)
    public void setUp(){
        //Se ejecutará Automáticamente
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before(order = 1)
    public void setScenario(Scenario scenario){
        this.scenario = scenario;
    }

    @After
    public void quitDriver(){
        driver.quit();
    }

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() throws InterruptedException {
        storePeSteps = new StorePeSteps(driver);
        storePeSteps.navegarA("https://qalab.bensg.com/store");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String user, String password) {
        storePeSteps.clickEnInicioDeSesion();
        storePeSteps.typeUser(user);
        storePeSteps.typePassword(password);
        storePeSteps.login();
        screenShot();

    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoria(String categoria, String subCategoria) {
        storePeSteps.clickEnCategoria();
        storePeSteps.clickEnSubCategoria();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int cantidad) {
        storePeSteps.elegirElPrimerProducto();
        storePeSteps.elegirLaCantidadDeProductos(cantidad);
        storePeSteps.completarLaCompra();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() throws InterruptedException {
        storePeSteps.validarProductos();

    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        storePeSteps.validarMontoCompra();
    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        storePeSteps.validarCompra();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }

    public void screenShot(){
        byte[] evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        this.scenario.attach(evidencia, "image/png", "evidencias");
    }


}
