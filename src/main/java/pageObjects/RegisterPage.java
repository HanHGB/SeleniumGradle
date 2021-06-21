package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Utilities.clearValueInTxt;
import static common.Utilities.scrollDownPage;

public class RegisterPage extends GeneralPage {

    //Elements
    protected WebElement getLinkLogin() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='/Account/Login.cshtml']"));
    }

    protected WebElement getLinkConfirmCode() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//a[@href='Confirm.cshtml']"));
    }

    protected WebElement getTxtName(String name) {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@id='" + name + "']"));
    }

    protected WebElement getBtnRegister() {
        return Constant.WEBDRIVER.findElement(By.xpath("//input[@type='submit']"));
    }

    protected WebElement getLblErrorMsg(String lbl) {
        return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='RegisterForm']//li[@class='" + lbl + "']/label[@class='validation-error']"));
    }

    protected WebElement getLblCreateAccountErrorMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p[@class='message error']"));
    }

    protected WebElement getLblRegisterMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']/p[@class='message error']"));
    }

    //Methods
    public void gotoLoginPage() {
        this.getLinkLogin().click();
    }

    public ConfirmCodePage gotoConfirmCodePage() {
        this.getLinkConfirmCode().click();
        return new ConfirmCodePage();
    }

    public void register(String email, String password, String confirmPassword, String pid) {

        clearValueInTxt(new WebElement[]{getTxtName("email"), getTxtName("password"), getTxtName("confirmPassword"), getTxtName("pid")});

        this.getTxtName("email").sendKeys(email);
        this.getTxtName("password").sendKeys(password);
        this.getTxtName("confirmPassword").sendKeys(confirmPassword);
        this.getTxtName("pid").sendKeys(pid);
        scrollDownPage(getBtnRegister());
        this.getBtnRegister().click();
    }

    public String getEmailErrorMsg() {
        return this.getLblErrorMsg("email").getText();
    }

    public String getPasswordErrorMsg() {
        return this.getLblErrorMsg("password").getText();
    }

    public String getConfirmPassErrorMsg() {
        return this.getLblErrorMsg("confirm-password").getText();
    }

    public String getPIDErrorMsg() {
        return this.getLblErrorMsg("pid-number").getText();
    }

    public String getCreateAccountErrorMsg() {
        return this.getLblCreateAccountErrorMsg().getText();
    }

    public String getRegisterMsg() {
        return this.getLblRegisterMsg().getText();
    }
}
