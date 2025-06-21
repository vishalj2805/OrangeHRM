package utilities;

import base.DriverClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot extends DriverClass {

    public void takeScreenShot(Boolean isSuccess, String testName) throws InterruptedException {



        String status = isSuccess ? "Passed" : "Failed";
        String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        File srcFile = ((TakesScreenshot)driver.get()).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/src/test/java/screenshots/" + status + "-" + testName+ "_"+ timestamp + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
