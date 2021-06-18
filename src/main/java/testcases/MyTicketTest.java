package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class MyTicketTest extends BaseTest {

    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC16() {
        System.out.println("TC016: User can open \"Book ticket\" page by clicking on \"Book ticket\" link in \"Train timetable\" page");

        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoMyTicketPage();
        myTicketPage.cancelTicket("Sài Gòn", "Phan Thiết", "Hard seat", "", "", "", "");

        Assert.assertFalse(myTicketPage.findTicket("Sài Gòn", "Phan Thiết", "Hard seat", "6/20/2021", "", "", ""));
    }
}
