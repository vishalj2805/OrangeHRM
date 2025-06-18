package base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShot;

import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Timer;

import static base.DriverClass.log;

public class Listeners extends DriverClass implements ITestListener {

    ScreenShot screenShot = new ScreenShot();


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);

        try {
            screenShot.takeScreenShot(result.isSuccess(), result.getTestClass().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        try {
            screenShot.takeScreenShot(result.isSuccess(), result.getTestClass().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }


}
