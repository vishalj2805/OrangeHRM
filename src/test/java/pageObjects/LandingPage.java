package pageObjects;

import base.ElementsAction;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class LandingPage extends ElementsAction {


    public LandingPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public void login(String username, String password){
        writeText("username_xpath", username);
        writeText("password_xpath", password);
        click("loginBtn_xpath");
    }





}
