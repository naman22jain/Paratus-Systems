package org.example;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static junit.framework.Assert.assertTrue;

public class GmailStepDefinition {
    WebDriver driver;
    GmailLoginPage loginPage;
    GmailInboxPage inboxPage;
    GmailComposePage composePage;

    @Given("^I am on the Gmail login page$")
    public void iAmOnTheGmailLoginPage() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        loginPage = new GmailLoginPage(driver);
        loginPage.navigateToLoginPage();
    }

    @When("^I log in with valid credentials$")
    public void iLogInWithValidCredentials() {
        loginPage.login("deathshot283@gmail.com", "******");
    }

    @Then("^I should be on the Gmail inbox page$")
    public void iShouldBeOnTheGmailInboxPage() {
        inboxPage = new GmailInboxPage(driver);
        assertTrue(inboxPage.isOnInboxPage());
    }

    @When("^I compose a new email$")
    public void iComposeANewEmail() {
        inboxPage.clickComposeButton();
    }

    @And("^I fill in the necessary fields$")
    public void iFillInTheNecessaryFields() {
        composePage = new GmailComposePage(driver);
        composePage.fillRecipient("recipient@example.com");
        composePage.fillSubject("Test Email");
        composePage.fillBody("This is a test email.");
    }

    @And("^I attach a file \"([^\"]*)\"$")
    public void iAttachAFile(String fileName) {
        composePage.attachFile(fileName);
    }

    @And("^I add CC recipient \"([^\"]*)\"$")
    public void iAddCCRecipient(String ccRecipient) {
        composePage.addCcRecipient(ccRecipient);
    }

    @And("^I add BCC recipient \"([^\"]*)\"$")
    public void iAddBCCRecipient(String bccRecipient) {
        composePage.addBccRecipient(bccRecipient);
    }


    @And("^I click on the send button$")
    public void iClickOnTheSendButton() {
        composePage.clickSendButton();
    }

    @Then("^the email should be sent successfully$")
    public void theEmailShouldBeSentSuccessfully() {
        assertTrue(composePage.isEmailSent());
        driver.quit();
    }

    @When("^I click on the save draft button$")
    public void iClickOnTheSaveDraftButton() {
        composePage.clickSaveDraftButton();
    }

    @Then("^the email should be saved as draft$")
    public void theEmailShouldBeSavedAsDraft() {
        assertTrue(composePage.isEmailSavedAsDraft());
        driver.quit();
    }

    @When("^I click on the discard button$")
    public void iClickOnTheDiscardButton() {
        composePage.clickDiscardButton();
    }

    @Then("^the email should be discarded$")
    public void theEmailShouldBeDiscarded() {
        assertTrue(composePage.isEmailDiscarded());
        driver.quit();
    }

    @Then("^the email should be sent successfully with high priority$")
    public void theEmailShouldBeSentSuccessfullyWithHighPriority() {
        assertTrue(composePage.isEmailSent());
        assertTrue(composePage.isEmailHighPriority());
        driver.quit();
    }

    @And("^I fill in the necessary fields with multiple recipients$")
    public void iFillInTheNecessaryFieldsWithMultipleRecipients() {
        composePage.fillRecipient("recipient1@example.com,recipient2@example.com");
        composePage.fillSubject("Test Email");
        composePage.fillBody("This is a test email to multiple recipients.");
    }
}
