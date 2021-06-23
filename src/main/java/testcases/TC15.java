package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC15 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final BookTicketSuccessfullyPage bookTicketSuccessfullyPage = new BookTicketSuccessfullyPage();
    private final TimetablePage timetablePage = new TimetablePage();

    @Test
    public void TC15() {
        LOGGER = REPORTS.createTest("TC15", "User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: Login with a valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(Status.INFO, "Step #4: Click on \"Timetable\" tab");
        homePage.gotoTimetablePage();

        LOGGER.log(Status.INFO, "Step #4: Click on \"book ticket\" link of the route from \"Huế\" to \"Sài Gòn\"");
        timetablePage.bookTicket("Huế", "Sài Gòn");

        LOGGER.log(Status.INFO, "Checkpoint: \"Book ticket\" page is loaded with correct \"Depart from\" and \"Arrive at\" values.");
        Assert.assertEquals("Huế", bookTicketPage.getValueOfDepartStation(), "The information is not correct");
        Assert.assertEquals("Sài Gòn", bookTicketPage.getValueOfArriveStation(), "The information is not correct");
    }
}
