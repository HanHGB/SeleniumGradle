package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyTicketPage;

public class TabNameTest extends BaseTest{

    //Declare
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();
    private MyTicketPage myTicketPage = new MyTicketPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();

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
    public void TC06(){
        System.out.println("TC06: Additional pages display once user logged in");
        homePage.open();

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);

        //Check "My ticket", "Change password" and "Logout" tabs are displayed
        Assert.assertTrue(homePage.getTabName("My ticket"));
        Assert.assertTrue(homePage.getTabName("Change password"));
        Assert.assertTrue(homePage.getTabName("Log out"));

        //Check my ticket page is displayed
        homePage.gotoMyTicketPage();
        Assert.assertEquals(myTicketPage.getTitle(), "Manage Tickets", "The My ticket Page is not opened");
        Assert.assertTrue(Constant.WEBDRIVER.getTitle().toUpperCase().indexOf("My Ticket".toUpperCase()) != 1);

        //Check change password page is displayed
        homePage.gotoChangePasswordPage();
        Assert.assertEquals(changePasswordPage.getTitle(), "Change password", "The My ticket Page is not opened");
        Assert.assertTrue(Constant.WEBDRIVER.getTitle().toUpperCase().indexOf("Change password".toUpperCase()) != 1);
    }


}
