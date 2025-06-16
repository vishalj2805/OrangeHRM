package pageObjects;

import base.ElementsAction;
import org.openqa.selenium.WebDriver;
import org.reactivestreams.FlowAdapters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class LandingPage extends ElementsAction {
    public static FileInputStream fis;


    public LandingPage(WebDriver driver) throws IOException {
        super(driver, loadProperty());

    }

    private static Properties loadProperty() throws IOException {
        fis = new FileInputStream("../OrangeHRM/src/test/java/properties/landingPage.properties");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(fis));
        return properties;
    }


    public void login(String username, String password){
        writeText("username_xpath", username);
        writeText("password_xpath", password);
        click("loginBtn_xpath");
    }





}
