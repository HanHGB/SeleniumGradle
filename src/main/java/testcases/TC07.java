package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC07 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();
    private final String email = "nguyenhang" + System.currentTimeMillis() / 1000L + "@gmail.com";
    private final String password = "13245789";
    private final String PID = "13456789";

    @Test
    public void TC07() {
        LOGGER = REPORTS.startTest("TC07", "User can create new account");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Enter valid information into all fields");
        registerPage.register(email, password, password, PID);

        String actualMsg = registerPage.getRegisterMsg();
        String expectedMsg = "Thank you for registering your account";

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "New account is created and message \"Thank you for registering your account\" appears.");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

}
