package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class DownloadFilePage extends ElementUtils {

    public DownloadFilePage(WebDriver driver) {
        super(driver); // Call parent class constructor
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/section/div[1]/div/div/div[1]/a")
    private WebElement clickDownloadButton;

    public void clickDownloadPdfFile() {
        clickElement(clickDownloadButton);
        waitForVisibility(clickDownloadButton, 20);
    }

}
