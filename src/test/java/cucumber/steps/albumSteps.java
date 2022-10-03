package cucumber.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ThreadLocalDriver;

public class albumSteps extends BaseSteps {
    @Before
    public void setupSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @When("User navigates to albums page")
    public void user_navigates_to_albums_page() {
        userDetailsScreen.goToAlbums();
    }

    @Then("User validates the {string} associated with the user")
    public void user_validates_the_associated_with_the_user(String albums) {
        String[] albumItems = albums.split(",");

        albumScreen.checkAlbumItems(albumItems);
    }
}
