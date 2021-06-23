package testcases;

import com.aventstack.extentreports.Status;
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
        LOGGER = REPORTS.createTest("TC09", "User can change password");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: Login with valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(Status.INFO, "Step #4: Click on \"Change Password\" tab");
        loginPage.gotoChangePasswordPage();

        LOGGER.log(Status.INFO, "Step #4: Enter valid value into all fields.");
        LOGGER.log(Status.INFO, "Step #5: Click on \"Change Password\" button");
        changePasswordPage.changePassword(System.getenv("password"), "12345678", "12345678");

        String actualMsg = changePasswordPage.getChangePasswordMsg();
        String expectedMsg = "Your password has been updated!";

        LOGGER.log(Status.INFO, "Checkpoint: Message \"Your password has been updated\" appears.");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
