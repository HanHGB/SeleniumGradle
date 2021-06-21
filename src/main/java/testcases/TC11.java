package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

public class TC11 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final RegisterPage registerPage = new RegisterPage();

    @Test
    public void TC11() {
        System.out.println("TC011: User can't create account while password and PID fields are empty");
        homePage.open();
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
