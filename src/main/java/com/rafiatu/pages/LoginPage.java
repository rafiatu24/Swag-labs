package com.rafiatu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMsg = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        typeText(username, user);
        typeText(password, pass);
        waitForElementClickable(loginBtn);
        clickElement(loginBtn);
    }


 public boolean isLoaded() {
        return waitForElementVisible(By.className("login-box")).isDisplayed();
}

    public boolean isErrorDisplayed() {
        try { return waitForElementVisible(errorMsg).isDisplayed(); }
        catch (Exception e) {
            return false;
        }
    }
}
