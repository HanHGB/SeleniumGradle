package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static common.Constant.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        HTML_REPORTER = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/main/resources/report.html");
        REPORTS = new ExtentReports();
        REPORTS.attachReporter(HTML_REPORTER);
        HTML_REPORTER.config().setDocumentTitle("Result of TCs");
        HTML_REPORTER.config().setReportName("Result");
        HTML_REPORTER.config().setTheme(Theme.DARK);
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
        WEBDRIVER.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            LOGGER.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getName() + " - Test case Failed", ExtentColor.RED));
            LOGGER.log(Status.FAIL, MarkupHelper.createLabel(iTestResult.getThrowable() + " - Test Case Failed", ExtentColor.RED));

            String base64Screenshot = ((TakesScreenshot) Objects.requireNonNull(WEBDRIVER)).getScreenshotAs(OutputType.BASE64);
            LOGGER.log(Status.INFO, "Image: " + LOGGER.addScreenCaptureFromBase64String(base64Screenshot));
        } else if (iTestResult.getStatus() == ITestResult.SKIP) {
            LOGGER.log(Status.SKIP, MarkupHelper.createLabel(iTestResult.getName() + " - Test Case Skip", ExtentColor.ORANGE));
        } else if (iTestResult.getStatus() == ITestResult.SUCCESS) {
            LOGGER.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName() + " - Test Case Pass", ExtentColor.GREEN));
        }
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Quit Webdriver");
        WEBDRIVER.quit();
    }

    @AfterSuite
    public void afterSuite() {
        REPORTS.flush();
    }
}
