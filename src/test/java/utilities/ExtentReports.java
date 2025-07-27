package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReports {

    public com.aventstack.extentreports.ExtentReports extentReports = new com.aventstack.extentreports.ExtentReports();
    public ExtentTest test;
    String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());

    public ExtentReports(){
        configureExtentReports();
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

    public com.aventstack.extentreports.ExtentReports getExtentReports() {
        return this.extentReports;
    }

    public void startTest(String className){
        this.test = this.extentReports.createTest(className);
    }


}
