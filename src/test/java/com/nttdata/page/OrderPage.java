package com.nttdata.page;

import org.openqa.selenium.By;

public class OrderPage {
    public static By validacionDeProducto = By.cssSelector("body.lang-pe.country-pe.currency-pen.layout-full-width.page-product.tax-display-enabled.product-id-1.product-hummingbird-printed-t-shirt.product-id-category-4.product-id-manufacturer-1.product-id-supplier-1.product-available-for-order.modal-open:nth-child(2) div.modal.fade.in:nth-child(21) div.modal-dialog div.modal-content div.modal-body div.row div.col-md-5.divide-right div.row div.col-md-6:nth-child(2) span.product-quantity:nth-child(7) > strong:nth-child(1)");
    public static By validacionMontoDeProducto = By.cssSelector("body.lang-pe.country-pe.currency-pen.layout-full-width.page-product.tax-display-enabled.product-id-1.product-hummingbird-printed-t-shirt.product-id-category-4.product-id-manufacturer-1.product-id-supplier-1.product-available-for-order.modal-open:nth-child(2) div.modal.fade.in:nth-child(21) div.modal-dialog div.modal-content div.modal-body div.row div.col-md-7 div.cart-content p.product-total:nth-child(4) > span.value");
    public static By validacionPrecioDeProducto = By.cssSelector("body.lang-pe.country-pe.currency-pen.layout-full-width.page-product.tax-display-enabled.product-id-1.product-hummingbird-printed-t-shirt.product-id-category-4.product-id-manufacturer-1.product-id-supplier-1.product-available-for-order.modal-open:nth-child(2) div.modal.fade.in:nth-child(21) div.modal-dialog div.modal-content div.modal-body div.row div.col-md-5.divide-right div.row div.col-md-6:nth-child(2) > p.product-price:nth-child(2)");
    public static By validacionTituloCarrito = By.cssSelector("h1.h1");
}
