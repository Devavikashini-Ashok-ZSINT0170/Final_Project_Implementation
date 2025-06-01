package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;

@Epic("Register Feature")
public class RegisterTest extends TestBase {

    private RegisterPage registerPage;

    @BeforeMethod
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "validating the Register page load")
    public void setUpPage() {
        driver.get("https://demo.automationtesting.in/Register.html");
        registerPage = new RegisterPage(driver);
    }


    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Register with valid details")
    public void registerUserTest() {
        if (!registerPage.isCountryDropdownValid()) {
            System.out.println("Country dropdown is invalid or has no options, skipping country selection.");
        }
        registerPage.register();

    }

}
