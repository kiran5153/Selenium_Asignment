package pageObjects;
import basePage.UserData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.DriverFactory;
import utilities.GenericUtility;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SeleniumTest  {

    GenericUtility genericUtility;
    public SeleniumTest () {
        PageFactory.initElements(DriverFactory.getWebDriver(), this);
        genericUtility = new GenericUtility();
    }

//********************************OBJECTS*********************************************

    @FindBy(id = "btnAdd")
    private WebElement addUser;

    @FindBy(css = ".toolbar img")
    private WebElement angularLogo;

    @FindBy(css = ".toolbar span")
    private WebElement  welcomeText;

    @FindBy(id = "Ellipse_8")
    private WebElement  rocketShipLogo;

    @FindBy(css = ".card.highlight-card.card-small span")
    private WebElement pageTitle;

    @FindBy(id = "lisTable")
    private WebElement  usersTable;

    /* Table elements*/
    @FindBy(xpath = "//tr//td[contains(@id, 'txtName')]")
    private List<WebElement> firstNames;

    @FindBy(xpath = "//tr//td[contains(@id, 'txtSurname')]")
    private List<WebElement> surNames;

    @FindBy(xpath = "//tr//td[contains(@id, 'txtAddress')]")
    private List<WebElement> addresses;

    @FindBy(xpath = "//tr//td[contains(@id, 'txtPostCode')]")
    private List<WebElement> postCodes;

    @FindBy(xpath = "//tr//td[contains(@id, 'txtCity')]")
    private List<WebElement> cities;

    @FindBy(css = "tr td[id$=txtCountry]")
    private List<WebElement> countryCodes;

    @FindBy(xpath = "//tr//td[contains(@id, 'txtCountryName')]")
    private List<WebElement> countries;

    @FindBy(xpath = "//tr//td/button[@id='btnEdit']")
    private List<WebElement> editUsers;

    @FindBy(xpath = "//tr//td/button[@id='btnDelete']")
    private List<WebElement> deleteUsers;


    /* Add User */
    @FindBy(css = ".modal-header>h6")
    private WebElement addNewUserLabel;

    @FindBy(id = "txtName")
    private WebElement firstName;

    @FindBy(id = "btnCancelHeader")
    private WebElement modelDismiss;

    @FindBy(id = "txtSurname")
    private WebElement surName;

    @FindBy(id = "txtAddress")
    private WebElement address;

    @FindBy(id = "txtPostCode")
    private WebElement postCode;

    @FindBy(id = "txtCity")
    private WebElement city;

    @FindBy(id = "ddlCountry")
    private WebElement country;

    @FindBy(id = "btnCancel")
    private WebElement cancelBtn;

    @FindBy(id = "btnSave")
    private WebElement saveBtn;

    @FindBy(css = ".btn.btn-secondary")
    private WebElement deleteBtn;


//**********************************METHODS*****************************************

    public void verifyUserIsOnHomepage() {
        try {
            genericUtility.waitForPageLoad();
            assertTrue("Failed to load 'Selenium Test' page", angularLogo.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public  void verifySTuiLayout (){
        try {
            assertTrue("'Welcome Text' is not present in the page", welcomeText.getText().contains("Welcome"));
            assertTrue("'Page Logo' is not present in the page", angularLogo.isDisplayed());
            assertTrue("'Rocket Ship Logo' is not present in the page", rocketShipLogo.isDisplayed());
            assertTrue("'Page Title' is not present in the page", pageTitle.getText().contains("Users"));
            assertTrue("'Add User' is not present in the page", addUser.isDisplayed());
            assertTrue("'User Details Table' is not present in the page", usersTable.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    public void clickOnAddUser() {
        try {
            addUser.click();
            genericUtility.waitForElementToBePresent(addNewUserLabel);
            assertTrue("Failed to open 'Add New User' modal", addNewUserLabel.isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void verifyUserDetails(Map<String, String> userDetails) {
        try {
            boolean userFound = false;
            assertTrue("XPATH/CSS issue", firstNames.size() == postCodes.size() && firstNames.size() == countries.size());

            for (int i = 0; i < firstNames.size(); i++) {
                if (firstNames.get(i).getText().equalsIgnoreCase(userDetails.get("firstName"))) {
                    assertEquals("Mismatch in Surname displayed for " + userDetails.get("firstName"),
                            userDetails.get("surName"), surNames.get(i).getText());

                    assertEquals("Mismatch in Address displayed for " + userDetails.get("firstName"),
                            userDetails.get("address"), addresses.get(i).getText());

                    assertEquals("Mismatch in PostCode displayed for " + userDetails.get("firstName"),
                            userDetails.get("postCode"), postCodes.get(i).getText());

                    assertEquals("Mismatch in City displayed for " + userDetails.get("firstName"),
                            userDetails.get("city"), cities.get(i).getText());

                    assertEquals("Mismatch in Country Code displayed for " + userDetails.get("firstName"),
                            userDetails.get("countryCode"), countryCodes.get(i).getText());

                    assertEquals("Mismatch in Country displayed for " + userDetails.get("firstName"),
                            userDetails.get("country"), countries.get(i).getText());

                    userFound = true;
                    break;
                }
            }
            if (!userFound)
                fail(userDetails.get("firstName") + ": was not found in the User list");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void addNewUser(Map<String, String> userDetails) {
        try {
            addUser.click();
            genericUtility.waitForElementToBePresent(addNewUserLabel);
            assertTrue("'Add New User' modal is not visible", addNewUserLabel.isDisplayed());

            firstName.sendKeys(userDetails.get("firstName"));
            surName.sendKeys(userDetails.get("surName"));
            address.sendKeys(userDetails.get("address"));
            postCode.sendKeys(userDetails.get("postCode"));
            city.sendKeys(userDetails.get("city"));
            genericUtility.selectDropdownOption(country, userDetails.get("country"));
            saveBtn.click();
            genericUtility.waitForPageLoad();

            new UserData().addUserDetails(userDetails);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void editUser(Map<String, String> userDetails) {
        try {
            boolean userFound = false;
            assertTrue("XPATH/CSS issue", firstNames.size() == editUsers.size());

            for (int i = 0; i < firstNames.size(); i++) {
                if (firstNames.get(i).getText().equalsIgnoreCase(userDetails.get("firstName"))) {
                    editUsers.get(i).click();
                    genericUtility.waitForElementToBePresent(addNewUserLabel);
                    assertTrue("'Edit User' modal is not visible", addNewUserLabel.isDisplayed());

                    firstName.clear();
                    firstName.sendKeys(userDetails.get("firstName"));
                    surName.clear();
                    surName.sendKeys(userDetails.get("surName"));
                    address.clear();
                    address.sendKeys(userDetails.get("address"));
                    postCode.clear();
                    postCode.sendKeys(userDetails.get("postCode"));
                    city.clear();
                    city.sendKeys(userDetails.get("city"));
                    genericUtility.selectDropdownOption(country, userDetails.get("country"));
                    saveBtn.click();
                    genericUtility.waitForPageLoad();

                    new UserData().addUserDetails(userDetails);
                    userFound = true;
                    break;
                }
            }
            if (!userFound)
                fail(userDetails.get("firstName") + ": was not found in the User list");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void deleteUser(String firstName, String surName) {
        try {
            boolean userFound = false;
            assertTrue("XPATH/CSS issue", firstNames.size() == deleteUsers.size());

            for (int i = 0; i < firstNames.size(); i++) {
                if (firstNames.get(i).getText().equalsIgnoreCase(firstName) && surNames.get(i).getText().equalsIgnoreCase(surName)) {
                    deleteUsers.get(i).click();
                    genericUtility.waitForElementToBePresent(deleteBtn);
                    assertTrue("'Delete User' popup is not visible", deleteBtn.isDisplayed());
                    deleteBtn.click();
                    genericUtility.waitForPageLoad();
                    userFound = true;
                }
            }
            if (!userFound)
                fail(firstName + " " + surName + ": was not found in the User list");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void VerifyUserIsNotInList(String firstName, String surName) {
        try {
            boolean userFound = false;
            assertTrue("XPATH/CSS issue", firstNames.size() == surNames.size());

            for (int i = 0; i < firstNames.size(); i++) {
                if (firstNames.get(i).getText().equalsIgnoreCase(firstName) && surNames.get(i).getText().equalsIgnoreCase(surName)) {
                    userFound = true;
                }
            }
            if (userFound)
                fail(firstName + " " + surName + ": was found in the User list - Failed to delete");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

}
