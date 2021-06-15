package page.objects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Elements
    public WebElement getTxtUsername() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='username']"));
    }
    public WebElement getTxtPassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='password']"));
    }
    public WebElement getBtnLogin() { return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Login']")); }
    public WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']")); }
    public WebElement getLinkRegisterPage() { return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='Register.cshtml']")); }
    public WebElement getLinkForgotPasswordPage() { return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']")); }
    public WebElement getLblEmailErrorMsg() { return Constant.WEBDRIVER.findElement(By.xpath("//li[@class='username']/label[@class='validation-error']")); }
    public WebElement getLblPasswordErrorMsg() { return Constant.WEBDRIVER.findElement(By.xpath("//li[@class='password']/label[@class='validation-error']")); }

    //Methods
    public HomePage login(String username, String password) {

        //Submit login credentials
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();

        //Land on Hone page
        return new HomePage();
    }

    public RegisterPage gotoRegisterPage() {
        this.getLinkRegisterPage().click();
        return new RegisterPage();
    }

    public ForgotPasswordPage gotoForgotPasswordPage() {
        this.getLinkForgotPasswordPage().click();
        return new ForgotPasswordPage();
    }
}