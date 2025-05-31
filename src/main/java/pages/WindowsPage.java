package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsPage extends ElementUtils {

    private WebDriver driver;
    private String parentWindowHandle;

    public WindowsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Section Tabs
    @FindBy(xpath = "//a[contains(text(),'Open New Tabbed Windows')]")
    private WebElement openNewTabbedWindows;

    @FindBy(xpath = "//a[contains(text(),'Open New Seperate Windows')]")
    private WebElement openSeparateWindowTab;

    @FindBy(xpath = "//a[contains(text(),'Open Seperate Multiple Windows')]")
    private WebElement openSeparateMultipleWindows;

    // Buttons
    @FindBy(xpath = "//div[@id='Tabbed']//button[contains(text(),'click')]")
    private WebElement clickNewTabButton;

    @FindBy(xpath = "//div[@id='Seperate']//button[contains(text(),'click')]")
    private WebElement clickNewWindowButton;

    @FindBy(xpath = "//div[@id='Multiple']//button[contains(text(),'click')]")
    private WebElement clickMultipleWindowButton;

    // Actions
    public void goToTabbedWindowSection() {
        clickElement(openNewTabbedWindows);
    }

    public void goToSeparateWindowSection() {
        clickElement(openSeparateWindowTab);
    }

    public void goToMultipleWindowsSection() {
        clickElement(openSeparateMultipleWindows);
    }

    public void clickNewTabButton() {
        parentWindowHandle = driver.getWindowHandle();
        clickElement(clickNewTabButton);
    }

    public void clickNewWindowButton() {
        parentWindowHandle = driver.getWindowHandle();
        clickElement(clickNewWindowButton);
    }

    public void clickMultipleWindowButton() {
        parentWindowHandle = driver.getWindowHandle();
        clickElement(clickMultipleWindowButton);
    }

    public List<String> switchToNewWindowsAndGetTitles() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> titles = new ArrayList<>();

        for (String handle : allWindows) {
            if (!handle.equals(parentWindowHandle)) {
                driver.switchTo().window(handle);
                titles.add(driver.getTitle());
                driver.close();
            }
        }

        driver.switchTo().window(parentWindowHandle);
        return titles;
    }
}
