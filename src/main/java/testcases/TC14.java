package testcases;

import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.BookTicketSuccessfullyPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import static common.Constant.LOGGER;
import static common.Constant.REPORTS;

public class TC14 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final BookTicketSuccessfullyPage bookTicketSuccessfullyPage = new BookTicketSuccessfullyPage();

    @Test
    public void TC14() {
        LOGGER = REPORTS.startTest("TC14", "User can book 1 ticket at a time");

        LOGGER.log(LogStatus.INFO, "Step #1: ", "Navigate to QA Railway Website");
        homePage.open();

        LOGGER.log(LogStatus.INFO, "Step #2: ", "Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(LogStatus.INFO, "Step #3: ", "Login with a valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(LogStatus.INFO, "Step #4: ", "Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();

        LOGGER.log(LogStatus.INFO, "Step #5: ", "Select a \"Depart date\" from the list");
        LOGGER.log(LogStatus.INFO, "Step #6: ", "Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        LOGGER.log(LogStatus.INFO, "Step #7: ", "Select \"Soft bed with air conditioner\" for \"Seat type\"");
        LOGGER.log(LogStatus.INFO, "Step #8: ", "Select \"1\" for \"Ticket amount\"");
        LOGGER.log(LogStatus.INFO, "Step #9: ", "Click on \"Book ticket\" button");
        bookTicketPage.bookTicket("6/25/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", 1);

        String actualMsg = bookTicketSuccessfullyPage.getTitle();
        String expectedMsg = "Ticket Booked Successfully!";

        LOGGER.log(LogStatus.INFO, "Checkpoint: ", "Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not correct");
        Assert.assertEquals("6/25/2021", bookTicketSuccessfullyPage.getValueOfTxt("Depart Date"), "The information is not correct");
        Assert.assertEquals("Sài Gòn", bookTicketSuccessfullyPage.getValueOfTxt("Depart Station"), "The information is not correct");
        Assert.assertEquals("Nha Trang", bookTicketSuccessfullyPage.getValueOfTxt("Arrive Station"), "The information is not correct");
        Assert.assertEquals("Soft bed with air conditioner", bookTicketSuccessfullyPage.getValueOfTxt("Seat Type"), "The information is not correct");
        Assert.assertEquals(1, Integer.parseInt(bookTicketSuccessfullyPage.getValueOfTxt("Amount")), "The information is not correct");
    }

}
