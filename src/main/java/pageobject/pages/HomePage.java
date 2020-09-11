package pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private static final String COMPLETE_TICKBOX = ".//input[@class='toggle']";
    private static final String ITEM_ROW = "//div[@class='view' and contains(.,'%s')]";

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

    public void completeTodo(String toDoName) {
        itemRow(toDoName).findElement(By.xpath(COMPLETE_TICKBOX)).click();
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

    private WebElement itemRow(String todoName) {
        return driver.findElement(By.xpath(String.format(ITEM_ROW, todoName)));
    }

}
