package stepDefinations;
import basePage.BasePage;
import basePage.UserData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;

public class ST_Stepdefs {
    private BasePage basePage = new BasePage();

    @Given("^User is on Selenium Test home page$")
    public void userIsOnSeleniumTestHomePage() {
        basePage.seltstPgObj.verifyUserIsOnHomepage();
    }

    @Then("^User should be able to view all fields as per UX\\/FSD$")
    public void userShouldBeAbleToViewAllFields() {
        basePage.seltstPgObj.verifySTuiLayout();
    }

        @Then("^I verify the following User details on the homepage$")
    public void iSeeTheUserDetailsListedOnTheHomepage(DataTable userDetails) {
        List<Map<String, String>> cstInfoMap = userDetails.asMaps();
        for (Map mapItem : cstInfoMap) {
            basePage.seltstPgObj.verifyUserDetails(mapItem);
        }
    }

    @And("^I add a new User with the following details$")
    public void iAddUserWithFollowingDetails(DataTable userDetails) {
        new UserData().clearDetails();
        List<Map<String, String>> cstInfoMap = userDetails.asMaps(String.class, String.class);
        for (Map mapItem : cstInfoMap) {
            basePage.seltstPgObj.addNewUser(mapItem);
        }
    }

    @Then("^.* User .* listed on the homepage$")
    public void theNewlyCreatedUserShouldBeListedOnTheHomepage() {
        List<Map<String, String>> cstInfoMap = new UserData().getUserDetails();
        for (Map mapItem : cstInfoMap) {
            basePage.seltstPgObj.verifyUserDetails(mapItem);
        }
    }

    @When("I edit a user with the following details")
    public void iEditAUserWithTheFollowingDetails(DataTable userDetails) {
        new UserData().clearDetails();
        List<Map<String, String>> cstInfoMap = userDetails.asMaps(String.class, String.class);
        for (Map mapItem : cstInfoMap) {
            basePage.seltstPgObj.editUser(mapItem);
        }
    }

    @When("^I delete a User: \"(.*)\" \"(.*)\"$")
    public void iDeleteAUser(String firstName, String surName) {
        basePage.seltstPgObj.deleteUser(firstName, surName);
    }

    @Then("^The deleted User: \"(.*)\" \"(.*)\" should not be listed on the homepage$")
    public void theDeletedUserShouldNotBeListedOnTheHomepage(String firstName, String surName) {
        basePage.seltstPgObj.VerifyUserIsNotInList(firstName, surName);
    }

}
