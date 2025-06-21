package tests;

import base.Assertion;
import base.DriverClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import utilities.ExcelReader;

import java.io.IOException;

public class VerifyMenuItems extends DriverClass {

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
        if(homePage.isMenuItemsDisplayed()){
            Assertion.assertTrue("All the Items in Menu are Displayed correctly");
        }else {
            Assertion.assertFalse("Items Displayed in Menu are Incorrect or Incomplete");
        }



    }

}
