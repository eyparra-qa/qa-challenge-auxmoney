package cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ThreadLocalDriver;

import java.util.List;

public class postsSteps extends BaseSteps{
    @Before
    public void setupSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @When("User navigates to posts page")
    public void user_navigates_to_posts_page() {
        userDetailsScreen.goToPosts();
    }

    @When("User clicks on the first comment")
    public void user_clicks_on_the_first_comment() {
        postScreen.clickOnFirstComment();
    }

    @Then("User validates the posts associated with the user")
    public void user_validates_the_posts_associated_with_the_user(DataTable dataTable) {
        List<String> data = dataTable.asList();
        postScreen.checkPostsList(data);
    }

    @Then("User validates the comments of the first post")
    public void user_validates_the_comments_of_the_first_post(DataTable dataTable) {
        List<String> data = dataTable.asList();
        postScreen.checkCommentsOfPost(data);
    }

    @Then("User checks that can go back to the main page")
    public void user_checks_that_can_go_back_to_the_main_page() {
        postScreen.goBackToUsersPage();
    }
}
