package testcases;


import common.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import page.objects.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    @BeforeTest
    public void beforeMethod() {
        System.out.println("Pre-condition");
        WebDriverManager.chromiumdriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @Test
    public void TC03() {
        System.out.println("TC03: User can login with valid account");
        HomePage homePage = new HomePage();
        homePage.open();

//        LoginPage loginPage = homePage.gotoLoginPage();
//
//        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
//        String expectedMsg = "Welcome " + Constant.USERNAME;
//
//        Assert.assertEquals(actualMsg, expectedMsg, "Welcome msg is not correctly");

        homePage.gotoTimetable();

        TimetablePage timetablePage = new TimetablePage();
        timetablePage.gotoBookTicketPage("Nha Trang", "Đà Nẵng");

    }

    @AfterTest
    public void afterMethod() {
        System.out.println("Post-condition");

        Constant.WEBDRIVER.quit();
    }
}