package tests.com.rafiatu.pages;

import com.rafiatu.pages.CartPage;
import com.rafiatu.pages.CheckoutPage;
import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;

/**
public class SwagLabsTest extends BaseTest {

    @Test
    public void testFullUserFlow() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        // Login
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(homePage.isLoaded());

        // Add to cart
        homePage.addProductToCartByIndex(0);
        homePage.addProductToCartByIndex(1);
        Assert.assertEquals("2", homePage.getCartCount());

        // Cart actions
        homePage.goToCart();
        cartPage.removeFirstItem();

        // Checkout
        cartPage.clickCheckout();
        checkoutPage.fillForm("Rafiatu", "Ibrahim", "00233");
        checkoutPage.finishOrder();

        // Confirmation
        Assert.assertTrue(checkoutPage.isOrderConfirmed());

        // Logout
        homePage.logout();
    }

    @Test
    public void testInvalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login("wrong_user", "wrong_pass");
        Assert.assertTrue(loginPage.isErrorDisplayed());
    }
}
 **/
