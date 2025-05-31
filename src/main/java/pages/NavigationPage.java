package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class NavigationPage extends ElementUtils {


    public NavigationPage(WebDriver driver) {
        super(driver); // Call parent class constructor
        PageFactory.initElements(driver, this);
    }

    // Locators using @FindBy
    @FindBy(xpath = "//a[@href='SwitchTo.html' and text()='SwitchTo']")
    private WebElement switchToMenu;

    @FindBy(xpath = "//a[@href='Alerts.html']")
    private WebElement alertsLink;

    @FindBy(xpath = "//a[@href='Windows.html']")
    private WebElement windowsLink;

    @FindBy(xpath = "//a[text()='Frames']")
    private WebElement framesLink;

    @FindBy(xpath = "//a[contains(text(), 'More')]")
    private WebElement moreLinks;

    @FindBy(xpath = "//a[text()='Modals']")
    private WebElement modalsLink;

    @FindBy(xpath = "//a[text()='Upload and Download']")
    private WebElement uploadDownloadLink;


    // Navigation methods
    public void goToAlertsPage() {
        clickElement(switchToMenu);
        clickElement(alertsLink);
    }

    public void goToWindowsPage() {
        clickElement(switchToMenu);
        clickElement(windowsLink);
    }

    public void goToFramesPage() {
        clickElement(switchToMenu);
        clickElement(framesLink);
    }

    public void goToModalsPage() {
        clickElement(switchToMenu);
        clickElement(modalsLink);
    }

}
