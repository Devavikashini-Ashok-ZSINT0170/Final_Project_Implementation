package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class UploadFilePage extends ElementUtils {

    public UploadFilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "file-upload")
    private WebElement chooseFileInput;

    @FindBy(id = "file-submit")
    private WebElement clickSubmitBn;

    @FindBy(id = "uploaded-files")
    private WebElement viewMessage;

    public void uploadFile(String absoluteFilePath) {
        typeText(chooseFileInput, absoluteFilePath); // sendKeys
        clickElement(clickSubmitBn);
    }

    public boolean isUploadSuccessVisible() {
        return isElementVisible(viewMessage);
    }

    public String getUploadedFileName() {
        return getText(viewMessage);
    }


}
