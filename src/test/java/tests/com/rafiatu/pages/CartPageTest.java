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
    void testCartItemCountUpdatesAfterAddingProduct() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
          // Thread.sleep(1000);
        loginPage.login("standard_user", "secret_sauce");
          // Thread.sleep(1000);

        HomePage homePage = new HomePage(driver);
          // Thread.sleep(1000);
        CartPage cartPage = new CartPage(driver);
           //Thread.sleep(1000);

        homePage.addProductToCart("Sauce Labs Backpack");
          // Thread.sleep(1000);

        int itemCountBefore = cartPage.getCartItemCount();
              // Thread.sleep(1000);
        homePage.addProductToCart("Sauce Labs Bike Light");
          // Thread.sleep(1000);
        int itemCountAfter = cartPage.getCartItemCount();

        assertEquals(itemCountBefore + 1, itemCountAfter, "Cart item count did not update correctly.");
         //  Thread.sleep(1000);
    }


    @Test
    void testRemoveProductFromCart() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
           //Thread.sleep(1000);
        loginPage.login("standard_user", "secret_sauce");
          // Thread.sleep(2000);

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.addProductToCart("Sauce Labs Backpack");
       // Thread.sleep(1000);
        cartPage.openCart();
         //  Thread.sleep(1000);

        assertEquals(1, cartPage.getCartItemCount(), "Cart item count should be 1.");
        cartPage.removeProduct(0);
         //  Thread.sleep(1000);

        assertEquals(0, cartPage.getCartItemCount(), "Cart item count should be 0 after removal.");
          // Thread.sleep(1000);
    }

    @Test
    void testCheckoutButtonIsPresent() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
          // Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");
   //Thread.sleep(1000);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.addProductToCart("Sauce Labs Bike Light");
          // Thread.sleep(1000);
        cartPage.openCart();
          // Thread.sleep(3000);

        assertTrue(cartPage.hasCheckoutButton(), "Checkout button is not present on the cart page.");
          // Thread.sleep(2000);
    }

    @Test
    void testCheckoutProcess() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
       //    Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");

        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
         //  Thread.sleep(2000);

        homePage.addProductToCart("Sauce Labs Backpack");
        cartPage.openCart();
        //   Thread.sleep(2000);

        assertTrue(cartPage.hasCheckoutButton(), "Checkout button is not present.");
        cartPage.clickCheckout();
         //  Thread.sleep(2000);

        assertTrue(driver.getCurrentUrl().contains("checkout-step-one"), "Did not navigate to checkout page.");

    }
}
