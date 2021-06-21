package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class TC16 extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final MyTicketPage myTicketPage = new MyTicketPage();

    @Test
    public void TC16() {
        System.out.println("TC16: User can cancel a ticket");

        homePage.open();
        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoMyTicketPage();
        myTicketPage.cancelTicket("Sài Gòn", "Phan Thiết", "Hard seat", "", "", "", "");

        Assert.assertFalse(myTicketPage.findTicket("Sài Gòn", "Phan Thiết", "Hard seat", "6/20/2021", "", "", ""));
    }
}
