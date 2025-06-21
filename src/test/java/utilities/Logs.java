package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    public Logger log;
    public ExtentReports extentReports = new ExtentReports();
    public ExtentTest test;
    String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());

    public Logs(){
        configureLogs();
        configureExtentReports();
    }

    public void configureLogs(){

        System.setProperty("log.filename", "src/test/java/logs/log_" + this.timestamp + ".log");
        this.log = LogManager.getLogger(this.getClass().getName());
    }


    public void configureExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/java/reports/html_report_"+ this.timestamp +".html");
        reporter.config().setReportName("OrangeHRM Automation");
        reporter.config().setDocumentTitle("Test Results");

        this.extentReports.attachReporter(reporter);
        this.extentReports.setSystemInfo("Tester", "Vishal Jadhav");
    }

    public ExtentTest getTest() {
        return this.test;
    }

    public ExtentReports getExtentReports() {
        return this.extentReports;
    }

    public void startTest(String className){
        this.test = this.extentReports.createTest(className);
    }


    public void info(String message){
        this.log.info(message);
        this.test.log(Status.INFO, message);
    }

    public void error(String message){
        this.log.info(message);
        this.test.log(Status.INFO, message);
    }

    public void debug(String message){
        this.log.info(message);
        this.test.log(Status.INFO, message);
    }

}
