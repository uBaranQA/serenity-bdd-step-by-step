package pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class BasePage {

    protected WebDriver driver;
    Duration duration = Duration.ofMillis(100);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage(WebDriver driver, String url) {
        this.driver = driver;
        if (isNotBlank(url)) {
            driver.navigate().to(url);
        }
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 15), this);
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedCondition) {
        return waitUntil(expectedCondition, 10);
    }

    public <T> T waitUntil(ExpectedCondition<T> expectedCondition, int timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds)
                .pollingEvery(duration)
                .until(expectedCondition);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
