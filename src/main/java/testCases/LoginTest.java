package testCases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends BaseTest{

    //Declare
    private HomePage homePage = new HomePage();


    @Test
    public void TC01(){
        System.out.println("TC01: User can log into Railway with valid username and password");
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");
    }

    @Test
    public void TC02(){
        System.out.println("TC02: User can't login with blank Username textbox");
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login("", Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");
    }

    @Test
    public void TC03(){
        System.out.println("TC03: User cannot log into Railway with invalid password");
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login("", Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");
    }

    @Test
    public void TC04(){
        System.out.println("TC04: User can log into Railway with valid username and password");
        homePage.open();

        LoginPage loginPage = homePage.gotoLoginPage();
        String actualMsg = loginPage.login("", Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");
    }
}
