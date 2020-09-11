package pageobject;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import pageobject.pages.HomePage;

import java.util.Optional;

@RunWith(SerenityRunner.class)
public class ToDoTest extends BaseTest {

    private static final String NEW_TASK = "New task";

    @Managed
    WebDriver driver;

    @ManagedPages
    HomePage homePage;

    @Test
    public void userCanAddNewToDoTaskTest() {
        homePage.addNewTodo(NEW_TASK);

        Optional addedToDo = checkIfTodoIsVisibleOnTheList(homePage.getAllToDos(), NEW_TASK);

        Assert.assertTrue(addedToDo.isPresent());
    }
}
