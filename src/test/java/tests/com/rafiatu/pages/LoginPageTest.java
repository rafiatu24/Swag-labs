package tests.com.rafiatu.pages;

import com.rafiatu.pages.HomePage;
import com.rafiatu.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoginPageTest extends BaseTest {

    @Test
    void testLogin_Successful(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assertions.assertTrue(homePage.isLoaded());
    }

    @Test
    void testLogin_InvalidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.open();

        loginPage.login("invalid_credentials", "secret_sauce");

         boolean errorDisplayed = loginPage.isErrorDisplayed();
         Assertions.assertTrue(errorDisplayed);
        Assertions.assertFalse(homePage.isLoaded());
    }
    @Test
    void testLogout_LogoutAfterLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    loginPage.open();

    loginPage.login("standard_user", "secret_sauce");
    Assertions.assertTrue(homePage.isLoaded());

    Assertions.assertTrue(homePage.logout());
    }
}
