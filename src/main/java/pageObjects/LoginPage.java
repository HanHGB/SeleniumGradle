package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends GeneralPage {

    //Elements
    protected WebElement getTxtUsername() { return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='username']")); }
    protected WebElement getTxtPassword() { return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='password']")); }
    protected WebElement getBtnLogin() { return Constant.WEBDRIVER.findElement(By.xpath("//input[@value='Login']")); }
    protected WebElement getLblLoginErrorMsg() { return Constant.WEBDRIVER.findElement(By.xpath("//p[@class='message error LoginForm']")); }
    protected WebElement getLinkRegisterPage() { return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='Register.cshtml']")); }
    protected WebElement getLinkForgotPasswordPage() { return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/ForgotPassword.cshtml']")); }
    protected WebElement getLblEmailErrorMsg() { return Constant.WEBDRIVER.findElement(By.xpath("//li[@class='username']/label[@class='validation-error']")); }
    protected WebElement getLblPasswordErrorMsg() { return Constant.WEBDRIVER.findElement(By.xpath("//li[@class='password']/label[@class='validation-error']")); }

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

    public String getLoginErrorMsg(){
        return this.getLblLoginErrorMsg().getText();
    }

    public String getEmailErrorMsg(){
        return this.getLblEmailErrorMsg().getText();
    }

    public String getPasswordErrorMsg(){
        return this.getLblPasswordErrorMsg().getText();
    }
}