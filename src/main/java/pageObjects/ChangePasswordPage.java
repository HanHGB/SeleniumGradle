package pageObjects;

import common.Constant;
import common.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage {

    //Declare
    private Utilities utilities = new Utilities();

    //Elements
    protected WebElement getTxtCurrentPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='currentPassword']")); }
    protected WebElement getTxtNewPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='newPassword']")); }
    protected WebElement getTxtConfirmPassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@id='confirmPassword']")); }
    protected WebElement getBtnChangePassword(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//input[@type='submit']")); }
    protected WebElement getLblCurrentPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='current-password']/label[@class='validation-error']")); }
    protected WebElement getLblNewPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='new-password']/label[@class='validation-error']")); }
    protected WebElement getLblConfirmPassErrorMsg(){ return Constant.WEBDRIVER.findElement(By.xpath("//form[@id='ChangePW']//li[@class='confirm-password']/label[@class='validation-error']")); }
    protected WebElement getLblChangePassMsg(){ return Constant.WEBDRIVER.findElement(By.className("message"));}
    protected WebElement getLblTitle() { return Constant.WEBDRIVER.findElement(By.tagName("h1")); }

    //Methods
    public void changePassword(String currentPassword, String newPassword, String confirmPassword){
        this.getTxtCurrentPassword().sendKeys(currentPassword);
        this.getTxtNewPassword().sendKeys(newPassword);
        this.getTxtConfirmPassword().sendKeys(confirmPassword);
        utilities.scrollDownPage(getBtnChangePassword());
        this.getBtnChangePassword().click();
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

    public String getChangePasswordMsg(){
        return this.getLblChangePassMsg().getText();
    }

    public String getTitle() { return this.getLblTitle().getText(); }
}
