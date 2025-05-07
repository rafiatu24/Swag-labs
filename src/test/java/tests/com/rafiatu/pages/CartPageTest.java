package tests.com.rafiatu.pages;


import com.rafiatu.pages.CartPage;
import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class CartPageTest extends BaseTest {

    @Test
    void testCartPageIsLoaded() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        assertTrue(cartPage.isLoaded(), "Cart page is not loaded.");
    }

    @Test
    void testCartItemCountUpdatesAfterAddingProduct() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.addProductToCart("Sauce Labs Backpack");

        int itemCountBefore = cartPage.getCartItemCount();

        homePage.addProductToCart("Sauce Labs Bike Light");
        int itemCountAfter = cartPage.getCartItemCount();

        assertEquals(itemCountBefore + 1, itemCountAfter, "Cart item count did not update correctly.");
    }

    @Test
    void testRemoveProductFromCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.addProductToCart("Sauce Labs Backpack");
        cartPage.openCart();

        assertEquals(1, cartPage.getCartItemCount(), "Cart item count should be 1.");
        cartPage.removeProduct(0);

        assertEquals(0, cartPage.getCartItemCount(), "Cart item count should be 0 after removal.");
    }

    @Test
    void testCheckoutButtonIsPresent() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.addProductToCart("Sauce Labs Bike Light");
        cartPage.openCart();

        assertTrue(cartPage.hasCheckoutButton(), "Checkout button is not present on the cart page.");
    }

    @Test
    void testCheckoutProcess() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.addProductToCart("Sauce Labs Backpack");
        cartPage.openCart();

        assertTrue(cartPage.hasCheckoutButton(), "Checkout button is not present.");
        cartPage.clickCheckout();

        assertTrue(driver.getCurrentUrl().contains("checkout-step-one"), "Did not navigate to checkout page.");

    }
}
