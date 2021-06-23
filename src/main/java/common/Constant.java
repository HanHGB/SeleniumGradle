package common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.WebDriver;

public class Constant {

    public static final String RAILWAY_URL = "http://railway2.somee.com/Page/HomePage.cshtml";
    public static WebDriver WEBDRIVER;
    public static ExtentReports REPORTS;
    public static ExtentTest LOGGER;
    public static ExtentSparkReporter HTML_REPORTER;

}
