package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC05 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC05() {
        LOGGER = REPORTS.startTest("TC05", "System shows message when user enters wrong password several times");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Enter valid information into \"Username\" textbox except \"Password\" textbox.");
        LOGGER.log(LogStatus.INFO, "Step #4: ", "Click on \"Login\" button");
        loginPage.login(System.getenv("username"), "123456789");

        LOGGER.log(LogStatus.INFO, "Step #5: ", "Repeat step 3 three more times.");
        for (int i = 0; i < 3; i++)
            loginPage.login(System.getenv("username"), "123456789");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        LOGGER.log(LogStatus.INFO, "Checkpoint", "User can't login and message \"You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.\" appears.");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
