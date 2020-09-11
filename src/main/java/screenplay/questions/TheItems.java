package screenplay.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.user_interface.TodoList;

import java.util.List;

public class TheItems {
    public static Question<List<String>> displayed() {
        return Text.of(TodoList.ITEMS)
                .describedAs("the items displayed")
                .asAList();
    }
}
