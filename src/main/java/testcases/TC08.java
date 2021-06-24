package testcases;

import com.aventstack.extentreports.Status;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC08 extends BaseTest {

    @Test
    public void TC08() {
        LOGGER = REPORTS.createTest("TC08", "User can't login with an account hasn't been activated");

        LOGGER.log(Status.INFO, "Pre-condition: Create a new account but do not activate it");

        throw new SkipException("This test case is skipped because has a function that is not inactive!");
    }
}
