package pageObjects;


import java.io.IOException;

import static base.DriverClass.driver;

public class PageObjectBase {

    public LandingPage getLandingPage() throws IOException {
        return new LandingPage(driver);
    }




}
