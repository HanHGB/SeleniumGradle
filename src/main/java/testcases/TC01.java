package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC01 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC01() {
        LOGGER = REPORTS.createTest("TC01", "User can log into Railway with valid username and password");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: Enter valid Email and Password");
        LOGGER.log(Status.INFO, "Step #4: Click on \"Login\" button");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + System.getenv("username");

        LOGGER.log(Status.INFO, "Checkpoint: User is logged into Railway. Welcome user message is displayed.");
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly!");
    }
}
