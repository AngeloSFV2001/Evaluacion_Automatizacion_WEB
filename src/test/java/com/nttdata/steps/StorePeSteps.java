package com.nttdata.steps;

import com.nttdata.page.LoginPage;
import com.nttdata.page.MercadoLibrePage;
import com.nttdata.page.StorePePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePeSteps {
    WebDriver driver;
    StorePePage page;
    private WebDriverWait wait;

    public StorePeSteps(WebDriver driver){
        this.driver = driver;
        page = new StorePePage(driver);
    }
    private OrderPeSteps OrderPeSteps(WebDriver driver){
        return new OrderPeSteps(driver);
    }
    public void navegarA(String url){
        driver.get(url);
    }

    public void clickEnInicioDeSesion() {
        WebElement botonInicioSesion = driver.findElement(StorePePage.loginButtonPage);
        botonInicioSesion.click();
    }
    public void typeUser(String user) {
        WebElement userInputElement = driver.findElement(StorePePage.emailInput);
        userInputElement.sendKeys(user);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePePage.loginButtonPage));
    }

    public void typePassword(String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(StorePePage.passInput).sendKeys(password);
    }

    public void login() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(StorePePage.loginButton).click();
    }


    public void clickEnCategoria() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(StorePePage.categoriaNav1).click();
    }

    public void clickEnSubCategoria() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(StorePePage.subCategoria1).click();
    }

    public void elegirElPrimerProducto() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(StorePePage.primerItem).click();
    }

    public void elegirLaCantidadDeProductos(int cantidad) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        for(int i = 0; i < cantidad-1; i++) {
            this.driver.findElement(StorePePage.cantidadDeProductos).click();
        }
        
    }

    public void completarLaCompra() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        this.driver.findElement(StorePePage.addProductCartButton).click();
    }

    public void validarProductos() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(444));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StorePePage.popupVentana));
        double title =  OrderPeSteps(driver).getProductos();
        //prueba: validamos el título del producto
        Assertions.assertEquals(2, title);
    }

    public void validarMontoCompra() {
        Assertions.assertEquals(OrderPeSteps(driver).getMonto(), OrderPeSteps(driver).getProductos()*OrderPeSteps(driver).getValorPrenda());
    }

    public void validarCompra() {
        this.driver.findElement(StorePePage.completarCompra).click();
    }


    public void validarTituloCarrito() {
        this.driver.findElement(StorePePage.carritoBoton).click();
        Assertions.assertEquals("Carrito",OrderPeSteps(driver).getTitulo());
    }
}
