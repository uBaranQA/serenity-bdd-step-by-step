package pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(css = "h1")
    private WebElement heading;

    @FindBy(css = ".info")
    private WebElement footer;

    @FindBy(className = "new-todo")
    private WebElement newToDoInput;

    @FindBy(css = " ul li label")
    private List<WebElement>  toDosList;

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver, baseUrl);
    }

    public void addNewTodo(String toDoName) {
        newToDoInput.sendKeys(toDoName);
        newToDoInput.sendKeys(Keys.RETURN);
    }

    public List <WebElement> getAllToDos() {
        return toDosList;
    }

    public String getHeading() {
        return heading.getText();
    }

    public String getFooter() {
        return footer.getText();
    }

    public String getPlaceholder() {
        return newToDoInput.getAttribute("placeholder");
    }
}
