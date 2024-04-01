package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailLoginPage {
    private WebDriver driver;

    private By usernameField = By.id("identifierId");
    private By nextButton = By.id("identifierNext");
    private By passwordField = By.name("password");
    private By loginButton = By.id("passwordNext");

    public GmailLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToLoginPage() {
        driver.get("https://mail.google.com");
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(nextButton).click();
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
