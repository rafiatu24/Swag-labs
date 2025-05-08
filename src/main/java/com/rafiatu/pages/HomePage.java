package com.rafiatu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private final String INVENTORY = "inventory";

    // Locators
    private final By inventoryContainer = By.cssSelector("#inventory_container");
    private final By inventoryItems = By.cssSelector(".inventory_item");
    private final By productNames = By.className("inventory_item_name");
    private final By productPrices = By.className("inventory_item_price");
    private final By productImages = By.cssSelector(".inventory_item img");
    private final By addToCartButtons = By.cssSelector("button.btn_inventory");
    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return driver.getCurrentUrl().contains(INVENTORY);
    }

    public void waitUntilLoaded() {
        waitForElementVisible(inventoryContainer);
    }

    public List<WebElement> getProducts() {
        return driver.findElements(inventoryItems);
    }

    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    public List<WebElement> getProductImages() {
        waitForElementVisible(productImages);
        return driver.findElements(productImages);
    }

    public List<WebElement> getAddToCartButtons() {
        return driver.findElements(addToCartButtons);
    }

    public void clickProductByIndex(int index) {
        getProductNames().get(index).click();
    }

    public void clickFirstProduct() {
        getProductNames().get(0).click();
    }

    public void addProductToCartByIndex(int index) {
        getAddToCartButtons().get(index).click();
    }

    public String getCartCount() {
        try {
            return driver.findElement(cartBadge).getText();
        } catch (NoSuchElementException e) {
            return "0";
        }
    }

    public void goToCart() {
        clickElement(cartIcon);
    }

    public boolean logout() {
        waitForElementClickable(burgerMenu);
        clickElement(burgerMenu);

        waitForElementVisible(logoutLink);
        waitForElementClickable(logoutLink);
        clickElement(logoutLink);
        return true;
    }

   public void addProductToCart(String productName) {
        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        for (WebElement product : products) {
            String name = product.findElement(By.className("inventory_item_name")).getText();

            if (name.equalsIgnoreCase(productName)) {
                WebElement addToCartButton = product.findElement(By.tagName("button"));
                addToCartButton.click();
                return;
            }
        }

        throw new NoSuchElementException("Product with name '" + productName + "' not found on the homepage.");
    }
}
