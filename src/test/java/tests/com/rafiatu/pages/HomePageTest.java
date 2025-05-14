package tests.com.rafiatu.pages;

import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

class HomePageTest extends BaseTest {


    @Test
    void testHomePage_shouldLoadQuickly() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        loginPage.open();
            Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");
    Thread.sleep(2000);
        long startTime = System.currentTimeMillis();
        homePage.waitUntilLoaded();
        long loadTime = System.currentTimeMillis() - startTime;
            Thread.sleep(2000);

        System.out.println("Homepage Load Time: " + loadTime + "ms");
        Assertions.assertTrue(loadTime <= 5000, "Homepage should load in 5 seconds or less.");
    }

    @Test
    void testProductListing_showsEssentialDetails() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.open();
           Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");
           Thread.sleep(2000);
        homePage.waitUntilLoaded();
           Thread.sleep(2000);

        List<WebElement> products = homePage.getProducts();
        Assertions.assertFalse(products.isEmpty(), "There should be at least one product on the homepage.");

        for (int i = 0; i < products.size(); i++) {
            WebElement name = homePage.getProductNames().get(i);
            WebElement price = homePage.getProductPrices().get(i);
            WebElement image = homePage.getProductImages().get(i);
            WebElement addToCart = homePage.getAddToCartButtons().get(i);

            Assertions.assertTrue(name.isDisplayed(), "Product name should be visible.");
            Assertions.assertTrue(price.isDisplayed(), "Product price should be visible.");
            Assertions.assertTrue(image.isDisplayed(), "Product image should be visible.");
            Assertions.assertTrue(addToCart.isDisplayed(), "Add to cart button should be visible.");
        }
    }

    @Test
    void testClickingProduct_opensProductDetailPage() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.open();
           Thread.sleep(2000);
        loginPage.login("standard_user", "secret_sauce");
           Thread.sleep(2000);
        homePage.waitUntilLoaded();
           Thread.sleep(2000);

        homePage.clickFirstProduct();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("inventory-item"), "Clicking product should navigate to its detail page.");
    }


}
