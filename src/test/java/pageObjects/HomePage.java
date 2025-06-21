package pageObjects;

import base.ElementsAction;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import static base.DriverClass.log;

public class HomePage extends ElementsAction {


    public HomePage(WebDriver driver) throws IOException {
        super(driver, loadProperty());

    }

    private static Properties loadProperty() throws IOException {
        FileInputStream fis = new FileInputStream("../OrangeHRM/src/test/java/properties/homepage.properties");
        Properties properties = new Properties();
        properties.load(new InputStreamReader(fis));
        return properties;
    }


    public Boolean isMenuItemsDisplayed(){
        List<String> expectedMenuItems = new ArrayList<>(Arrays.asList("Admin", "PIM", "Leave", "Time", "Recruitment", "My Info", "Performance", "Dashboard", "Directory",
                "Maintenance", "Claim", "Buzz"));

        List<String> actualMenuItems= getTextDataFromElements("menuItems_xpath");

        int actualMenuItemCounter = 0;
        for (String expectedMenuItem: expectedMenuItems){
            if (actualMenuItems.contains(expectedMenuItem)){
                actualMenuItemCounter++;
            }
        }

        log.info("Actual List of Menu Items: " + expectedMenuItems);
        log.info("List of Menu Items Displayed: " + actualMenuItems);

        if (actualMenuItemCounter == expectedMenuItems.size()){
            return true;
        }else {
            return false;
        }





    }






}
