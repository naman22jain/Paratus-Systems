Feature: Compose and Send Email
  As a user of Gmail
  I want to compose and send an email

  Background:
    Given I am on the Gmail login page
    When I log in with valid credentials
    Then I should be on the Gmail inbox page

  Scenario: Compose and send email with attachment
    When I compose a new email
    And I fill in the necessary fields
    And I attach a file "test_document.txt"
    And I click on the send button
    Then the email should be sent successfully

  Scenario: Compose and send email with CC and BCC
    When I compose a new email
    And I fill in the necessary fields
    And I add CC recipient "cc@example.com"
    And I add BCC recipient "bcc@example.com"
    And I click on the send button
    Then the email should be sent successfully


  Scenario: Save email as draft
    When I compose a new email
    And I fill in the necessary fields
    And I click on the save draft button
    Then the email should be saved as draft

  Scenario: Discard email
    When I compose a new email
    And I fill in the necessary fields
    And I click on the discard button
    Then the email should be discarded


  Scenario: Send email to multiple recipients
    When I compose a new email
    And I fill in the necessary fields with multiple recipients
    And I click on the send button
    Then the email should be sent successfully to all recipients

  Scenario: Verify sent email in Sent folder
    Given I am on the Gmail sent folder page
    When I open the latest sent email
    Then the email content should match the one I composed
