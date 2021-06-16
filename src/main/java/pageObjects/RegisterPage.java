package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Elements
    protected WebElement getLinkLogin(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/Login.cshtml']")); }
    protected WebElement getLinkConfirmCode(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='Confirm.cshtml']")); }
    protected WebElement getTxtEmail(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='email']")); }
    protected WebElement getTxtPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='password']")); }
    protected WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='confirmPassword']")); }
    protected WebElement getTxtPID(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='pid']")); }
    protected WebElement getBtnRegister(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']")); }
    protected WebElement getLblEmailErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='RegisterForm']//li[@class='email']/label[@class='validation-error']")); }
    protected WebElement getLblPasswordErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='RegisterForm']//li[@class='password']/label[@class='validation-error']")); }
    protected WebElement getLblConfirmPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='RegisterForm']//li[@class='confirm-password']/label[@class='validation-error']")); }
    protected WebElement getLblPIDErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='RegisterForm']//li[@class='pid-number']/label[@class='validation-error']")); }
    protected WebElement getLblCreateAccountErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p[@class='message error']")); }

    //Methods
    public LoginPage gotoLoginPage(){
        this.getLinkLogin().click();
        return new LoginPage();
    }

    public ConfirmCodePage gotoConfirmCodePage(){
        this.getLinkConfirmCode().click();
        return new ConfirmCodePage();
    }

    public HomePage register(String email, String password, String confirmPassword, String PID){
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getTxtPID().sendKeys(PID);
        this.getBtnRegister().click();

        return new HomePage();
    }

    public String getEmailErrorMsg(){
        return this.getLblEmailErrorMsg().getText();
    }

    public String getPasswordErrorMsg(){
        return this.getLblPasswordErrorMsg().getText();
    }

    public String getConfirmPassErrorMsg(){
        return this.getLblConfirmPassErrorMsg().getText();
    }

    public String getPIDErrorMsg(){
        return this.getLblPIDErrorMsg().getText();
    }

    public String getCreateAccountErrorMsg(){
        return this.getLblCreateAccountErrorMsg().getText();
    }
}
