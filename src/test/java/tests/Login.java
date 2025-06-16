package tests;

import base.DriverClass;
import base.ElementsAction;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
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

        LandingPage landingPage = new LandingPage(driver);

        landingPage.login(username, password);
        Thread.sleep(3);
        System.out.println(driver.getCurrentUrl());
    }
}
