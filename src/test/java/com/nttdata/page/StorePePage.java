package com.nttdata.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StorePePage {
    public static By loginButtonPage = By.xpath("//div[@class=\"user-info\"]");
    public static By emailInput = By.id("field-email");
    public static By passInput = By.id("field-password");
    public static By loginButton = By.id("submit-login");
    public static By categoriaNav1 = By.id("category-3");
    public static By subCategoria1 = By.xpath("//body/main[1]/section[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]/ul[1]/li[1]");
    public static By primerItem = By.xpath("(//div[@class=\"thumbnail-top\"])[1]");
    public static By cantidadDeProductos = By.xpath("//button[@class=\"btn btn-touchspin js-touchspin bootstrap-touchspin-up\"]");
    public static By addProductCartButton = By.xpath("//button[@class=\"btn btn-primary add-to-cart\"]");
    public static By popupVentana = By.xpath("//body/div[@id='blockcart-modal']/div[1]/div[1]");
    public static By completarCompra = By.xpath("(//a[@class=\"btn btn-primary\"])[2]");
    private  WebDriver driver;
    private WebDriverWait wait;

    public StorePePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
