package screenplay;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import screenplay.questions.TheItems;
import screenplay.tasks.AddATodoItem;
import screenplay.tasks.Start;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class AddNewTodos {

    private Actor john = Actor.named("John");

    @Managed
    private WebDriver hisBrowser;

    @Before
    public void jamesCanBrowseTheWeb() {
        john.can(BrowseTheWeb.with(hisBrowser));
    }

    @Test
    public void should_be_able_to_add_the_first_todo_item() {

        givenThat(john).wasAbleTo(Start.withAnEmptyTodoList());

        when(john).attemptsTo(AddATodoItem.called("Buy some milk"));

        then(john).should(seeThat(TheItems.displayed(), hasItem("Buy some milk")));
    }
}
