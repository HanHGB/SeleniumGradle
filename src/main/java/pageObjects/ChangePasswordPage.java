package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Elements
    protected WebElement getTxtCurrentPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='currentPassword']")); }
    protected WebElement getTxtNewPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='newPassword']")); }
    protected WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='confirmPassword']")); }
    protected WebElement getBtnChangePassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@value='Change password']")); }
    protected WebElement getLblCurrentPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='current-password']/label[@class='validation-error']")); }
    protected WebElement getLblNewPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='new-password']/label[@class='validation-error']")); }
    protected WebElement getLblConfirmPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='confirm-password']/label[@class='validation-error']")); }
    protected WebElement getLblChangePassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//p[@class='message error']"));}

    //Methods
    public ChangePasswordPage changePassword(String currentPassword, String newPassword, String confirmPassword){
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
        return new ChangePasswordPage();
    }

    public String getCurrentPasswordErrorMsg(){
        return this.getLblCurrentPassErrorMsg().getText();
    }

    public String getNewPasswordErrorMsg(){
        return this.getLblNewPassErrorMsg().getText();
    }

    public String getConfirmPasswordErrorMsg(){
        return this.getLblConfirmPassErrorMsg().getText();
    }

    public String getChangePasswordErrorMsg(){
        return this.getLblChangePassErrorMsg().getText();
    }
}
