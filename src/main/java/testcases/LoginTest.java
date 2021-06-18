package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.lang.reflect.Method;

import static common.utils.extentReports.ExtentTestManager.startTest;

public class LoginTest extends BaseTest {

    //Declare
    private HomePage homePage = new HomePage();
    private LoginPage loginPage = new LoginPage();

    @Test
    public void TC01(Method method) {
        startTest(method.getName(), "User can log into Railway with valid username and password");
        homePage.open();

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = loginPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");
    }

    @Test
    public void TC02(Method method) {
        System.out.println("TC02: User can't login with blank Username textbox");
        startTest(method.getName(), "User can't login with blank Username textbox");

        homePage.logout();

        homePage.gotoLoginPage();
        loginPage.login("", Constant.PASSWORD);
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

    @Test
    public void TC03(Method method) {
        System.out.println("TC03: User cannot log into Railway with invalid password");
        startTest(method.getName(), "User can't login with blank Username text box");

        loginPage.login(Constant.USERNAME, "");
        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

    @Test
    public void TC05(Method method) {
        System.out.println("TC05: System shows message when user enters wrong password several times");
        startTest(method.getName(), "System shows message when user enters wrong password several times");

        for (int i = 0; i < 4; i++)
            loginPage.login(Constant.USERNAME, "123456789");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

}
