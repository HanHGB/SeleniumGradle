package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

public class RegisterTest extends BaseTest{

    //Declare
    private HomePage homePage = new HomePage();
    private RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07(){
        System.out.println("TC07: User can create new account");
        homePage.open();

        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL, Constant.PASSWORD_REGISTER, Constant.PASSWORD_REGISTER, Constant.PID);

        String actualMsg = registerPage.getRegisterMsg();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

    @Test
    public void TC10(){
        System.out.println("TC010: User can't create account with \"Confirm password\" is not the same with \"Password\"");

        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL, Constant.PASSWORD_REGISTER, "123123222", Constant.PID);

        String actualMsg = registerPage.getRegisterMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

    @Test
    public void TC11(){
        System.out.println("TC011: User can't create account while password and PID fields are empty");

        registerPage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL, "", "", "");

        String actualRegisterMsg = registerPage.getRegisterMsg();
        String expectedRegisterMsg = "There're errors in the form. Please correct the errors and try again.";
        String actualPasswordMsg = registerPage.getPasswordErrorMsg();
        String expectedPasswordMsg = "Invalid password length.";
        String actualPIDMsg = registerPage.getRegisterMsg();
        String expectedPIDMsg = "Invalid ID length.";

        Assert.assertEquals(actualRegisterMsg, expectedRegisterMsg, "Msg is not correctly");
        Assert.assertEquals(actualPasswordMsg, expectedPasswordMsg, "Msg is not correctly");
        Assert.assertEquals(actualPIDMsg, expectedPIDMsg, "Msg is not correctly");
    }
}
