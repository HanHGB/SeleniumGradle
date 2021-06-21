package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC09 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09() {
        LOGGER = REPORTS.startTest("TC09", "User can change password");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Login with valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(LogStatus.INFO, "Step #4: ", "Click on \"Change Password\" tab");
        loginPage.gotoChangePasswordPage();

        LOGGER.log(LogStatus.INFO, "Step #4: ", "Enter valid value into all fields.");
        LOGGER.log(LogStatus.INFO, "Step #5: ", "Click on \"Change Password\" button");
        changePasswordPage.changePassword(System.getenv("password"), "12345678", "12345678");

        String actualMsg = changePasswordPage.getChangePasswordMsg();
        String expectedMsg = "Your password has been updated!";

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Message \"Your password has been updated\" appears.");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
