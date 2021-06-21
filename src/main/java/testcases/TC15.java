package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class TC15 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final BookTicketPage bookTicketPage = new BookTicketPage();
    private final BookTicketSuccessfullyPage bookTicketSuccessfullyPage = new BookTicketSuccessfullyPage();
    private final TimetablePage timetablePage = new TimetablePage();

    @Test
    public void TC15() {
        System.out.println("TC15: User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        homePage.gotoTimetablePage();
        timetablePage.bookTicket("Huế", "Sài Gòn");

        Assert.assertEquals("Huế", bookTicketPage.getValueOfDepartStation(), "The information is not correct");
        Assert.assertEquals("Sài Gòn", bookTicketPage.getValueOfArriveStation(), "The information is not correct");
    }
}
