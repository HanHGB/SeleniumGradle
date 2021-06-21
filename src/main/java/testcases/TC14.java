package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.BookTicketPage;
import pageObjects.BookTicketSuccessfullyPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC14 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final BookTicketSuccessfullyPage bookTicketSuccessfullyPage = new BookTicketSuccessfullyPage();

    @Test
    public void TC14() {
        System.out.println("TC014: User can book 1 ticket at a time");

        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("6/25/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", 1);

        String actualMsg = bookTicketSuccessfullyPage.getTitle();
        String expectedMsg = "Ticket Booked Successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Message is not correct");
        Assert.assertEquals("6/25/2021", bookTicketSuccessfullyPage.getValueOfTxt("Depart Date"), "The information is not correct");
        Assert.assertEquals("Sài Gòn", bookTicketSuccessfullyPage.getValueOfTxt("Depart Station"), "The information is not correct");
        Assert.assertEquals("Nha Trang", bookTicketSuccessfullyPage.getValueOfTxt("Arrive Station"), "The information is not correct");
        Assert.assertEquals("Soft bed with air conditioner", bookTicketSuccessfullyPage.getValueOfTxt("Seat Type"), "The information is not correct");
        Assert.assertEquals(1, Integer.parseInt(bookTicketSuccessfullyPage.getValueOfTxt("Amount")), "The information is not correct");
    }

}
