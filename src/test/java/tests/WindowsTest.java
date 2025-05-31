package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationPage;
import pages.WindowsPage;
import testbase.TestBase;

import java.util.List;

public class WindowsTest extends TestBase {

    NavigationPage navigationPage;
    WindowsPage windowsPage;

    @BeforeMethod
    public void setUp() {
        navigationPage = new NavigationPage(driver);
        windowsPage = new WindowsPage(driver);
    }

    @Test
    public void testNewTabbedWindowOpens() {


        navigationPage.goToWindowsPage();
        windowsPage.goToTabbedWindowSection();
        windowsPage.clickNewTabButton();

        List<String> titles = windowsPage.switchToNewWindowsAndGetTitles();
        Assert.assertTrue(titles.size() > 0, "No new tab window opened");
    }

    @Test
    public void testSeparateWindowOpens() {


        navigationPage.goToWindowsPage();
        windowsPage.goToSeparateWindowSection();
        windowsPage.clickNewWindowButton();

        List<String> titles = windowsPage.switchToNewWindowsAndGetTitles();
        Assert.assertTrue(titles.size() > 0, "No separate window opened");
    }

    @Test
    public void testMultipleWindowsOpen() {


        navigationPage.goToWindowsPage();
        windowsPage.goToMultipleWindowsSection();
        windowsPage.clickMultipleWindowButton();

        List<String> titles = windowsPage.switchToNewWindowsAndGetTitles();
        Assert.assertTrue(titles.size() > 1, "Multiple windows were not opened");
    }
}
