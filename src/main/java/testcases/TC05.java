package testcases;

import common.Constant;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC05 extends BaseTest {

    //Declare
    private final HomePage homePage = new HomePage();
    private final LoginPage loginPage = new LoginPage();

    @Test
    public void TC05() {
        System.out.println("TC05: System shows message when user enters wrong password several times");
        homePage.open();

        homePage.gotoLoginPage();
        for (int i = 0; i < 4; i++)
            loginPage.login(Constant.USERNAME, "123456789");

        String actualMsg = loginPage.getLoginErrorMsg();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Msg is not correctly");
    }
}
