package base;

import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ScreenShot;


public class Listeners extends DriverClass implements ITestListener {

    ScreenShot screenShot = new ScreenShot();


    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        log.getTest().log(Status.PASS, result.getTestClass().getName() + " Passed");
        try {
            screenShot.takeScreenShot(result.isSuccess(), result.getTestClass().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        log.getTest().log(Status.FAIL, result.getTestClass().getName() + " Fail");
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
