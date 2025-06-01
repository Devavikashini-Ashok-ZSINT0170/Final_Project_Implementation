package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class DynamicPage extends ElementUtils {

    public DynamicPage(WebDriver driver) {
        super(driver); // Call parent class constructor
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(),'Dynamic')]")
    private WebElement dynamicButton;

    @FindBy(xpath = "//div[@id='loading']//img")
    private WebElement dynamicImage;

    public void getDynamicData() {
        clickElement(dynamicButton);
        waitForVisibility(dynamicImage, 30);
    }

    public boolean isImageDisplayed() {
        return dynamicImage.isDisplayed();
    }


}
