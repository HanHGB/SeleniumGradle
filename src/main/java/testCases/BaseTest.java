package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import static common.Constant.WEBDRIVER;

public class BaseTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Set up Webdriver");
        WebDriverManager.chromiumdriver().setup();
        WEBDRIVER = new ChromeDriver();
        WEBDRIVER.manage().window().maximize();
    }

    @AfterClass
    public void afterMethod() {
        System.out.println("Quit Webdriver");
        WEBDRIVER.quit();
    }
}
