package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.stream.Collectors;

import static base.DriverClass.log;


public class ElementsAction {

    WebDriver driver;
    Properties properties;
    public static WebDriverWait wait;


    public ElementsAction(WebDriver driver, Properties properties) throws IOException {
        this.driver = driver;
        this.properties = properties;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public By identifyElementType(String element) {


        switch (element.split("_")[1]){
            case "xpath": return By.xpath(properties.getProperty(element));

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
        log.debug("Entered Text: "+ text + " in " + element);


    }

    public void click(String element){
        driver.findElement(identifyElementType(element)).click();
        log.debug("Clicked on " + element);
    }

    public String getText(String element){
        String text = driver.findElement(identifyElementType(element)).getText();
        log.debug("Fetched Text from element: " + element);
        return text;
    }


    public String getURL(){
        String url = driver.getCurrentUrl();
        log.info("Url is: "+ url);
        return url;
    }

    public ArrayList<String> getTextDataFromElements(String element){
        ArrayList<String> textData = driver.findElements(identifyElementType(element))
                .stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
        return textData;
    }











}
