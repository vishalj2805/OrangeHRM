package pageObjects;

import base.ElementsAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Factory;

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

    public Boolean loginSuccessStatus(){
        if(isElementVisible("dashboardHeading_tag")){
            log.info("Logged In Successfully");
            return true;
        }else {
            log.error("Didn't Log In");
            return false;
        }
    }

    public Boolean isWidgetsDisplayed() throws InterruptedException {
        List<String> expectedWidgets = new ArrayList<>(Arrays.asList("Time at Work", "My Actions", "Quick Launch",
                "Buzz Latest Posts", "Employees on Leave Today", "Employee Distribution by Sub Unit", "Employee Distribution by Location"));

        List<String> actualWidgets= getTextDataFromElements("widgets_xpath");
        List<WebElement> widgetsElements = getElements("widgets_xpath");

        log.info("Actual List of Menu Items: " + expectedWidgets);
        log.info("List of Menu Items Displayed: " + actualWidgets);

        int actualWidgetsCounter = 0;
        for (int i=0;i<actualWidgets.size();i++) {

            isElementVisible(widgetsElements.get(i), actualWidgets.get(i));
            javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", actualWidgets.get(i));
            screenShot.takeScreenShot("Widgets Screenshot");

            if (expectedWidgets.contains(actualWidgets.get(i))){
                actualWidgetsCounter++;
            }

        }



        if (actualWidgetsCounter == expectedWidgets.size()){
            return true;
        }else {
            return false;
        }
    }








}
