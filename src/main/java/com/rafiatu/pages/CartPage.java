package com.rafiatu.pages;

import org.openqa.selenium.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class CartPage extends BasePage {

    private final By cartProductList = By.cssSelector(".cart_list .cart_item");
    private final By cartIcon = By.cssSelector(".shopping_cart_link");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");

    private final By removeButtons = By.cssSelector(".cart_button");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openCart() {
        clickElement(cartIcon);
    }


    public int getCartItemCount() {
    try {
        WebElement badge = driver.findElement(cartBadge);
        return Integer.parseInt(badge.getText());
    } catch (NoSuchElementException e) {
        return 0;
    }
}
    public void removeProduct(int productIndex) {
        List<WebElement> buttons = driver.findElements(removeButtons);
        if (productIndex >= 0 && productIndex < buttons.size()) {
            buttons.get(productIndex).click();
        } else {
            throw new IndexOutOfBoundsException("Invalid product index: " + productIndex);
        }
    }

    public boolean hasCheckoutButton() {
        return isElementPresent(checkoutButton);
    }

    public void clickCheckout() {
        clickElement(checkoutButton);
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("cart.html");
    }

    private boolean isElementPresent(By locator) {
        try {
            waitForElementVisible(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}
