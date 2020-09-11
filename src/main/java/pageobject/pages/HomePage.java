package pageobject.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class HomePage extends PageObject {

    private static final String COMPLETE_TICKBOX = ".//input[@class='toggle']";
    private static final String CLEAR_COMPLETED = ".clear-completed";
    private static final String ITEM_ROW = "//div[@class='view' and contains(.,'%s')]";

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(css = ".info")
    private WebElement footer;

    @FindBy(className = "new-todo")
    private WebElement newToDoInput;

    @FindBy(css = " ul li label")
    private List<WebElement>  toDosList;

    public void openApplication() {
        open();
        waitForTheApplicationToLoad();
    }

    private void waitForTheApplicationToLoad() {
        withTimeoutOf(60, TimeUnit.SECONDS).waitFor(newToDoInput);
    }

    public void addNewTodo(String toDoName) {
        newToDoInput.sendKeys(toDoName);
        newToDoInput.sendKeys(Keys.RETURN);
    }

    public void completeTodo(String toDoName) {
        itemRow(toDoName).findElement(By.xpath(COMPLETE_TICKBOX)).click();
    }

    public List <WebElement> getAllToDos() {
        return toDosList;
    }

    public List<String> displayedItems() {
        return findAll(".view").stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public String getHeading() {
        return heading.getText();
    }

    public String getFooter() {
        return footer.getText();
    }

    public String getPageTitle() {
        return this.getTitle();
    }

    public String getPlaceholder() {
        return newToDoInput.getAttribute("placeholder");
    }

    private WebElement itemRow(String todoName) {
        return $(By.xpath(String.format(ITEM_ROW, todoName)));
    }

    public void clearCompletedItems() {
        $(CLEAR_COMPLETED).click();
    }
}
