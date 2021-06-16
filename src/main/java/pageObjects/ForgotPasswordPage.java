package pageObjects;

import common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {

    //Elements
    public WebElement getTxtEmailAddress() {
        return Constant.WEBDRIVER.findElement(By.xpath("//form//input[@id='email']"));
    }
    public WebElement getBtnSendInstructions() {
        return Constant.WEBDRIVER.findElement(By.xpath("//form//input[@type='submit']"));
    }
    public WebElement getLblEmailErrorMsg() {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='content']//li[@class='email']/label[@class='validation-error']"));
    }

    //Methods
    public ForgotPasswordPage forgotPassword(String email){
        this.getTxtEmailAddress().sendKeys(email);
        this.getBtnSendInstructions().click();
        return new ForgotPasswordPage();
    }
}
