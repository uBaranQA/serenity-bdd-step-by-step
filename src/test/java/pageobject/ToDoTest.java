package pageobject;

import org.junit.Assert;
import org.junit.Test;
import pageobject.pages.HomePage;

import java.util.Optional;


public class ToDoTest extends BaseTest {

    private static final String NEW_TASK = "New task";

    @Test
    public void userCanAddNewToDoTaskTest() {
        HomePage homePage = new HomePage(getDriver(), getConfig().getBaseUrl());
        homePage.addNewTodo(NEW_TASK);

        Optional addedToDo = homePage.getAllToDos().stream()
                .filter(element -> element.getText().equals(NEW_TASK))
                .findFirst();

        Assert.assertTrue(addedToDo.isPresent());
    }
}
