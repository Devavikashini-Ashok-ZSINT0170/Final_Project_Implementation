package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.NavigationPage;
import testbase.TestBase;

import java.time.Duration;

public class AlertsTest extends TestBase {

    NavigationPage navigationPage;
    AlertsPage alertsPage;

    @BeforeMethod
    public void setUp() {
        navigationPage = new NavigationPage(driver);
        alertsPage = new AlertsPage(driver);
    }


    @Test
    public void testAlertOkPage() {
        navigationPage.goToAlertsPage();
        alertsPage.clickAlertWithOkTab();
        alertsPage.triggerSimpleAlert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am an alert box!");

        alert.accept(); // Accept AFTER asserting
    }

    @Test
    public void testAlertOkCancelPage() {
        navigationPage.goToAlertsPage();
        alertsPage.clickAlertWithOkCancelTab();
        alertsPage.triggerConfirmAlert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        String alertText = alert.getText();
        Assert.assertEquals(alertText, "Press a Button !");

        alert.dismiss();
    }

    @Test
    public void testPromptAlert() {
        navigationPage.goToAlertsPage();
        alertsPage.clickAlertWithTextboxTab();
        alertsPage.triggerPromptAlert();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Verify alert text
        Assert.assertEquals(alert.getText(), "Please enter your name");

        // Send input to the prompt and accept
        String inputText = "John Doe";
        alert.sendKeys(inputText);
        alert.accept();

        Assert.assertTrue(alertsPage.getResultText().contains("Hello John Doe"));
    }


}
