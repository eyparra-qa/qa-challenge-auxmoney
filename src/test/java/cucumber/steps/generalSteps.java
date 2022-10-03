package cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import utilities.ThreadLocalDriver;

public class generalSteps extends BaseSteps {
    @Before
    public void setupSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @Then("User validate that when moving to the left the new item is {string} in {string} page")
    public void user_validate_that_when_moving_to_the_left_the_new_item_is_in_page(String newItemText, String menu) {
        userDetailsScreen.moveItemsToTheLeft(menu, newItemText);
    }
}
