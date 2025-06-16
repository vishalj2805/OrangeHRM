package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.DefaultConfiguration;
import org.apache.logging.log4j.core.layout.HtmlLayout;

import java.nio.charset.StandardCharsets;


public class Logs {

    private static final Logger log = null;

    public Logs(){

    }


    public Logger getLog() {
        return log;
    }
}
