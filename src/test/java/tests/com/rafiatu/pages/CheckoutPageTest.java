package tests.com.rafiatu.pages;

import com.rafiatu.pages.CartPage;
import com.rafiatu.pages.CheckoutPage;
import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CheckoutPageTest extends BaseTest {
 @Test
 void testCompleteCheckoutFlow() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        homePage.addProductToCart("Sauce Labs Backpack");
        cartPage.openCart();

        cartPage.clickCheckout();

        checkoutPage.enterCheckoutInfo("Rafiatu", "Ibrahim", "00233");
        checkoutPage.continueToOverview();

        checkoutPage.clickFinish();

        Assertions.assertTrue(checkoutPage.isCheckoutCompleteDisplayed(), "Checkout not completed");
        checkoutPage.returnHome();
    }
}