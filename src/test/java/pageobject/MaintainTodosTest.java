package pageobject;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaintainTodosTest extends BaseTest {


    private static final String WALK_THE_DOG = "Walk the dog";
    private static final String PREPARE_A_DINNER = "Prepare a dinner";

    @Override
    @Before
    public void setUp() throws Exception {
        super.setUp();
        homePage.addNewTodo(WALK_THE_DOG);
        homePage.addNewTodo(PREPARE_A_DINNER);
    }

    @Test
    public void should_be_able_to_clear_completed_todos() {
        homePage.completeTodo(WALK_THE_DOG);
        assertThat(checkIfTodoIsVisibleOnTheList(homePage.getAllToDos(), PREPARE_A_DINNER).isPresent(), equalTo(true));
    }
}
