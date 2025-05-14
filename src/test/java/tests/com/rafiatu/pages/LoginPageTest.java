package tests.com.rafiatu.pages;

import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginPageTest extends BaseTest {

    @Test
    void testLogin_Successful() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.open();
           Thread.sleep(2000);

        loginPage.login("standard_user", "secret_sauce");
           Thread.sleep(3000);
        Assertions.assertTrue(homePage.isLoaded());
    }

    @Test
    void testLogin_InvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.open();
           Thread.sleep(2000);

        loginPage.login("invalid_credentials", "secret_sauce");
           Thread.sleep(3000);

         boolean errorDisplayed = loginPage.isErrorDisplayed();
         Assertions.assertTrue(errorDisplayed);
        Assertions.assertFalse(homePage.isLoaded());
    }
    @Test
    void testLogout_LogoutAfterLogin() throws InterruptedException {
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    loginPage.open();
       Thread.sleep(2000);

    loginPage.login("standard_user", "secret_sauce");
       Thread.sleep(2000);
    Assertions.assertTrue(homePage.isLoaded());
       Thread.sleep(2000);

    Assertions.assertTrue(homePage.logout());
       Thread.sleep(3000);
    }
}
