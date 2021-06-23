package testcases;

import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC16 extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final BookTicketSuccessfullyPage bookTicketSuccessfullyPage = new BookTicketSuccessfullyPage();
    private int currentRows = 0;
    private int rowAfterDeleted;

    @Test
    public void TC16() {
        System.out.println("TC16: User can cancel a ticket");
        LOGGER = REPORTS.createTest("TC16", "User can cancel a ticket");

        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(Status.INFO, "Step #2: Login with a valid account");
        homePage.gotoLoginPage();
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(Status.INFO, "Step #3: Book a ticket");
        loginPage.gotoBookTicketPage();
        bookTicketPage.bookTicket("6/27/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", 1);

        LOGGER.log(Status.INFO, "Step #4: Click on \"My ticket\" tab");
        bookTicketSuccessfullyPage.gotoMyTicketPage();

        //Get current rows
        currentRows = myTicketPage.getRowTable();

        LOGGER.log(Status.INFO, "Step #5: Click on \"Cancel\" button of ticket which user want to cancel.");
        LOGGER.log(Status.INFO, "Step #6: Click on \"OK\" button on Confirmation message \"Are you sure?\"");
        myTicketPage.cancelTicket("Sài Gòn", "Nha Trang", "", "", "", "", "");

        try {

            //In Firefox, when canceling a ticket, getting the remaining ticket count is not correct because it happened
            // before the cancellation was performed. So using Sleep makes the get ticket count action properly flow.
            Thread.sleep(500);

            //Get current rows that one row has deleted (change rows)
            rowAfterDeleted = myTicketPage.getRowTable();

            LOGGER.log(Status.INFO, "Checkpoint: The canceled ticket is disappeared.");
            if (myTicketPage.findTicket("Sài Gòn", "Nha Trang", "", "", "", "", ""))
                Assert.assertEquals(rowAfterDeleted, currentRows - 1, "Not deleted");
            else
                Assert.assertFalse(false);
        } catch (InterruptedException ie) {
            LOGGER.log(Status.INFO, "Error: " + ie);
        }

    }
}
