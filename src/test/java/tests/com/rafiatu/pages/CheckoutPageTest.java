package tests.com.rafiatu.pages;

import com.rafiatu.pages.CartPage;
import com.rafiatu.pages.CheckoutPage;
import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CheckoutPageTest extends BaseTest {
 @Test
 void testCompleteCheckoutFlow() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        loginPage.open();
         Thread.sleep(1000);
        loginPage.login("standard_user", "secret_sauce");

         Thread.sleep(2000);

        homePage.addProductToCart("Sauce Labs Backpack");
        cartPage.openCart();
         Thread.sleep(2000);

        cartPage.clickCheckout();
        Thread.sleep(2000);

        checkoutPage.enterCheckoutInfo("Rafiatu", "Ibrahim", "00233");
         Thread.sleep(2000);
        checkoutPage.continueToOverview();
         Thread.sleep(2000);

        checkoutPage.clickFinish();
         Thread.sleep(2000);

        Assertions.assertTrue(checkoutPage.isCheckoutCompleteDisplayed(), "Checkout not completed");
        checkoutPage.returnHome();
    }
}