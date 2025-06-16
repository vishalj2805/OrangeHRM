package base;

import org.openqa.selenium.WebDriver;

import static base.DriverClass.log;

public class UtilitiesMethods {


    public static String getURL(WebDriver driver){
        String url = driver.getCurrentUrl();
        log.info("Url is: {}", url);
        return url;
    }

}
