package base;

import static base.DriverClass.driver;
import static base.DriverClass.log;

public class UtilitiesMethods {


    public static String getURL(){
        String url = driver.getCurrentUrl();
        log.info("Url is: {}", url);
        return url;
    }

}
