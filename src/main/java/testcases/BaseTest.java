package testcases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.Objects;

import static common.Constant.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        REPORTS = new ExtentReports(System.getProperty("user.dir") + "/src/main/resources/result.html");
        REPORTS.loadConfig(new File(System.getProperty("user.dir") + "/src/main/resources/extent-config.xml"));
    }

    @BeforeClass
    @Parameters("browser")
    public void beforeClass(String browser) throws Exception {
        System.out.println("Set up Webdriver");

        if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            WEBDRIVER = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            WEBDRIVER = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            WEBDRIVER = new EdgeDriver();
        } else {
            throw new Exception("Browser is not correct");
        }
        WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) {
        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            LOGGER.log(LogStatus.FAIL, "Test Case Fail: " + iTestResult.getName());
            String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(WEBDRIVER)).getScreenshotAs(OutputType.BASE64);
            LOGGER.log(LogStatus.INFO, "Image: " + LOGGER.addBase64ScreenShot(base64Screenshot));
        } else if (iTestResult.getStatus() == ITestResult.SKIP) {
            LOGGER.log(LogStatus.SKIP, "Test Case Skip: " + iTestResult.getName());
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            LOGGER.log(LogStatus.PASS, "Test Case pass: " + iTestResult.getName());
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Quit Webdriver");
        WEBDRIVER.quit();
    }

    @AfterSuite
    public void afterSuite() {
        REPORTS.endTest(LOGGER);
        REPORTS.flush();
    }
}
