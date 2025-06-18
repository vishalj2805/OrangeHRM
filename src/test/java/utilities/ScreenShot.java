package utilities;

import base.DriverClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Objects;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class ScreenShot extends DriverClass {




    public void takeScreenShot(Boolean isSuccess, String testName) throws InterruptedException {
        Thread.sleep(5000);
        String status = isSuccess ? "Passed" : "Failed";
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        File srcFile = srcFile = ((TakesScreenshot)driver.get()).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/src/test/java/screenshots/" + status + "-" + testName+ "_"+ timestamp + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
