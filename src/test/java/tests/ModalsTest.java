package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ModalsPage;
import pages.NavigationPage;
import testbase.TestBase;

public class ModalsTest extends TestBase {

    NavigationPage navigationPage;
    ModalsPage modalPage;

    @BeforeMethod
    public void setUp() {
        navigationPage = new NavigationPage(driver);
        modalPage = new ModalsPage(driver);
    }

    @Test
    public void testSingleModal() {
        navigationPage.goToModalsPage();
        modalPage.openSingleModal();
        Assert.assertTrue(modalPage.isSingleModalDisplayed(), "Single Modal was not displayed!");
        modalPage.closeSingleModal();
    }

    @Test
    public void testMultipleModals() {
        navigationPage.goToModalsPage();
        modalPage.openMultipleModal();
        modalPage.openInnerModal();
        Assert.assertTrue(modalPage.isInnerModalDisplayed(), "Inner Modal was not displayed!");
        modalPage.closeInnerModal();
        modalPage.closeOuterModal();
    }
}
