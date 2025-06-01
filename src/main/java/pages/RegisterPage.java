package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utils.ElementUtils;


public class RegisterPage extends ElementUtils {

    private final WebDriver driver;

    @FindBy(xpath = "//input[@type='text' and @placeholder='First Name']")
    private WebElement enterFirstname;

    @FindBy(xpath = "//input[@type='text' and @placeholder='Last Name']")
    private WebElement enterLastname;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement enterAddress;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement enterEmail;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement enterPhone;

    @FindBy(xpath = "//input[@type='radio' and @value='Male']")
    private WebElement genderFemaleRadio;

    @FindBy(xpath = "//input[@type='radio' and @value='FeMale']")
    private WebElement genderMaleRadio;

    @FindBy(xpath = "//input[@type='checkbox' and @id='checkbox1']")
    private WebElement checkbox1;

    @FindBy(xpath = "//input[@type='checkbox' and @id='checkbox2']")
    private WebElement checkBox2;

    @FindBy(xpath = "//input[@type='checkbox' and @id='checkbox3']")
    private WebElement checkbox3;

    @FindBy(id = "msdd")
    private WebElement language;

    @FindBy(xpath = "//select[@id='countries' and @ng-model='country' and @required]\n")
    private WebElement selectCountry;

    @FindBy(id = "submitbtn")
    private WebElement submitButton;


    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // to initialize @FindBy
    }

    public void register() {
        typeText(enterFirstname, "John");
        typeText(enterLastname, "Doe");
        typeText(enterAddress, "123 Test Street");
        typeText(enterEmail, "john.doe@example.com");
        typeText(enterPhone, "9876543210");

        clickElement(genderMaleRadio);
        clickElement(checkbox1);

        if (hasCountryOptions()) {
            selectFromDropdownByVisibleText(selectCountry, "India");
        } else {
            System.out.println("Country dropdown has no selectable options. Skipping country selection.");
        }

        clickElement(submitButton);
    }

    public boolean isCountryDropdownVisible() {
        return isElementVisible(selectCountry);
    }

    public boolean hasDropdownOptions() {
        if (!isCountryDropdownVisible()) return false;
        Select select = new Select(selectCountry);
        return select.getOptions().size() > 2;
    }

    public boolean isCountryDropdownValid() {
        return isCountryDropdownVisible() && hasDropdownOptions();
    }

    public boolean hasCountryOptions() {
        wait.until(ExpectedConditions.visibilityOf(selectCountry));
        Select select = new Select(selectCountry);
        int optionsCount = select.getOptions().size();
        System.out.println("Country dropdown options count: " + optionsCount);
        return optionsCount > 1;  // More than 1 means options other than placeholder exist
    }


}
