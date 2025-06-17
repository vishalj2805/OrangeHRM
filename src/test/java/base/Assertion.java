package base;

import org.testng.Assert;

import static base.DriverClass.log;

public class Assertion {


    public static void assertEquals(String actualValue, String expectedValue){
        try {
            Assert.assertEquals(actualValue, expectedValue);
            log.info("Assertion Passed: Expected = {}, Actual = {}", expectedValue, actualValue);
        } catch (AssertionError e) {
            log.error("Assertion Failed: Expected = {}, Actual = {}", expectedValue, actualValue);
            Assert.fail();
        }


    }


}
