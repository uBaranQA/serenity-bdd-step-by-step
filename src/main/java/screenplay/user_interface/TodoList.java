package screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class TodoList {
    public static final Target WHAT_NEEDS_TO_BE_DONE = Target.the("'What needs to be done?' field")
            .locatedBy(".new-todo");
    public static final Target ITEMS = Target.the("List of todo items")
            .locatedBy(".view label");
}
