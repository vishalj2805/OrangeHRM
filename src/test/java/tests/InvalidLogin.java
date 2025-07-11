package tests;

import base.Assertion;
import base.DriverClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import utilities.ExcelReader;

import java.io.IOException;


public class InvalidLogin extends DriverClass {


    @DataProvider(name = "data")
    public Object[][] getData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readExcelFile("Credentials", "INVALID CREDENTIALS");

    }


    @Test(dataProvider = "data")
    public void invalidLogin(String username, String password) throws IOException {
        LandingPage landingPage = new LandingPage(driver.get());

        landingPage.login(username, password);

        Assertion.assertEquals(landingPage.getLoginErrorMessage(), "Invalid credentials");
    }
}
