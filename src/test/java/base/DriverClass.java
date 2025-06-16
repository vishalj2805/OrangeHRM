package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.Properties;

public class DriverClass {

    public WebDriver driver;

    @BeforeMethod
    public void setUp() throws IOException {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("../OrangeHRM/src/test/java/properties/data.properties");
        properties.load(new InputStreamReader(fileInputStream));

        driver.get(properties.getProperty("baseUrl"));

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
