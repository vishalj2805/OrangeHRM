package tests;

import base.Assertion;
import base.DriverClass;
import base.ElementsAction;
import base.UtilitiesMethods;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PageObjectBase;
import utilities.ExcelReader;

import java.io.IOException;


public class Login extends DriverClass {


    @DataProvider(name = "data")
    public Object[][] getData() throws IOException {
        ExcelReader excelReader = new ExcelReader();
        return excelReader.readExcelFile("Credentials");

    }



    @Test(dataProvider = "data")
    public void login(String username, String password) throws InterruptedException, IOException {
        LandingPage landingPage = new PageObjectBase().getLandingPage();

        landingPage.login(username, password);
        Assertion.assertEquals(UtilitiesMethods.getURL(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }
}
