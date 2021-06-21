package testcases;

import com.relevantcodes.extentreports.LogStatus;
import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC06 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC06() {
        System.out.println("TC06: Additional pages display once user logged in");
        LOGGER = REPORTS.startTest("TC06", "Additional pages display once user logged in");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Login with valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "\"My ticket\", \"Change password\" and \"Logout\" tabs are displayed.");
        Assert.assertTrue(homePage.doesTabNameExist("My ticket"));
        Assert.assertTrue(homePage.doesTabNameExist("Change password"));
        Assert.assertTrue(homePage.doesTabNameExist("Log out"));

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Click \"My ticket\" tab, user will be directed to My ticket page");
        homePage.gotoMyTicketPage();
        Assert.assertEquals(myTicketPage.getTitle(), "Manage Tickets", "The My ticket Page is not opened");
        Assert.assertTrue(Constant.WEBDRIVER.getTitle().toUpperCase().indexOf("My Ticket".toUpperCase()) != 1);

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Click \"Change password\" tab, user will be directed to Change password page");
        homePage.gotoChangePasswordPage();
        Assert.assertEquals(changePasswordPage.getTitle(), "Change password", "The My ticket Page is not opened");
        Assert.assertTrue(Constant.WEBDRIVER.getTitle().toUpperCase().indexOf("Change password".toUpperCase()) != 1);
    }
}
