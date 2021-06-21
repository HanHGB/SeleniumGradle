package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC11 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();
    private final String email = "nguyenhang" + System.currentTimeMillis() / 1000L + "@gmail.com";

    @Test
    public void TC11() {
        LOGGER = REPORTS.startTest("TC11", "User can't create account while password and PID fields are empty");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Register\" tab");
        registerPage.gotoRegisterPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Enter valid email address and leave other fields empty");
        LOGGER.log(LogStatus.INFO, "Step #4: ", "Click on \"Register\" button");
        registerPage.register(email, "", "", "");

        String actualRegisterMsg = registerPage.getRegisterErrorMsg();
        String expectedRegisterMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualPasswordMsg = registerPage.getPasswordErrorMsg();
        String expectedPasswordMsg = "Invalid password length";
        String actualPIDMsg = registerPage.getPIDErrorMsg();
        String expectedPIDMsg = "Invalid ID length";

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
        Assert.assertEquals(actualRegisterMsg, expectedRegisterMsg, "Msg is not correctly");

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Next to password fields, error message \"Invalid password length.\" displays");
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Msg is not correctly");

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Next to PID field, error message \"Invalid ID length.\" displays");
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "Msg is not correctly");
    }
}
