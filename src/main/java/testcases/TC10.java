package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC10 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();
    private final String email = "nguyenhang" + System.currentTimeMillis() / 1000L + "@gmail.com";
    private final String password = "13245789";
    private final String PID = "13456789";

    @Test
    public void TC10() {
        LOGGER = REPORTS.startTest("TC10", "User can't create account with \"Confirm password\" is not the same with \"Password\"");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Register\" tab");
        homePage.gotoRegisterPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Enter valid information into all fields except \"Confirm password\" is not the same with \"Password\"");
        LOGGER.log(LogStatus.INFO, "Step #4: ", "Click on \"Register\" button");
        registerPage.register(email, password, "1231112233", PID);

        String actualMsg = registerPage.getRegisterErrorMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Message \"There're errors in the form. Please correct the errors and try again.\" appears.");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
