package testcases;

import com.aventstack.extentreports.Status;
import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC04 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();

    @Test
    public void TC04() {
        LOGGER = REPORTS.createTest("TC04", "Login page displays when un-logged User clicks on Book ticket tab");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();

        String tabTitle = Constant.WEBDRIVER.getTitle();

        LOGGER.log(Status.INFO, "Checkpoint: Login page displays instead of Book ticket page");
        Assert.assertTrue(tabTitle.indexOf("Login") != 1, "The Book Ticket Page is open when not logging yet");
    }

}
