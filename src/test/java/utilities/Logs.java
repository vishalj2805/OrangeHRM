package utilities;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs{

    public Logger log;
    public ExtentTest test;
    String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());

    public Logs(ExtentTest test){
        configureLogs();
        this.test = test;
    }

    public void configureLogs(){
        System.setProperty("log.filename", "src/test/java/logs/log_" + this.timestamp + ".log");
        this.log = LogManager.getLogger(this.getClass().getName());
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
