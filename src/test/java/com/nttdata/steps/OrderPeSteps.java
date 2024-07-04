package com.nttdata.steps;

import com.nttdata.page.OrderPage;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.WebDriver;

import static java.lang.Double.parseDouble;

public class OrderPeSteps {

    private WebDriver driver;

    public OrderPeSteps(WebDriver driver){
        this.driver = driver;
    }
    public Double getProductos(){
        return parseDouble(this.driver.findElement(OrderPage.validacionDeProducto).getText());
    }
    public Double getMonto(){
        return parseDouble(this.driver.findElement(OrderPage.validacionMontoDeProducto).getText());
    }
    public Double getValorPrenda(){
        return parseDouble(this.driver.findElement(OrderPage.validacionPrecioDeProducto).getText());
    }
    public String getTitulo(){
        return this.driver.findElement(OrderPage.validacionTituloCarrito).getText();
    }
}
