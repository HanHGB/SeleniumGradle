package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static common.Utilities.scrollDownPage;

public class ChangePasswordPage extends GeneralPage {

    //Elements
    protected WebElement getTxtName(String name) {
        return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='" + name + "']"));
    }

    protected WebElement getBtnChangePassword() {
        return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@type='submit']"));
    }

    protected WebElement getLblErrorMsg(String name) {
        return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='" + name + "']/label[@class='validation-error']"));
    }

    protected WebElement getLblChangePassMsg() {
        return Constant.WEBDRIVER.findElement(By.className("message"));
    }

    protected WebElement getLblTitle() {
        return Constant.WEBDRIVER.findElement(By.tagName("h1"));
    }

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword) {
        this.getTxtName("currentPassword").sendKeys(currentPassword);
        this.getTxtName("newPassword").sendKeys(newPassword);
        this.getTxtName("confirmPassword").sendKeys(confirmPassword);
        scrollDownPage(getBtnChangePassword());
        this.getBtnChangePassword().click();
    }

    public String getErrorMsg(String name) {
        return this.getLblErrorMsg(name).getText();
    }

    public String getChangePasswordMsg() {
        return this.getLblChangePassMsg().getText();
    }

    public String getTitle() {
        return this.getLblTitle().getText();
    }
}
