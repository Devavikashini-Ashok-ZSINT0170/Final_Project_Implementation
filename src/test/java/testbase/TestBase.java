package testbase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

public class TestBase {

    protected WebDriver driver;
    protected String env;
    protected String suite;
    protected String browser;

    @Parameters({"env", "browser", "suite"})
    @BeforeMethod
    public void setUp(
            @Optional("qa") String env,
            @Optional("chrome") String browser,
            @Optional("smoke") String suite) {

        this.env = env;
        this.browser = browser;
        this.suite = suite;

        driver = DriverFactory.initDriver(browser);

        // You can also use 'env' here to choose different base URLs
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
