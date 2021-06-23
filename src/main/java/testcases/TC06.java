package testcases;

import com.aventstack.extentreports.Status;
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
        LOGGER = REPORTS.createTest("TC06", "Additional pages display once user logged in");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: Login with valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(Status.INFO, "Checkpoint #1: \"My ticket\", \"Change password\" and \"Logout\" tabs are displayed.");
        Assert.assertTrue(homePage.doesTabNameExist("My ticket"));
        Assert.assertTrue(homePage.doesTabNameExist("Change password"));
        Assert.assertTrue(homePage.doesTabNameExist("Log out"));

        homePage.gotoMyTicketPage();
        LOGGER.log(Status.INFO, "Checkpoint #2: Click \"My ticket\" tab, user will be directed to My ticket page");
        Assert.assertEquals(myTicketPage.getTitle(), "Manage Tickets", "The My ticket Page is not opened");
        Assert.assertTrue(Constant.WEBDRIVER.getTitle().toUpperCase().indexOf("My Ticket".toUpperCase()) != 1);

        LOGGER.log(Status.INFO, "Checkpoint #3: Click \"Change password\" tab, user will be directed to Change password page");
        homePage.gotoChangePasswordPage();
        Assert.assertEquals(changePasswordPage.getTitle(), "Change password", "The My ticket Page is not opened");
        Assert.assertTrue(Constant.WEBDRIVER.getTitle().toUpperCase().indexOf("Change password".toUpperCase()) != 1);
    }
}
