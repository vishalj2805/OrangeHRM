package utilities;

import base.ElementsAction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Logs {

    public Logger getLogger(){
        String timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new java.util.Date());
        System.setProperty("log.filename", "logs/log_" + timestamp + ".log");
        return LogManager.getLogger(Logs.class);
    }
}
