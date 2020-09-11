package pageobject;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageobject.steps.TodoUserSteps;

@RunWith(SerenityRunner.class)
public class MaintainTodosTest extends BaseTest {


    private static final String WALK_THE_DOG = "Walk the dog";
    private static final String PREPARE_A_DINNER = "Prepare a dinner";

    @Managed
    WebDriver driver;

    @Steps
    TodoUserSteps anna;

    @Test
    public void should_be_able_to_clear_completed_todos() {
        anna.starts_with_a_todo_list_containing(WALK_THE_DOG, PREPARE_A_DINNER);

        anna.completes(WALK_THE_DOG);

        anna.clears_completed_items();

        anna.should_see_that_displayed_items_contain(PREPARE_A_DINNER);
    }
}
