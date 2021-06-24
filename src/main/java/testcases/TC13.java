package testcases;

import com.aventstack.extentreports.Status;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC13 extends BaseTest {

    @Test
    public void TC13() {
        LOGGER = REPORTS.createTest("TC13", "Errors display if password and confirm password don't match when resetting password");

        LOGGER.log(Status.INFO, "Pre-condition:  Create and activate a new account");

        throw new SkipException("This test case is skipped because has a function that is not inactive!");
    }
}
