package tests;

import testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterTest extends TestBase {

    private RegisterPage registerPage;

    @BeforeMethod
    public void setUpPage() {
        driver.get("https://demo.automationtesting.in/Register.html");
        registerPage = new RegisterPage(driver);
    }


    @Test
    public void registerUserTest() {
        if (!registerPage.isCountryDropdownValid()) {
            System.out.println("Country dropdown is invalid or has no options, skipping country selection.");
        }
        registerPage.register();

        // Add post-registration validation here if needed
    }

}
