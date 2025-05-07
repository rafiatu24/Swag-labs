package com.rafiatu.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    private final By finishButton = By.id("finish");
    private final By cancelButton = By.id("cancel");

    private final By checkoutCompleteHeader = By.className("complete-header");
    private final By backHomeButton = By.id("back-to-products");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterCheckoutInfo(String firstName, String lastName, String postalCode) {
        typeText(firstNameInput, firstName);
        typeText(lastNameInput, lastName);

        WebElement pc = driver.findElement(postalCodeInput);
        pc.clear();
        pc.sendKeys(postalCode);
    }

    public void continueToOverview() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        clickElement(finishButton);
    }

    public void clickCancel() {
        clickElement(cancelButton);
    }

    public boolean isCheckoutCompleteDisplayed() {
        return getText(checkoutCompleteHeader).contains("Thank you for your order!"); // Inherited from BasePage
    }

    public void returnHome() {
        clickElement(backHomeButton);
    }
}
