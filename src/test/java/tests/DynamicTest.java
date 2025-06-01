package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DynamicPage;
import pages.NavigationPage;
import testbase.TestBase;

public class DynamicTest extends TestBase {

    NavigationPage navigationPage;
    DynamicPage dynamicPage;

    @BeforeMethod
    public void setUp() {
        navigationPage = new NavigationPage(driver);
        dynamicPage = new DynamicPage(driver);
    }

    @Test
    public void getDynamicElement() {
        navigationPage.goToDynamicPage();
        dynamicPage.getDynamicData();
        Assert.assertTrue(dynamicPage.isImageDisplayed(), "Dynamic image was not displayed!");
    }


}
