package testcases;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dataObjects.Ticket;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.HomePage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

import static common.Constant.*;

public class BaseTest {

    private final HomePage homePage = new HomePage();

    @BeforeSuite
    public void beforeSuite() {
        HTML_REPORTER = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/main/resources/report_Firefox.html");
        REPORTS = new ExtentReports();
        REPORTS.attachReporter(HTML_REPORTER);
        HTML_REPORTER.config().setDocumentTitle("Result of TCs");
        HTML_REPORTER.config().setReportName("Result");
        HTML_REPORTER.config().setTheme(Theme.STANDARD);
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

    @DataProvider(name = "dataset")
    public Object[] getData() throws FileNotFoundException {

        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader("src/main/java/dataObjects/ticketData.json");

        Object object = jsonParser.parse(reader);

        JsonObject dataset = (JsonObject) object;
        JsonArray ticketInfo = (JsonArray) dataset.get("dataset");

        Object[] array = new Ticket[ticketInfo.size()];

        for (int index = 0; index < ticketInfo.size(); index++) {
            JsonObject info = (JsonObject) ticketInfo.get(index);
            String departDate = info.get("departDate").getAsString();
            String departStation = info.get("departStation").getAsString();
            String arriveStation = info.get("arriveStation").getAsString();
            String seatType = info.get("seatType").getAsString();
            String ticketAmount = info.get("ticketAmount").getAsString();

            array[index] = new Ticket(departDate, departStation, arriveStation, seatType, Integer.parseInt(ticketAmount));
        }
        return array;
    }
}
