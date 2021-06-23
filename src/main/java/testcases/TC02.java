package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC02 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC02() {
        LOGGER = REPORTS.createTest("TC02", "User can't login with blank Username textbox");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: User doesn't type any words into \"Username\" textbox but enter valid information into \"Password\" textbox ");
        LOGGER.log(Status.INFO, "Step #4: Click on \"Login\" button");
        loginPage.login("", System.getenv("password"));

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        LOGGER.log(Status.INFO, "Checkpoint: User can't login and message \"There was a problem with your login and/or errors exist in your form. \" appears.");
        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
