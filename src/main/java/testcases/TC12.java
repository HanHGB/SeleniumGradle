package testcases;

import com.aventstack.extentreports.Status;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC12 extends BaseTest {
    @Test
    public void TC12() {
        LOGGER = REPORTS.createTest("TC12", "Errors display when password reset token is blank");

        LOGGER.log(Status.INFO, "Pre-condition:  Create and activate a new account");

        throw new SkipException("This test case is skipped because has a function that is not inactive!");
    }
}
