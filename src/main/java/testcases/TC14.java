package testcases;

import com.aventstack.extentreports.Status;
import dataObjects.Ticket;
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

    @Test(dataProvider = "dataset")
    public void TC14(Ticket ticket) throws InterruptedException {

        LOGGER = REPORTS.createTest("TC14", "User can book 1 ticket at a time");
        LOGGER.log(Status.INFO, "Step #1: Navigate to QA Railway Website");
        homePage.open();

        if (homePage.findTab("Login") == false)
            homePage.logout();

        LOGGER.log(Status.INFO, "Step #2: Click on \"Login\" tab");
        homePage.gotoLoginPage();

        LOGGER.log(Status.INFO, "Step #3: Login with a valid account");
        loginPage.login(System.getenv("username"), System.getenv("password"));

        LOGGER.log(Status.INFO, "Step #4: Click on \"Book ticket\" tab");
        homePage.gotoBookTicketPage();

        LOGGER.log(Status.INFO, "Step #5: Select a \"Depart date\" from the list");
        LOGGER.log(Status.INFO, "Step #6: Select \"Sài Gòn\" for \"Depart from\" and \"Nha Trang\" for \"Arrive at\".");
        LOGGER.log(Status.INFO, "Step #7: Select \"Soft bed with air conditioner\" for \"Seat type\"");
        LOGGER.log(Status.INFO, "Step #8: Select \"1\" for \"Ticket amount\"");
        LOGGER.log(Status.INFO, "Step #9: Click on \"Book ticket\" button");
        bookTicketPage.bookTicket(ticket.getDepartDate(), ticket.getDepartStation(), ticket.getArriveStation(), ticket.getSeatType(), ticket.getTicketAmount());

        String actualMsg = bookTicketSuccessfullyPage.getTitle();
        String expectedMsg = "Ticket Booked Successfully!";

        LOGGER.log(Status.INFO, "Checkpoint: Message \"Ticket booked successfully!\" displays. Ticket information display correctly (Depart Date,  Depart Station,  Arrive Station,  Seat Type,  Amount)");
        Assert.assertEquals(actualMsg, expectedMsg, "Message is not correct");
        Assert.assertEquals(ticket.getDepartDate(), bookTicketSuccessfullyPage.getValueOfTxt("Depart Date"), "The information is not correct");
        Assert.assertEquals(ticket.getDepartStation(), bookTicketSuccessfullyPage.getValueOfTxt("Depart Station"), "The information is not correct");
        Assert.assertEquals(ticket.getArriveStation(), bookTicketSuccessfullyPage.getValueOfTxt("Arrive Station"), "The information is not correct");
        Assert.assertEquals(ticket.getSeatType(), bookTicketSuccessfullyPage.getValueOfTxt("Seat Type"), "The information is not correct");
        Assert.assertEquals(ticket.getTicketAmount(), Integer.parseInt(bookTicketSuccessfullyPage.getValueOfTxt("Amount")), "The information is not correct");

    }
}
