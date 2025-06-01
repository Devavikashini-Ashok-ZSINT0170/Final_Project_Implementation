package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NavigationPage;
import pages.UploadFilePage;
import testbase.TestBase;

import java.io.File;


public class UploadFileTest extends TestBase {

    NavigationPage navigationPage;
    UploadFilePage uploadFilePage;

    @BeforeMethod
    public void setUp() {

        navigationPage = new NavigationPage(driver);
        uploadFilePage = new UploadFilePage(driver);
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    @Test
    public void testFileUpload() {

        String filePath = new File("testfiles/sample.pdf").getAbsolutePath();
        System.out.println("File path: " + filePath);

        uploadFilePage.uploadFile(filePath);

        // Verify file upload success
        Assert.assertTrue(uploadFilePage.isUploadSuccessVisible(), "Uploaded file message not visible");
        Assert.assertEquals(uploadFilePage.getUploadedFileName(), "sample.pdf");
    }
}


