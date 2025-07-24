package base;

import io.github.bonigarcia.wdm.WebDriverManager;
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

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Logs log = new Logs();
    Properties properties = new Properties();


    @BeforeMethod
    public void setUp() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("../OrangeHRM/src/test/java/properties/data.properties");
        properties.load(new InputStreamReader(fileInputStream));

        log.startTest(this.getClass().getName());
        log.info("********* " + this.getClass().getName() + " Started *********");
        browserSelection(properties.getProperty("browser"));
        log.info("Browser Opened");
        driver.get().manage().window().maximize();
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get().get(properties.getProperty("baseUrl"));
        log.info("Navigated to: " + properties.getProperty("baseUrl"));

    }

    @AfterMethod
    public void tearDown(){
        driver.get().quit();
        log.info("Browser Closed");
        log.getExtentReports().flush();
    }


    public void browserSelection(String browserName){

        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;

            default:
                log.info("No/Wrong Browser Defined in Properties File");

        }



    }

}
