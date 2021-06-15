package page.objects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {

    //Elements
    public WebElement getLinkLogin(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/Login.cshtml']")); }
    public WebElement getLinkConfirmCode(){ return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='Confirm.cshtml']")); }
    public WebElement getTxtEmail(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='email']")); }
    public WebElement getTxtPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='password']")); }
    public WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='confirmPassword']")); }
    public WebElement getTxtPID(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='pid']")); }
    public WebElement getBtnRegister(){ return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']")); }

    //Methods
    public LoginPage gotoLoginPage(){
        this.getLinkLogin().click();
        return new LoginPage();
    }

    public ConfirmCodePage gotoConfirmPasswordPage(){
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
}