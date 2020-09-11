package pageobject.steps;

import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import pageobject.pages.HomePage;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class TodoUserSteps {

    HomePage todoListPage;
    EnvironmentVariables environmentVariables;

    // -----------------------------------------------------------------------------------------------------------------
    // STEPS (9 in total)

    @Step
    public void starts_with_an_empty_todo_list() {
        todoListPage.openAt("http://www.google.com");
        starts_with_a_todo_list_containing();
    }



    @Step
    public void starts_with_a_todo_list_containing(String... items) {
        todoListPage.openApplication();

        String baseUrl = ThucydidesSystemProperty.WEBDRIVER_BASE_URL.from(environmentVariables);


        adds_todo_items_called(items);
    }

    @Step
    public void adds_todo_items_called(String... items) {
        asList(items).forEach(this::adds_a_todo_item_called);
    }

    @Step
    public void adds_a_todo_item_called(String item) {
        todoListPage.addNewTodo(item);
    }

    @Step
    public void completes(String item) {
        todoListPage.completeTodo(item);
    }

    @Step
    public void clears_completed_items() {
        todoListPage.clearCompletedItems();
    }

    @Step
    public void should_see_that_displayed_items_contain(String... items) {
        assertThat(todoListPage.displayedItems(), hasItems(items));
    }

}
