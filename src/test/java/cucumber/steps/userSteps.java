package cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ThreadLocalDriver;

public class userSteps extends BaseSteps {
    @Before
    public void setupSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @Given("User is in the users page")
    public void user_is_in_the_users_page() {
        userInfoScreen.waitUntilToolbarIsDisplayed();
    }

    @When("User clicks on the {string} to see the details info")
    public void user_clicks_on_the_to_see_the_details_info(String userName) {
        userInfoScreen.clickOnUser(userName);
    }

    @When("User navigates to albums page of {string}")
    public void user_navigates_to_albums_page_of(String userName) {

    }

    @Then("User searches the list by {string}")
    public void user_searches_the_list_by(String userName) {
        userInfoScreen.searchByUser(userName);
    }

    @Then("Verify that the user name is {string}")
    public void verify_that_the_user_name_is(String userName) {
        userInfoScreen.checkUserInfo (userName, "userName", userName);
    }

    @Then("Verify that the {string} have the nickName {string}")
    public void verify_that_the_have_the_nick_name(String userName, String nickName) {
        userInfoScreen.checkUserInfo (userName, "userNickName", nickName);
    }

    @Then("Verify that the {string} have the company name {string}")
    public void verify_that_the_have_the_company_name(String userName, String company) {
        userInfoScreen.checkUserInfo (userName, "company", company);
    }

    @Then("User check that can scroll down in the page")
    public void user_check_that_can_scroll_down_in_the_page() {
        userInfoScreen.scrollDownInUsersPage();
    }

    @Then("User verify that the user name is {string}")
    public void user_verify_that_the_user_name_is(String userName) {
        userInfoScreen.checkInformationInUserDetails("userName", userName);
    }

    @Then("User verify that the nick name is {string}")
    public void user_verify_that_the_nick_name_is(String nickName) {
        userInfoScreen.checkInformationInUserDetails("nickName", nickName);
    }

    @Then("User verify that the webside is {string}")
    public void user_verify_that_the_webside_is(String webside) {
        userInfoScreen.checkInformationInUserDetails("webside", webside);
    }

    @Then("User verify that the email is {string}")
    public void user_verify_that_the_email_is(String email) {
        userInfoScreen.checkInformationInUserDetails("email", email);
    }

    @Then("User verify that the company is {string}")
    public void user_verify_that_the_company_is(String companyName) {
        userInfoScreen.checkInformationInUserDetails("company", companyName);
    }

    @Then("User clicks on back button and should see list of users page")
    public void user_clicks_on_back_button_and_should_see_list_of_users_page() {
        userInfoScreen.backButtonValidation();
    }
}