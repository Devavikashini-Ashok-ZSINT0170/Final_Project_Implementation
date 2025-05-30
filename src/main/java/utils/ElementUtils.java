package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ElementUtils {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void typeText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void selectFromDropdownByVisibleText(WebElement element, String visibleText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }
}
