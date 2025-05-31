package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationPage;
import testbase.TestBase;

public class NavigationTest extends TestBase {

    NavigationPage navigationPage;

    @BeforeMethod
    public void setUp() {
        // Initialize the NavigationPage AFTER the driver is initialized by TestBase
        navigationPage = new NavigationPage(driver);
    }

    @Test
    public void testNavigationToAlertsPage() {
        navigationPage.goToAlertsPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("Alerts.html"));
    }

    @Test
    public void testNavigationToWindowsPage() {
        navigationPage.goToWindowsPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("Windows.html"));
    }

    @Test
    public void testNavigationToFramesPage() {
        navigationPage.goToFramesPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("Frames.html"));
    }

}
