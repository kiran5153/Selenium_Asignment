@SeleniumTest
Feature: Selenium Test Scenarios
  As an Admin, I should be able to Add/Delete/Edit 'Users'

  Background: Open browser
    Given User is on Selenium Test home page

  Scenario: Verify the UI layout of 'Selenium Test' page"
    Then User should be able to view all fields as per UX/FSD

  Scenario: Verify the user details are listed in the homepage
    Then I verify the following User details on the homepage
      | firstName | surName  | address              | postCode  | city      | countryCode | country         |
      | Mark      | Stincer  | 23 Stringpay Road    | SX5 12G   | Bradford  | GB          | United Kingdom  |
      | George    | Meloni   | 34 Highground Road   | SX2 B12   | Bristol   | GB          | United Kingdom  |
      | Marcus    | Schmidt  | 34 Schule Strasse    | AX4 B12   | Munich    | DE          | Germany         |

  Scenario: Verify Admin is able to Add new users
    When I add a new User with the following details
      | firstName | surName  | address              | postCode  | city      | countryCode | country         |
      | Kiran     | Shankar  | 355D Alexandra Avenue| HA2 9EB   | London    | GB          | United Kingdom  |
      | Naksh     | Kiran    | 123 Vijaynagar       | 560086    | India     | IN          | India           |
    Then The newly created User should be listed on the homepage

  Scenario: Verify Admin is able to Edit an existing user
    When I edit a user with the following details
      | firstName | surName  | address              | postCode  | city      | countryCode | country         |
      | Mark      | Stincer  | 355D Alexandra Avenue| HA2 9EB   | London    | GB          | United Kingdom  |
  Then The updated User details should be listed on the homepage

  Scenario: Verify Admin is able to Delete an existing user
    When I delete a User: "Mark" "Stincer"
    Then The deleted User: "Mark" "Stincer" should not be listed on the homepage
