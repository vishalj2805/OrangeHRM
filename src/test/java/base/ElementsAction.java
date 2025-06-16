package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.Logs;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ElementsAction {

    WebDriver driver;
    Properties properties;
    Logger log;


    public ElementsAction(WebDriver driver, Properties properties) throws IOException {
        this.driver = driver;
        this.properties = properties;
        log = new Logs().getLogger();
    }

    public By identifyElementType(String element) {


        switch (element.split("_")[1]){
            case "xpath":
                return By.xpath(properties.getProperty(element));

            case "css":return By.cssSelector(properties.getProperty(element));

            case "id":return By.id(properties.getProperty(element));

            case "class":return By.className(properties.getProperty(element));

            case "tag":return By.tagName(properties.getProperty(element));

            case "link":return By.linkText(properties.getProperty(element));

            case "partialLink":return By.partialLinkText(properties.getProperty(element));


            default:
                try {
                    throw new IOException("Element not defined as per format in Properties file");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

        }

    }


    public void writeText(String element, String text){
        driver.findElement(identifyElementType(element)).sendKeys(text);
        log.info("Entered Text: "+ text + "in " + element);


    }

    public void click(String element){
        driver.findElement(identifyElementType(element)).click();
        log.info("Clicked on " + element);
    }




}
