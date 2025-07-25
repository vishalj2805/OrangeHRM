package tests;

import base.Assertion;
import base.DriverClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import utilities.ExcelReader;

import java.io.IOException;

public class VerifyWidgets extends DriverClass {

    @DataProvider(name = "data")
    public Object[][] getData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readExcelFile("Credentials", "VALID CREDENTIALS");

    }



    @Test(dataProvider = "data")
    public void verifyMenuItems(String username, String password) throws InterruptedException, IOException {
        LandingPage landingPage = new LandingPage(driver.get());
        HomePage homePage = new HomePage(driver.get());

        landingPage.login(username, password);
        homePage.loginSuccessStatus();

        if(homePage.isWidgetsDisplayed()){
            Assertion.assertTrue("All the Widgets in Homepage are Displayed correctly");
        }else {
            Assertion.assertFalse("Widgets Displayed in Homepage are Incorrect or Incomplete");
        }



    }

}
