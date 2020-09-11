package pageobject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageobject.config.DriverType;
import pageobject.config.TestConfig;
import pageobject.config.WebDriverFactory;
import pageobject.pages.HomePage;

import java.util.List;
import java.util.Optional;

/**
 * Base test page
 */
public abstract class BaseTest {

    private static WebDriver driver;
    private TestConfig testConfig;

    protected HomePage homePage;

    /**
     * In real life scenario this method would contain test data creation through API or database
     */
    @BeforeClass
    public static void classSetup() {
        driver = WebDriverFactory.getDriver(
                DriverType.valueOf(System.getProperty("driver", "chrome").toUpperCase())
        );
    }

    @Before
    public void setUp() throws Exception {
        homePage = new HomePage(getDriver(), getConfig().getBaseUrl());
    }

    @AfterClass
    public static void classTearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    protected TestConfig getConfig() {
        if (testConfig == null) {
            testConfig = new TestConfig();
        }
        return testConfig;
    }

    public Optional<WebElement> checkIfTodoIsVisibleOnTheList(List<WebElement> todosList, String todoName) {
        return todosList.stream()
                .filter(element -> element.getText().equals(todoName))
                .findFirst();
    }
}
