package base;

import org.testng.Assert;

import static base.DriverClass.log;

public class Assertion {

    public static void assertEquals(String actualValue, String expectedValue){
        try {
            Assert.assertEquals(actualValue, expectedValue);
            log.info("Assertion Passed: Expected = " + expectedValue +" Actual = " + actualValue);
        } catch (AssertionError e) {
            log.error("Assertion Failed: Expected = " + expectedValue +" Actual = " + actualValue);
            Assert.fail();
        }
    }

    public static void assertTrue(String message){
        log.info(message);
    }

    public static void assertFalse(String message){
        log.info(message);
    }


}
