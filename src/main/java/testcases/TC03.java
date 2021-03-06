package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC03 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC03() {
        LOGGER = REPORTS.createTest("TC03", "User cannot log into Railway with invalid password");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: Enter valid Email and invalid Password");
        LOGGER.log(Status.INFO, "Step #4: Click on \"Login\" button");
        loginPage.login(System.getenv("username"), "");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        LOGGER.log(Status.INFO, "Checkpoint: Error message \"There was a problem with your login and/or errors exist in your form.\" is displayed");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
