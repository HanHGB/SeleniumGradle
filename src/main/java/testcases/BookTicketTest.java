package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class BookTicketTest extends BaseTest{

    //Declare
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private BookTicketPage bookTicketPage = new BookTicketPage();
    private BookTicketSuccessfullyPage bookTicketSuccessfullyPage = new BookTicketSuccessfullyPage();
    private TimetablePage timetablePage = new TimetablePage();

    @Test
    public void TC04(){
        System.out.println("TC04: Login page displays when un-logged User clicks on Book ticket tab");
        homePage.open();
        homePage.gotoBookTicketPage();

        String actualMsg = loginPage.getTitle();
        String expectedMsg = "Login Page";
        String tabTitle = Constant.WEBDRIVER.getTitle().toUpperCase();

        Assert.assertEquals(actualMsg, expectedMsg, "The Book Ticket Page is open when not logging yet");
        Assert.assertTrue(tabTitle.indexOf("Login".toUpperCase()) != 1);
    }

    @Test
    public void TC14(){
        System.out.println("TC014: User can book 1 ticket at a time");

        homePage.open();
        homePage.gotoLoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoBookTicketPage();
        bookTicketPage.bookTicket("6/25/2021", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", 1);

        String actualMsg = bookTicketSuccessfullyPage.getTitle();
        String expectedMsg = "Ticket booked successfully!";

        Assert.assertEquals(actualMsg, expectedMsg, "Message is not correct");
        Assert.assertEquals("6/25/2021", bookTicketSuccessfullyPage.getDepartDate(), "The information is not correct");
        Assert.assertEquals("Sài Gòn", bookTicketSuccessfullyPage.getDepartStation(), "The information is not correct");
        Assert.assertEquals("Nha Trang", bookTicketSuccessfullyPage.getArriveStation(), "The information is not correct");
        Assert.assertEquals("Soft bed with air conditioner", bookTicketSuccessfullyPage.getSeatType(), "The information is not correct");
        Assert.assertEquals(1, Integer.parseInt(bookTicketSuccessfullyPage.getAmountTicket()), "The information is not correct");
    }

    @Test
    public void TC16(){
        System.out.println("TC016: User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        homePage.open();
        homePage.gotoTimetablePage();
        timetablePage.bookTicket("Huế", "Sài Gòn");

        Assert.assertEquals("Huế", bookTicketPage.getValueOfDepartStation(), "The information is not correct");
        Assert.assertEquals("Sài Gòn", bookTicketPage.getValueOfArriveStation(), "The information is not correct");
    }
}
