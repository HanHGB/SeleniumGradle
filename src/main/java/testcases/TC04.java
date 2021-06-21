package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;

public class TC04 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();

    @Test
    public void TC04() {
        System.out.println("TC04: Login page displays when un-logged User clicks on Book ticket tab");
        homePage.open();
        homePage.gotoBookTicketPage();

        String tabTitle = Constant.WEBDRIVER.getTitle().toUpperCase();

        Assert.assertTrue(tabTitle.indexOf("Login".toUpperCase()) != 1, "The Book Ticket Page is open when not logging yet");
    }

}
