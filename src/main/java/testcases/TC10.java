package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC10 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC10() {
        System.out.println("TC010: User can't create account with \"Confirm password\" is not the same with \"Password\"");

        homePage.open();
        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL, Constant.PASSWORD_REGISTER, "123123222", Constant.PID);

        String actualMsg = registerPage.getRegisterMsg();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
