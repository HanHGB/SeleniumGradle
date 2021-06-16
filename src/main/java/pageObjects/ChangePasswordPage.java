package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Elements
    public WebElement getTxtCurrentPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='currentPassword']")); }
    public WebElement getTxtNewPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='newPassword']")); }
    public WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='confirmPassword']")); }
    public WebElement getBtnChangePassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@value='Change password']")); }
    public WebElement getLblCurrentPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='current-password']/label[@class='validation-error']")); }
    public WebElement getLblNewPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='new-password']/label[@class='validation-error']")); }
    public WebElement getLblConfirmPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='confirm-password']/label[@class='validation-error']")); }
    public WebElement getLblChangePassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//p[@class='message error']"));}

    //Methods
    public ChangePasswordPage changePassword(String currentPassword, String newPassword, String confirmPassword){
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        this.getBtnChangePassword().click();
        return new ChangePasswordPage();
    }
}
