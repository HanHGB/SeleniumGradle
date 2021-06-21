package testcases;

import com.relevantcodes.extentreports.LogStatus;
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
        LOGGER = REPORTS.startTest("TC04", "Login page displays when un-logged User clicks on Book ticket tab");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();

        String tabTitle = Constant.WEBDRIVER.getTitle().toUpperCase();

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Login page displays instead of Book ticket page");
        Assert.assertTrue(tabTitle.indexOf("Login".toUpperCase()) != 1, "The Book Ticket Page is open when not logging yet");
    }

}
