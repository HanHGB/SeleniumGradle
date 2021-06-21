package testcases;

import com.relevantcodes.extentreports.LogStatus;
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
        LOGGER = REPORTS.startTest("TC01", "User can log into Railway with valid username and password");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Enter valid Email and Password");
        LOGGER.log(LogStatus.INFO, "Step #4: ", "Click on \"Login\" button");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + System.getenv("username");

        LOGGER.log(LogStatus.INFO, "Checkpoint", "User is logged into Railway. Welcome user message is displayed.");
        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");
    }
}
