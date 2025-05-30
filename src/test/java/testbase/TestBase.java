package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utils.DriverFactory;

import java.time.Duration;

public class TestBase {

    protected WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional ("chrome") String browser){
        driver = DriverFactory.initDriver(browser);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
