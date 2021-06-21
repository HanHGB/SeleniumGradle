package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC07 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC07() {
        System.out.println("TC07: User can create new account");
        homePage.open();

        homePage.gotoRegisterPage();
        registerPage.register(Constant.EMAIL, Constant.PASSWORD_REGISTER, Constant.PASSWORD_REGISTER, Constant.PID);

        String actualMsg = registerPage.getRegisterMsg();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }

}
