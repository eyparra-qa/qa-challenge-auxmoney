package cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ThreadLocalDriver;

import java.util.List;

public class todosSteps extends BaseSteps {
    @Before
    public void setupSteps() {
        setupScreens(ThreadLocalDriver.getTLDriver());
    }

    @When("User navigates to todos page")
    public void user_navigates_to_todos_page() {
        userDetailsScreen.goToTodos();
    }

    @Then("User validates the todos associated with the user")
    public void user_validates_the_todos_associated_with_the_user(DataTable dataTable) {
        List<String> data = dataTable.asList();
        todoScreen.checkTodosList(data);
    }

    @Then("User change the status of the tasks")
    public void user_change_the_status_of_the_tasks(DataTable dataTable) {
        List<String> data = dataTable.asList();
        todoScreen.changeTaskStatus(data);
    }
}
