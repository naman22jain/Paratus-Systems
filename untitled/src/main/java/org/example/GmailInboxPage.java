package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailInboxPage {
    private WebDriver driver;

    private By composeButton = By.xpath("//div[text()='Compose']");

    public GmailInboxPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickComposeButton() {
        driver.findElement(composeButton).click();
    }

    public boolean isOnInboxPage() {
        // Implement logic to verify if the inbox page is loaded
        return true;
    }
}
