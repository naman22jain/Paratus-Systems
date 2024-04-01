package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailComposePage {
    private WebDriver driver;

    private By toField = By.name("to");
    private By subjectField = By.name("subjectbox");
    private By bodyField = By.xpath("//div[@role='textbox']");
    private By sendButton = By.xpath("//div[contains(@aria-label, 'Send')]");
    private By attachFileButton = By.xpath("//input[@type='file']");
    private By ccField = By.name("cc");
    private By bccField = By.name("bcc");
    private By saveDraftButton = By.xpath("//div[@aria-label='Save & close']");
    private By discardButton = By.xpath("//div[contains(@aria-label, 'Discard')]");

    public GmailComposePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRecipient(String recipient) {
        driver.findElement(toField).sendKeys(recipient);
    }

    public void fillSubject(String subject) {
        driver.findElement(subjectField).sendKeys(subject);
    }

    public void fillBody(String body) {
        driver.findElement(bodyField).sendKeys(body);
    }

    public void clickSendButton() {
        driver.findElement(sendButton).click();
    }

    public void attachFile(String filePath) {
        driver.findElement(attachFileButton).sendKeys(filePath);
    }

    public void addCcRecipient(String ccRecipient) {
        driver.findElement(ccField).sendKeys(ccRecipient);
    }

    public void addBccRecipient(String bccRecipient) {
        driver.findElement(bccField).sendKeys(bccRecipient);
    }

    public void clickSaveDraftButton() {
        driver.findElement(saveDraftButton).click();
    }

    public void clickDiscardButton() {
        driver.findElement(discardButton).click();
    }

    public boolean isEmailSent() {
        // Implement logic to verify if the email is sent successfully
        return true;
    }

    public boolean isEmailSavedAsDraft() {
        // Implement logic to verify if the email is saved as draft
        return true;
    }

    public boolean isEmailDiscarded() {
        // Implement logic to verify if the email is discarded
        return true;
    }

    public boolean isEmailHighPriority() {
        // Implement logic to verify if the email is sent with high priority
        return true;
    }
}
