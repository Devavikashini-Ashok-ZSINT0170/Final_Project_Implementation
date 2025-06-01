package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class AlertsPage extends ElementUtils {

    public AlertsPage(WebDriver driver) {
        super(driver); // Call parent class constructor
        PageFactory.initElements(driver, this);
    }

    // Locators using FindBy
    @FindBy(xpath = "//a[@href='#OKTab']")
    private WebElement alertWithOkTab;

    @FindBy(xpath = "//a[@href='#CancelTab']")
    private WebElement alertWithOkCancelTab;

    @FindBy(xpath = "//a[@href='#Textbox']")
    private WebElement alertWithTextboxTab;

    @FindBy(xpath = "//button[@class='btn btn-danger']")
    private WebElement alertButton;

    @FindBy(xpath = "//button[contains(text(),'display a confirm box')]")
    private WebElement confirmButton;

    @FindBy(xpath = "//button[contains(text(),'prompt box')]")
    private WebElement promptButton;

    @FindBy(id = "demo1")
    private WebElement promptResultText;


    public void clickAlertWithOkTab() {
        clickElement(alertWithOkTab);
    }

    public void clickAlertWithOkCancelTab() {
        clickElement(alertWithOkCancelTab);
    }

    public void clickAlertWithTextboxTab() {
        clickElement(alertWithTextboxTab);
    }

    public void triggerSimpleAlert() {
        clickElement(alertButton);
        waitForAlert(5); // Wait for the alert to appear
    }

    public void triggerConfirmAlert() {
        clickElement(confirmButton);
        waitForAlert(5);
    }

    public void triggerPromptAlert() {
        clickElement(promptButton);
        waitForAlert(5);
    }


    public String getResultText() {
        return getText(promptResultText);
    }
}
