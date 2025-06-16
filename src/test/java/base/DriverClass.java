package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Logs;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;

public class DriverClass {

    public WebDriver driver;
    Logger log = new Logs().getLogger();;

    @BeforeMethod
    public void setUp() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("../OrangeHRM/src/test/java/properties/data.properties");
        properties.load(new InputStreamReader(fileInputStream));
        log.info("Browser Opened");
        driver.get(properties.getProperty("baseUrl"));
        log.info("Navigated to: " + properties.getProperty("baseUrl"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
        log.info("Browser Closed");
    }


}
