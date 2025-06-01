package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class ModalsPage extends ElementUtils {

    public ModalsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Elements for Single Modal
    @FindBy(xpath = "//a[@href='#myModal']")
    private WebElement launchSingleModalBtn;

    @FindBy(xpath = "//div[@id='myModal']//div[@class='modal-content']")
    private WebElement singleModalContent;

    @FindBy(xpath = "//div[@id='myModal']//button[text()='Close']")
    private WebElement closeSingleModalBtn;

    // Elements for Multiple Modal
    @FindBy(xpath = "//a[@href='#myModalMulti']")
    private WebElement launchMultipleModalBtn;

    @FindBy(xpath = "//a[@class='btn btn-primary' and @data-toggle='modal' and @href='#myModal2']\n")
    private WebElement launchInnerModalBtn;

    @FindBy(xpath = "//div[@id='myModal2']//div[@class='modal-content']")
    private WebElement innerModalContent;

    @FindBy(xpath = "//div[@id='myModal2']/div[@class='modal-dialog']/div[@class='modal-content']/div[@class='modal-footer']/a[text()='Close']")
    private WebElement closeInnerModalBtn;

    @FindBy(xpath = "//*[@id=\"myModalMulti\"]/div/div/div[4]/a[1]")
    private WebElement closeOuterModalBtn;

    public void openSingleModal() {
        clickElement(launchSingleModalBtn);
        waitForVisibility(singleModalContent, 10);
    }

    public boolean isSingleModalDisplayed() {
        return singleModalContent.isDisplayed();
    }

    public void closeSingleModal() {
        clickElement(closeSingleModalBtn);
    }

    public void openMultipleModal() {
        clickElement(launchMultipleModalBtn);
        waitForVisibility(launchInnerModalBtn, 10);
    }

    public void openInnerModal() {
        clickElement(launchInnerModalBtn);
        waitForVisibility(innerModalContent, 10);
    }

    public boolean isInnerModalDisplayed() {
        return innerModalContent.isDisplayed();
    }

    public void closeInnerModal() {
        clickElement(closeInnerModalBtn);
    }

    public void closeOuterModal() {
        clickElement(closeOuterModalBtn);
    }
}
