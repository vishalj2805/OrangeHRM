package utilities;

import base.ElementsAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    public Logger getLogger(){
        String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());
        System.setProperty("log.filename", "src/test/java/logs/log_" + timestamp + ".log");
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        return LogManager.getLogger(className);
    }
}
