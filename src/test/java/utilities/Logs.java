package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    public Logger log;
    public ExtentTest test;
    String className = Thread.currentThread().getStackTrace()[2].getClassName();

    public Logs(){
        configureLogs();
        configureExtentReports();
    }

    public void configureLogs(){
        String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());
        System.setProperty("log.filename", "src/test/java/logs/log_" + timestamp + ".log");
        this.log = LogManager.getLogger(className);
    }


    public void configureExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/java/reports/index.html");
        reporter.config().setReportName("OrangeHRM Automation");
        reporter.config().setDocumentTitle("Test Results");
        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Tester", "Vishal Jadhav");
        this.test = extentReports.createTest(className);
    }

    public ExtentTest getTest() {
        return test;
    }

    public void info(String message){
        log.info(message);
        test.log(Status.INFO, message);
    }

    public void error(String message){
        log.info(message);
        test.log(Status.INFO, message);
    }

    public void debug(String message){
        log.info(message);
        test.log(Status.INFO, message);
    }

}
