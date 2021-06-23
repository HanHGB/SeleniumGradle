package testcases;

import com.aventstack.extentreports.Status;
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
        LOGGER = REPORTS.createTest("TC11", "User can't create account while password and PID fields are empty");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Register\" tab");
        registerPage.gotoRegisterPage();

        LOGGER.log(Status.INFO, "Step #3: Enter valid email address and leave other fields empty");
        LOGGER.log(Status.INFO, "Step #4: Click on \"Register\" button");
        registerPage.register(email, "", "", "");

        String actualRegisterMsg = registerPage.getRegisterErrorMsg();
        String expectedRegisterMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualPasswordMsg = registerPage.getPasswordErrorMsg();
        String expectedPasswordMsg = "Invalid password length";
        String actualPIDMsg = registerPage.getPIDErrorMsg();
        String expectedPIDMsg = "Invalid ID length";

        LOGGER.log(Status.INFO, "Checkpoint #1: Message \"There're errors in the form. Please correct the errors and try again.\" appears above the form.");
        Assert.assertEquals(actualRegisterMsg, expectedRegisterMsg, "Msg is not correctly");

        LOGGER.log(Status.INFO, "Checkpoint #2: Next to password fields, error message \"Invalid password length.\" displays");
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Msg is not correctly");

        LOGGER.log(Status.INFO, "Checkpoint #3: Next to PID field, error message \"Invalid ID length.\" displays");
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "Msg is not correctly");
    }
}
