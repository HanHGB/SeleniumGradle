package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ChangePasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC09 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();
    private final ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @Test
    public void TC09() {
        System.out.println("TC09: User can change password");
        homePage.open();

        homePage.gotoLoginPage();
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        loginPage.gotoChangePasswordPage();
        changePasswordPage.changePassword(Constant.PASSWORD, "12345678", "12345678");

        String actualMsg = changePasswordPage.getChangePasswordMsg();
        String expectedMsg = "Your password has been updated!";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
