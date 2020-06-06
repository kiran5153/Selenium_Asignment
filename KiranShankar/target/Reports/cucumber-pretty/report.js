$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/features/ST_Scenarios.feature");
formatter.feature({
  "name": "Selenium Test Scenarios",
  "description": "  As an Admin, I should be able to Add/Delete/Edit \u0027Users\u0027",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@SeleniumTest"
    }
  ]
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Selenium Test home page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.userIsOnSeleniumTestHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify the UI layout of \u0027Selenium Test\u0027 page\"",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SeleniumTest"
    }
  ]
});
formatter.step({
  "name": "User should be able to view all fields as per UX/FSD",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.userShouldBeAbleToViewAllFields()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Selenium Test home page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.userIsOnSeleniumTestHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify the user details are listed in the homepage",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SeleniumTest"
    }
  ]
});
formatter.step({
  "name": "I verify the following User details on the homepage",
  "rows": [
    {},
    {},
    {},
    {}
  ],
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.iSeeTheUserDetailsListedOnTheHomepage(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Selenium Test home page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.userIsOnSeleniumTestHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Admin is able to Add new users",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SeleniumTest"
    }
  ]
});
formatter.step({
  "name": "I add a new User with the following details",
  "rows": [
    {},
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.iAddUserWithFollowingDetails(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The newly created User should be listed on the homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.theNewlyCreatedUserShouldBeListedOnTheHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Selenium Test home page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.userIsOnSeleniumTestHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Admin is able to Edit an existing user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SeleniumTest"
    }
  ]
});
formatter.step({
  "name": "I edit a user with the following details",
  "rows": [
    {},
    {}
  ],
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.iEditAUserWithTheFollowingDetails(io.cucumber.datatable.DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The updated User details should be listed on the homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.theNewlyCreatedUserShouldBeListedOnTheHomepage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "Open browser",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Selenium Test home page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.userIsOnSeleniumTestHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify Admin is able to Delete an existing user",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SeleniumTest"
    }
  ]
});
formatter.step({
  "name": "I delete a User: \"Mark\" \"Stincer\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.iDeleteAUser(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "The deleted User: \"Mark\" \"Stincer\" should not be listed on the homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinations.ST_Stepdefs.theDeletedUserShouldNotBeListedOnTheHomepage(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});