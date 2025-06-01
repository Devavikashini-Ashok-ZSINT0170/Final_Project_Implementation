package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DownloadFilePage;
import pages.NavigationPage;
import testbase.TestBase;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

public class DownloadFileTest extends TestBase {

    private Path downloadPath;
    NavigationPage navigationPage;
    DownloadFilePage downloadPage;

    @BeforeMethod
    public void setUp() {

        navigationPage = new NavigationPage(driver);
        downloadPage = new DownloadFilePage(driver);
        downloadPath = Paths.get(System.getProperty("user.dir"), "downloads");
    }

    @Test
    public void testFileDownload() throws InterruptedException {
        navigationPage.goToFileDownload();
        downloadPage.clickDownloadPdfFile();


        File[] files = downloadPath.toFile().listFiles();
        assertTrue(files != null && files.length > 0, "Downloaded file not found.");
    }


}
